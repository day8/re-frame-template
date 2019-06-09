(ns {{ns-name}}.events
  (:require
   [re-frame.core :as re-frame]
   [{{ns-name}}.db :as db]{{#10x?}}
   [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]{{/10x?}}
   ))

(re-frame/reg-event-db
 ::initialize-db
 ({{^10x?}}fn{{/10x?}}{{#10x?}}fn-traced{{/10x?}} [_ _]
   db/default-db))
{{#routes?}}

(re-frame/reg-event-db
 ::set-active-panel
 ({{^10x?}}fn{{/10x?}}{{#10x?}}fn-traced{{/10x?}} [db [_ active-panel]]
   (assoc db :active-panel active-panel)))
{{/routes?}}
{{#re-pressed?}}

(re-frame/reg-event-db
 ::set-re-pressed-example
 (fn [db [_ value]]
   (assoc db :re-pressed-example value)))
{{/re-pressed?}}
{{#http-fx?}}

(re-frame/reg-event-db
  ::generic-http-in-wait
  (fn [_ [_ req]]
    (let [{:http/keys [request-id]} req]
      (assoc db :request-id request-id))))

(re-frame/reg-event-fx
  ::generic-http-in-problem
  (fn [_ [_ {:http/keys [context] :as req} {:http/keys [status] :as res} {:http/keys [failure] :as err}]]
   (let [temporary? (or (= :timeout failure)
                        (= 503 status))
         max-retries (get context :max-retries 0)
         retry-count (get context :retry-count 0)
         path        (get context :path)
         try-again? (and (< retry-count max-retries) temporary?)]
     (if try-again?
       (let [re-request (-> request
                            (assoc-in [:http/context :retry-count] (inc retry-count))
                            (assoc :http/with-profile :none))]
         {:http re-request
          :db (assoc-in db (conj path :message) "Taking a bit longer than expected...")})
       {:http {:http/transition :failed
               :http/request    request}}))))

(re-frame/reg-event-fx
  ::generic-http-in-wait
  (fn [_ [_ {:http/keys [context] :as req}]]

    ))
{{/http-fx?}}

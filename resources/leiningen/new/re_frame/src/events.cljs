(ns {{ns-name}}.events
  (:require
   [re-frame.core :as re-frame]{{#re-pressed?}}
   [re-pressed.core :as rp]{{/re-pressed?}}
   [{{ns-name}}.db :as db]{{#10x?}}
   [day8.re-frame.tracing :refer-macros [fn-traced]]{{/10x?}}
   ))

(re-frame/reg-event-db
 ::initialize-db
 ({{^10x?}}fn{{/10x?}}{{#10x?}}fn-traced{{/10x?}} [_ _]
   db/default-db))
{{#routes?}}

(re-frame/reg-event-fx
  ::navigate
  ({{^10x?}}fn{{/10x?}}{{#10x?}}fn-traced{{/10x?}} [_ [_ handler]]
   {:navigate handler}))

(re-frame/reg-event-fx
 ::set-active-panel
 ({{^10x?}}fn{{/10x?}}{{#10x?}}fn-traced{{/10x?}} [{:keys [db]} [_ active-panel]]
   {:db (assoc db :active-panel active-panel){{#re-pressed?}}
    :dispatch [::rp/set-keydown-rules
               {:event-keys [[[::set-re-pressed-example "Hello, world!"]
                              [{:keyCode 72} ;; h
                               {:keyCode 69} ;; e
                               {:keyCode 76} ;; l
                               {:keyCode 76} ;; l
                               {:keyCode 79} ;; o
                               ]]]
                :clear-keys
                [[{:keyCode 27} ;; escape
                  ]]}]{{/re-pressed?}}}))
{{/routes?}}
{{#re-pressed?}}

(re-frame/reg-event-db
 ::set-re-pressed-example
 (fn [db [_ value]]
   (assoc db :re-pressed-example value)))
{{/re-pressed?}}

(ns {{ns-name}}.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as rf]
   [breaking-point.core :as bp]
   [re-pressed.core :as rp]
   [day8.re-frame.async-flow-fx] ;; to include fx
   [{{ns-name}}.config :as config]
   [{{ns-name}}.db :as db]
   [{{ns-name}}.cofx] ;; to include cofxs
   [{{ns-name}}.fx] ;; to include fxs
   [{{ns-name}}.pages.bundle :as pages]
   ))



(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (reagent/render [pages/current-page]
                  (.getElementById js/document "app")))


(defn ^:export init []
  (rf/reg-event-db ::initialize-db (fn [_ _] db/default-db))
  (rf/dispatch-sync [::initialize-db])
  (rf/dispatch-sync [::rp/add-keyboard-event-listener "keydown"])
  (rf/dispatch-sync [::bp/set-breakpoints
                     {:breakpoints [:mobile
                                    768
                                    :tablet
                                    992
                                    :small-monitor
                                    1200
                                    :large-monitor]
                      :debounce-ms 166}])
  (pages/routes-start!)
  (dev-setup)
  (mount-root))

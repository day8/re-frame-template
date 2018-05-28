(ns {{ns-name}}.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]{{#re-pressed?}}
   [re-pressed.core :as rp]{{/re-pressed?}}
   [{{ns-name}}.events :as events]{{#routes?}}
   [{{ns-name}}.routes :as routes]{{/routes?}}
   [{{ns-name}}.views :as views]
   [{{ns-name}}.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []{{#routes?}}
  (routes/app-routes){{/routes?}}
  (re-frame/dispatch-sync [::events/initialize-db]){{#re-pressed?}}
  (re-frame/dispatch-sync [::rp/add-keyboard-event-listener "keydown"]){{/re-pressed?}}
  (dev-setup)
  (mount-root))

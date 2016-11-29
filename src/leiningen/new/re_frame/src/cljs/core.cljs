(ns {{ns-name}}.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]{{#re-frisk?}}
              [re-frisk.core :refer [enable-re-frisk!]]{{/re-frisk?}}
              [{{ns-name}}.events]
              [{{ns-name}}.subs]{{#routes?}}
              [{{ns-name}}.routes :as routes]{{/routes?}}
              [{{ns-name}}.views :as views]
              [{{ns-name}}.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!){{#re-frisk?}}
    (enable-re-frisk!){{/re-frisk?}}
    (println "dev mode")))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []{{#routes?}}
  (routes/app-routes){{/routes?}}
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))

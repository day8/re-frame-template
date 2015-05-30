(ns {{ns-name}}.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [{{ns-name}}.handlers]
              [{{ns-name}}.subs]{{#routes?}}
              [{{ns-name}}.routes :as routes]{{/routes?}}
              [{{ns-name}}.views :as views]))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] {{#routes?}}
  (routes/app-routes){{/routes?}}
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))

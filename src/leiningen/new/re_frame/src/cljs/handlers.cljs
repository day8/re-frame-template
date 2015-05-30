(ns {{ns-name}}.handlers
    (:require [re-frame.core :as re-frame]
              [{{ns-name}}.db :as db]))

(re-frame/register-handler
 :initialize-db
 (fn  [_ _]
   db/default-db))
{{#routes?}}

(re-frame/register-handler
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))
{{/routes?}}

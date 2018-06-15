(ns {{ns-name}}.pages.home.event-handlers
  (:require
   [{{ns-name}}.db :as db]
   [{{ns-name}}.shared.navigation.subs :as ns]
   ))


(defn set-re-pressed-example
  [{db :db} [_ page-key value]]
  {:db (assoc-in db
                 [db/bin-prefix
                  page-key
                  :re-pressed-example]
                 value)})

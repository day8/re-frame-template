(ns {{ns-name}}.shared.bin.event-handlers
  (:require
   [{{ns-name}}.db :as db]))



(defn reset-bin
  [{db :db} [_ page bin]]
  {:db (assoc-in db
                 [db/bin-prefix
                  page]
                 bin)})

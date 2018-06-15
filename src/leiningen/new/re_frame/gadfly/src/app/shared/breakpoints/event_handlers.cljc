(ns {{ns-name}}.shared.breakpoints.event-handlers
  (:require
   [{{ns-name}}.db :as db]))



(defn set-page-width
  [{:keys [db
           page-width]} _]
  {:db (assoc-in db
                 [db/breakpoints-prefix :page-width]
                 page-width)})

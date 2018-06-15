(ns {{ns-name}}.shared.navigation.event-handlers
  (:require
   [{{ns-name}}.db :as db]))



(defn navigate
  [_ [_ id params query]]
  {:navigate [id params query]})


(defn set-active-page
  [{:keys [db]} [_ active-page]]
  {:db (assoc-in db
                 [db/navigation-prefix :active-page]
                 active-page)})

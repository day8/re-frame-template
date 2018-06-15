(ns {{ns-name}}.shared.navigation.sub-handlers
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.db :as db]))



(defn get-active-page
  [db]
  (get-in db [db/navigation-prefix :active-page]))

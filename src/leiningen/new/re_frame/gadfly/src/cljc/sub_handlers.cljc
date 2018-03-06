(ns {{ns-name}}.sub-handlers)


(defn ->active-page [db _]
  (get-in db [:app :page-key]))

(defn ->active-surface [db _]
  (get-in db [:app :surface-key]))

(defn ->page-width [db _]
  (get-in db [:app :page-width]))

(ns {{ns-name}}.event-handlers)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; db

(defn initialize-db
  [_ _]
  {})


(defn set-active-page
  [db [_ active-page-key]]
  (-> db
      (assoc-in [:app :page-key] active-page-key)
      (assoc-in [:app :surface-key] (when active-page-key
                                      :init))))


(defn set-active-surface
  [db [_ active-surface-key]]
  (assoc-in db [:app :surface-key]
            (if (keyword? active-surface-key)
              active-surface-key
              (some-> active-surface-key name keyword))))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; fx

(defn set-hash
  [_ [_ hash]]
  {:set-hash hash})


(defn set-page-width
  [{:keys [db
           page-width]} _]
  {:db (assoc-in db [:app :page-width] page-width)})

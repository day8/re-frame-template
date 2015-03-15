(ns {{name}}.handlers
  (:require [{{name}}.db :refer [default-value]]
            [re-frame.core :refer [register-handler path trim-v]]))


;; -- Middleware --------------------------------------------------------------


;; -- Helpers -----------------------------------------------------------------


;; -- Handlers ----------------------------------------------------------------

(register-handler                 ;; disptached to on app startup
  :initialise-db                  ;; event id being handled
  (fn  [_ _]                      ;; the handler
    default-value))               ;; all hail the new state


(register-handler                 ;; handlers changes the footer filter
  :set-showing                    ;; event-id
  [(path :showing) trim-v]        ;; middleware  (wraps the handler)
  (fn                             ;; handler
    [db [filter-kw]]
    filter-kw))

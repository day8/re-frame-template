(ns {{name}}.handlers
  (:require [{{name}}.db :refer [default-value valid-schema?]]
            [re-frame.core :refer [register-handler path trim-v]]))


;; -- Middleware --------------------------------------------------------------
;; See:  https://github.com/Day8/re-frame/wiki/Debugging-Event-Handlers
;;
(def standard-middlewares
  [trim-v
   ;; (if goog.DEBUG log-ex)    ;; will be available in v0.3.0
   (when goog.DEBUG [debug (after db/valid-schema?)]))

;; -- Helpers -----------------------------------------------------------------


;; -- Handlers ----------------------------------------------------------------

(register-handler                 ;; disptached to on app startup
  :initialise-db                  ;; event id being handled
  (fn  [_ _]                      ;; the handler
    default-value))               ;; all hail the new state


(register-handler                 ;; handlers changes the footer filter
  :set-showing                    ;; event-id
  [standard-middlewares (path :showing)]
  (fn                             ;; handler
    [db [filter-kw]]
    filter-kw))

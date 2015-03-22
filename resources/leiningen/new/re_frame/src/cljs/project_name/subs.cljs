(ns {{name}}.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))


;; -- Helpers -----------------------------------------------------------------


;; -- Subscription handlers and registration  ---------------------------------

(register-sub
  :initialised?     ;; usage (subscribe [:initialised?])
  (fn  [db]
    (reaction (not (empty? @db)))))  ;; do we have data?


(register-sub
  :name              ;; usage (subscribe [:name])
  (fn  [db]
    (reaction (:name @db))))

(ns {{ns-name}}.db
  (:require
   [cljs.spec.alpha :as spec]))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; app

(spec/def ::width int?)
(spec/def ::page-key keyword?)
(spec/def ::surface-key keyword?)

(spec/def ::app
  (spec/keys :opt-un [::width
                      ::page-key
                      ::surface-key]))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; db

(spec/def ::db
  (spec/keys :opt-un [::app]))

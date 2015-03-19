(ns {{name}}.db
  (:require
      [schema.core :as s]))


;; -- Prismatic Schema  -------------------------------------------------------
;; As exactly as possible, describe the correct shape of app-db
;; Add a lot of helpful comments. This will be an important resource
;; for anyone looking at the app for the first time.
(def schema
  {:name     s/Str})


(defn valid-schema?
  "validate given db, writing any problems to console.error"
  [db]
  (let [res (s/check schema db)]
    (if (some? res)
      (.error js/console (str "schema problem: " res)))))


;; -- Default Value  ----------------------------------------------------------
;; The initial value loaded into app-dp
;;
(def default-value
  {:name "re-frame"})



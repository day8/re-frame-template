(ns {{ns-name}}.shared.bin.sub-handlers
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.db :as db]
   ))



(defn get-bins
  [db]
  (get db db/bin-prefix))


(defn get-bin
  [[bins active-page] [_ path]]
  (get-in bins
          (or path
              [active-page])
          {}))

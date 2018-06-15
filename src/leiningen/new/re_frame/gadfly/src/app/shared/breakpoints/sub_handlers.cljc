(ns {{ns-name}}.shared.breakpoints.sub-handlers
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.db :as db]))



(defn get-page-width [db _]
  (get-in db [db/breakpoints-prefix :page-width]))


(defn get-screen-type [page-width _]
  (cond
    (< page-width 768)
    :mobile

    (< page-width 992)
    :tablet

    (< page-width 1200)
    :small-monitor

    :else
    :large-monitor))

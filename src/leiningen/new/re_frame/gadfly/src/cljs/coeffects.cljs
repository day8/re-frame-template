(ns {{ns-name}}.coeffects
  (:require
   [re-frame.core :as rf]))


(rf/reg-cofx
 :page-width
 (fn [coeffect]
   (let [page-width (some-> "app"
                           js/document.getElementById
                           .-clientWidth)]
     (assoc coeffect :page-width page-width))))

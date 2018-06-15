(ns {{ns-name}}.shared.breakpoints.cofx
  (:require
   [re-frame.core :as rf]
   [cljsjs.jquery]
   ))



(rf/reg-cofx
 :page-width
 (fn [coeffect]
   (let [page-width (-> js/window
                        js/$
                        .width)]
     (assoc coeffect :page-width page-width))))

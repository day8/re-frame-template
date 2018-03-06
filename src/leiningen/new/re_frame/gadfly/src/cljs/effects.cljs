(ns {{ns-name}}.effects
  (:require
   [re-frame.core :as rf]))


(defn- scroll-to-top! []
  (.scroll js/window 0 0))

(defn- set-hash! [hash]
  (set! (.-hash (.-location js/window))
        (str "#" hash)))

(rf/reg-fx
 :set-hash
 (fn [hash]
   (set-hash! hash)
   (scroll-to-top!)))

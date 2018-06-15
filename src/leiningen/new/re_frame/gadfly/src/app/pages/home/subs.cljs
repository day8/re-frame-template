(ns {{ns-name}}.pages.home.subs
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.shared.bin.subs :as bs]))



(rf/reg-sub  ::re-pressed-example
             :<- [::bs/bin]
             (fn [bin _]
               (:re-pressed-example bin)))

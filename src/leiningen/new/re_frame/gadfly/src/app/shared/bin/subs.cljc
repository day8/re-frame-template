(ns {{ns-name}}.shared.bin.subs
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.shared.bin.sub-handlers :as sh]
   [{{ns-name}}.shared.navigation.subs :as ns]
   ))



(rf/reg-sub ::bins sh/get-bins)


(rf/reg-sub
 ::bin
 :<- [::bins]
 :<- [::ns/active-page]
 sh/get-bin)

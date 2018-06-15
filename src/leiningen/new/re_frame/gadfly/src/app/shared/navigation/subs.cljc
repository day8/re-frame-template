(ns {{ns-name}}.shared.navigation.subs
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.shared.navigation.sub-handlers :as sh]
   ))



(rf/reg-sub ::active-page sh/get-active-page)

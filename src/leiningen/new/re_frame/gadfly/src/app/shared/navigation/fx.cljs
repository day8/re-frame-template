(ns {{ns-name}}.shared.navigation.fx
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.shared.navigation.fx-handlers :as fxh]
   ))



(rf/reg-fx :navigate fxh/navigate)

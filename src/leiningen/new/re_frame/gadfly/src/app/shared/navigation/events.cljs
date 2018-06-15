(ns {{ns-name}}.shared.navigation.events
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.config :as config]
   [{{ns-name}}.shared.navigation.event-handlers :as eh]
   ))



(rf/reg-event-fx ::navigate
                 [(when config/debug? re-frame.core/debug)]
                 eh/navigate)


(rf/reg-event-fx ::set-active-page
                 [(when config/debug? re-frame.core/debug)]
                 eh/set-active-page)

(ns {{ns-name}}.pages.home.events
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.config :as config]
   [{{ns-name}}.pages.home.event-handlers :as eh]
   [{{ns-name}}.shared.navigation.subs :as ns]
   ))


(rf/reg-event-fx ::set-re-pressed-example
                 [(when config/debug? re-frame.core/debug)]
                 eh/set-re-pressed-example)

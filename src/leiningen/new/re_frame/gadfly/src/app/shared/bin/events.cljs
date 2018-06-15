(ns {{ns-name}}.shared.bin.events
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.config :as config]
   [{{ns-name}}.shared.bin.event-handlers :as eh]
   ))



(rf/reg-event-fx
 ::reset-bin
 [(when config/debug? re-frame.core/debug)]
 eh/reset-bin)

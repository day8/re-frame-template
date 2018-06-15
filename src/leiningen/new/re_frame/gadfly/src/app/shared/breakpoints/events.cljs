(ns {{ns-name}}.shared.breakpoints.events
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.config :as config]
   [{{ns-name}}.shared.breakpoints.event-handlers :as eh]
   ))



(rf/reg-event-fx ::set-page-width
                 [(when config/debug? re-frame.core/debug)
                  (rf/inject-cofx :page-width)]
                 eh/set-page-width)

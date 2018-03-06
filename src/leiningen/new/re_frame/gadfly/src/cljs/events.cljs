(ns {{ns-name}}.events
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.event-handlers :as eh]
   [{{ns-name}}.interceptors :as i]))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; db

(rf/reg-event-db ::initialize-db [i/check-db-spec] eh/initialize-db)
(rf/reg-event-db ::set-active-page [i/check-db-spec] eh/set-active-page)
(rf/reg-event-db ::set-active-surface [i/check-db-spec] eh/set-active-surface)



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; fx

(rf/reg-event-fx ::set-hash eh/set-hash)

(rf/reg-event-fx
 ::set-page-width
 [(rf/inject-cofx :page-width)
  i/check-db-spec]
 eh/set-page-width)

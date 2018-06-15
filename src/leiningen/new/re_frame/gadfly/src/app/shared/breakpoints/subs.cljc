(ns {{ns-name}}.shared.breakpoints.subs
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.shared.breakpoints.sub-handlers :as sh]
   ))



(rf/reg-sub ::page-width sh/get-page-width)


(rf/reg-sub ::screen-type
            :<- [::page-width]
            sh/get-screen-type)


(rf/reg-sub ::mobile?
            :<- [::screen-type]
            (fn [screen-type _]
              (= :mobile screen-type)))

(rf/reg-sub ::tablet?
            :<- [::screen-type]
            (fn [screen-type _]
              (= :tablet screen-type)))

(rf/reg-sub ::small-monitor?
            :<- [::screen-type]
            (fn [screen-type _]
              (= :small-monitor screen-type)))

(rf/reg-sub ::large-monitor?
            :<- [::screen-type]
            (fn [screen-type _]
              (= :large-monitor screen-type)))

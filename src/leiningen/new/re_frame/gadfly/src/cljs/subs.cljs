(ns {{ns-name}}.subs
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.sub-handlers :as sh]))

(rf/reg-sub ::active-page sh/->active-page)
(rf/reg-sub ::active-surface sh/->active-surface)
(rf/reg-sub ::page-width sh/->page-width)

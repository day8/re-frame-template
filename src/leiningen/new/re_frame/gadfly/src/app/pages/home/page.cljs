(ns {{ns-name}}.pages.home.page
  (:require
   [soda-ash.core :as sa]
   [{{ns-name}}.shared.comps.appbar :as appbar]
   [{{ns-name}}.pages.home.comps.title :as title]
   [{{ns-name}}.pages.home.comps.link-about :as link-about]
   [{{ns-name}}.pages.home.comps.re-pressed-example :as re-pressed-example]))



(defn main []
  [:div
   [appbar/component]
   [sa/Container
    [title/component]
    [link-about/component]
    [re-pressed-example/component]
    ]])

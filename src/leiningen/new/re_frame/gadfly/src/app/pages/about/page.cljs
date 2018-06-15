(ns {{ns-name}}.pages.about.page
  (:require
   [soda-ash.core :as sa]
   [{{ns-name}}.shared.comps.appbar :as appbar]
   [{{ns-name}}.pages.about.comps.title :as title]
   [{{ns-name}}.pages.about.comps.link-home :as link-home]))



(defn main []
  [:div
   [appbar/component]
   [sa/Container
    [title/component]
    [link-home/component]]])

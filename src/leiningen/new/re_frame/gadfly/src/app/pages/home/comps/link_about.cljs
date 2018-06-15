(ns {{ns-name}}.pages.home.comps.link-about
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.shared.navigation.events :as ne]
   ))


(defn component []
  [:div.pointer
   [:a
    {:on-click #(rf/dispatch [::ne/navigate :about])}
    "go to About Page"]])

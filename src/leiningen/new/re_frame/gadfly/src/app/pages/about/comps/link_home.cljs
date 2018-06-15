(ns {{ns-name}}.pages.about.comps.link-home
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.shared.navigation.events :as ne]
   ))



(defn component []
  [:div.pointer
   [:a
    {:on-click #(rf/dispatch [::ne/navigate :home])}
    "go to Home Page"]])

(ns {{ns-name}}.pages.home.comps
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.events :as events]))


(defn body []
  [:div.page-container.pa2
   [:h2 "This is the Home Page."]
   [:p.t2
    [:a.pointer
     {:on-click #(rf/dispatch [::events/set-hash "/about"])}
     "go to About Page"]]])

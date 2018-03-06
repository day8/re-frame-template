(ns {{ns-name}}.pages.about.comps
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.events :as events]))


(defn body []
  [:div.page-container.pa2
   [:h2 "This is the About Page."]
   [:p.t2
    [:a.pointer
     {:on-click #(rf/dispatch [::events/set-hash "/"])}
     "go to Home Page"]]])

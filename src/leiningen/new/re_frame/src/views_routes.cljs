(ns {{ns-name}}.views
  (:require
   [re-frame.core :as re-frame]{{#breaking-point?}}
   [breaking-point.core :as bp]{{/breaking-point?}}{{#garden?}}
   [{{ns-name}}.styles :as styles]{{/garden?}}
   [{{ns-name}}.events :as events]
   [{{ns-name}}.routes :as routes]
   [{{ns-name}}.subs :as subs]
   ))


;; home

{{#re-pressed?}}
(defn display-re-pressed-example []
  (let [re-pressed-example (re-frame/subscribe [::subs/re-pressed-example])]
    [:div

     [:p
      [:span "Re-pressed is listening for keydown events. A message will be displayed when you type "]
      [:strong [:code "hello"]]
      [:span ". So go ahead, try it out!"]]

     (when-let [rpe @re-pressed-example]
       [:div
        {:style {:padding          "16px"
                 :background-color "lightgrey"
                 :border           "solid 1px grey"
                 :border-radius    "4px"
                 :margin-top       "16px"
                 }}
        rpe])]))

{{/re-pressed?}}
(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 (str "Hello from " @name ". This is the Home Page."){{#garden?}}
      {:class (styles/level1)}{{/garden?}}]

     [:div
      [:a {:on-click #(re-frame/dispatch [::events/navigate :about])}
       "go to About Page"]]{{#re-pressed?}}

     [display-re-pressed-example]{{/re-pressed?}}{{#breaking-point?}}
     [:div
      [:h3 (str "screen-width: " @(re-frame/subscribe [::bp/screen-width]))]
      [:h3 (str "screen: " @(re-frame/subscribe [::bp/screen]))]]{{/breaking-point?}}
     ]))

(defmethod routes/panels :home-panel [] [home-panel])

;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "go to Home Page"]]])

(defmethod routes/panels :about-panel [] [about-panel])

;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (routes/panels @active-panel)))

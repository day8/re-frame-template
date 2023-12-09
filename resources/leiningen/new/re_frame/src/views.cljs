(ns {{ns-name}}.views
  (:require
   [re-frame.core :as re-frame]{{#breaking-point?}}
   [breaking-point.core :as bp]{{/breaking-point?}}{{#re-pressed?}}
   [re-pressed.core :as rp]
   [{{ns-name}}.events :as events]{{/re-pressed?}}{{#garden?}}
   [{{ns-name}}.styles :as styles]{{/garden?}}
   [{{ns-name}}.subs :as subs]{{#git-inject?}}
   [{{ns-name}}.config :as config]{{/git-inject?}}
   ))

{{#re-pressed?}}
(defn dispatch-keydown-rules []
  (re-frame/dispatch
   [::rp/set-keydown-rules
    {:event-keys [[[::events/set-re-pressed-example "Hello, world!"]
                   [{:keyCode 72} ;; h
                    {:keyCode 69} ;; e
                    {:keyCode 76} ;; l
                    {:keyCode 76} ;; l
                    {:keyCode 79} ;; o
                    ]]]

     :clear-keys
     [[{:keyCode 27} ;; escape
       ]]}]))

(defn display-re-pressed-example []
  (let [re-pressed-example (re-frame/subscribe [::subs/re-pressed-example])]
    [:div

     [:p
      "Re-pressed is listening for keydown events. However, re-pressed
      won't trigger any events until you set some keydown rules."]

     [:div
      [:button
       {:on-click dispatch-keydown-rules}
       "set keydown rules"]]

     [:p
      [:span
       "After clicking the button, you will have defined a rule that
       will display a message when you type "]
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
(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1{{#garden?}}
      {:class (styles/level1)}{{/garden?}}
      "Hello from " @name{{#git-inject?}}". Version " config/version{{/git-inject?}}]{{#re-pressed?}}
     [display-re-pressed-example]{{/re-pressed?}}{{#breaking-point?}}
     [:div
      [:h3 (str "screen-width: " @(re-frame/subscribe [::bp/screen-width]))]
      [:h3 (str "screen: " @(re-frame/subscribe [::bp/screen]))]]{{/breaking-point?}}
     ]))

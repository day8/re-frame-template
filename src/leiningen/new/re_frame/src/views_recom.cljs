(ns {{ns-name}}.views
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com :refer [at]]{{#breaking-point?}}
   [breaking-point.core :as bp]{{/breaking-point?}}{{#re-pressed?}}
   [re-pressed.core :as rp]
   [{{ns-name}}.events :as events]{{/re-pressed?}}{{#garden?}}
   [{{ns-name}}.styles :as styles]{{/garden?}}{{#git-inject?}}
   [{{ns-name}}.config :as config]{{/git-inject?}}
   [{{ns-name}}.subs :as subs]
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
      [re-com/button
       :src      (at)
       :on-click dispatch-keydown-rules
       :label    "set keydown rules"]]

     [:p
      [:span
       "After clicking the button, you will have defined a rule that
       will display a message when you type "]
      [:strong [:code "hello"]]
      [:span ". So go ahead, try it out!"]]

     (when-let [rpe @re-pressed-example]
       [re-com/alert-box
        :src        (at)
        :alert-type :info
        :body       rpe])]))

{{/re-pressed?}}
(defn title []
  (let [name (re-frame/subscribe [::subs/name])]
    [re-com/title
     :src   (at)
     :label (str "Hello from " @name{{#git-inject?}}". Git version " config/version{{/git-inject?}})
     :level :level1{{#garden?}}
     :class (styles/level1){{/garden?}}]))

(defn main-panel []
  [re-com/v-box
   :src      (at)
   :height   "100%"
   :children [[title]{{#re-pressed?}}
              [display-re-pressed-example]{{/re-pressed?}}{{#breaking-point?}}
              [:div
               [:h3 (str "screen-width: " @(re-frame/subscribe [::bp/screen-width]))]
               [:h3 (str "screen: " @(re-frame/subscribe [::bp/screen]))]]{{/breaking-point?}}
              ]])

(ns {{ns-name}}.views
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]{{#re-pressed?}}
   [re-pressed.core :as rp]
   [{{ns-name}}.events :as events]{{/re-pressed?}}
   [{{ns-name}}.subs :as subs]
   ))

{{#re-pressed?}}
(defn dispatch-keydown-rules []
  (re-frame/dispatch
   [::rp/set-keydown-rules
    {:event-keys [[[::events/set-re-pressed-example "Hello, world!"]
                   [{:which 72} ;; h
                    {:which 69} ;; e
                    {:which 76} ;; l
                    {:which 76} ;; l
                    {:which 79} ;; o
                    ]]]

     :clear-keys
     [[{:which 27} ;; escape
       ]]}]))

(defn display-re-pressed-example []
  (let [re-pressed-example (re-frame/subscribe [::subs/re-pressed-example])]
    [:div

     [:p
      "Re-pressed is listening for keydown events. However, re-pressed
      won't trigger any events until you set some keydown rules."]

     [:div
      [re-com/button
       :on-click dispatch-keydown-rules
       :label "set keydown rules"]]

     [:p
      [:span
       "After clicking the button, you will have defined a rule that
       will display a message when you type "]
      [:strong [:code "hello"]]
      [:span ". So go ahead, try it out!"]]

     (when-let [rpe @re-pressed-example]
       [re-com/alert-box
        :alert-type :info
        :body rpe])]))

{{/re-pressed?}}
(defn title []
  (let [name (re-frame/subscribe [::subs/name])]
    [re-com/title
     :label (str "Hello from " @name)
     :level :level1]))

(defn main-panel []
  [re-com/v-box
   :height "100%"
   :children [[title]{{#re-pressed?}}
              [display-re-pressed-example]{{/re-pressed?}}
              ]])

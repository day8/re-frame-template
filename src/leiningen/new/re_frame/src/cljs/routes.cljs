(ns {{ns-name}}.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:import [goog History]
           [goog.history EventType])
  (:require
   [secretary.core :as secretary]
   [goog.events :as gevents]
   [re-frame.core :as re-frame]{{#re-pressed?}}
   [re-pressed.core :as rp]{{/re-pressed?}}
   [{{ns-name}}.events :as events]
   ))

(defn hook-browser-navigation! []
  (doto (History.)
    (gevents/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (secretary/set-config! :prefix "#")
  ;; --------------------
  ;; define routes here
  (defroute "/" []
    (re-frame/dispatch [::events/set-active-panel :home-panel]){{#re-pressed?}}
    (re-frame/dispatch [::events/set-re-pressed-example nil])
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
         ]]}]){{/re-pressed?}}
    )

  (defroute "/about" []
    (re-frame/dispatch [::events/set-active-panel :about-panel]))


  ;; --------------------
  (hook-browser-navigation!))

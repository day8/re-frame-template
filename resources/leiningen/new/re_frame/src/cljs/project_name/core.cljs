(ns {{name}}.core
  (:require-macros [secretary.core :refer [defroute]])
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [re-frame.core :refer [dispatch dispatch-sync]]
            [secretary.core :as secretary]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [cljsjs.react :as react])
  (:import [goog History]
           [goog.history EventType]))

;; -- Routing -----------------------------------------------------------------

(defroute "/" [] (dispatch [:set-showing :all]))
(defroute "/:filter" [filter] (dispatch [:set-showing (keyword filter)]))

(def history (History.))

(events/listen history EventType.NAVIGATE
               (fn [e] (secretary/dispatch! (.-token e))))

(.setEnabled history true)


;; -------------------------
;; Initialize app
(defn init! []
  (dispatch-sync [:initialise-db])
  (reagent/render [{{name}}.views/{{name}}-app]
                  (.getElementById js/document "app")))

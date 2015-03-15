(ns {{name}}.core
  (:require-macros [secretary.core :refer [defroute]])
  (:require [cljsjs.react :as react]
            [goog.events :as events]
            [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [re-frame.core :refer [dispatch dispatch-sync]]
            [secretary.core :as secretary]
            [{{name}}.handlers]
            [{{name}}.subs]
            [{{name}}.views])
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

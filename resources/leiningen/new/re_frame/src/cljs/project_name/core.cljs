(ns {{name}}.core
  (:require-macros [secretary.core :refer [defroute]])
  (:require [cljsjs.react :as react]
            [goog.events :as events]
            [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [re-frame.core :refer [dispatch dispatch-sync]]
            [secretary.core :as secretary]
            [{{name}}.handlers]          ;; appears unused, but you need it here, to force loading.
            [{{name}}.subs]              ;; appears unused, but you need it here, to force loading.
            [{{name}}.views])
  (:import [goog History]
           [goog.history EventType]))

;; -- Routing -----------------------------------------------------------------
;; See example routing in the todomvc sample:
;; https://github.com/Day8/re-frame/blob/develop/examples/todomvc/src/todomvc/core.cljs#L18-L25


(defn mount-root
  []
  (reagent/render [{{name}}.views/{{name}}-app] (.getElementById js/document "app")))

;; -- Initialize app ----------------------------------------------------------
;;
;; See these notes:
;; https://github.com/Day8/re-frame/wiki/Bootstrap-An-Application
;;
(defn init! []
  (dispatch-sync [:initialise-db])
  (mount-root))

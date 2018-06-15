(ns {{ns-name}}.shared.navigation.fx-handlers
  (:require
   [bide.core :as bide]
   [{{ns-name}}.pages.bundle :as pages]
   ))



(defn navigate
  [[id params query]]
  (bide/navigate! pages/router id params query))

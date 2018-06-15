(ns {{ns-name}}.pages.home.comps.title
  (:require
   [soda-ash.core :as sa]))


(defn component []
  [sa/Header
   {:as "h1"}
   "This is the Home Page."])

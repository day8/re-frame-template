(ns {{ns-name}}.pages.about.comps.title
  (:require
   [soda-ash.core :as sa]))



(defn component []
  [sa/Header
   {:as "h1"}
   "This is the About Page."])

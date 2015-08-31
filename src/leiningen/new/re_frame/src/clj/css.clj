(ns {{ns-name}}.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:body {:color "red"}]
  {{#re-com?}}
  [:.level1 {:color "green"}]{{/re-com?}})

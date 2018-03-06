(ns {{ns-name}}.css
  (:require
   [garden.def :refer [defstyles]]
   [{{ns-name}}.css.base :as base]
   [{{ns-name}}.css.page :as page]
   [{{ns-name}}.css.flex :as flex]
   [{{ns-name}}.css.headings :as headings]
   [{{ns-name}}.css.margins :as margins]
   [{{ns-name}}.css.paddings :as paddings]
   ))

(defstyles screen
  [
   base/style
   page/style
   flex/style
   headings/style
   margins/style
   paddings/style
   ])

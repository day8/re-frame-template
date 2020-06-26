(ns leiningen.new.options.scss
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+scss")

(defn files [data]
  [["scss/site.scss" (helpers/render "scss/site.scss" data)]])

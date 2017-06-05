(ns leiningen.new.options.sass
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+sass")

(defn files [data]
  [["sass/web.sass" (helpers/render "sass/web.sass" data)]])

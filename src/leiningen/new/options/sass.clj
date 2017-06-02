(ns leiningen.new.options.sass
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+sass")

(defn files [data]
  [["resources/sass/screen.sass" (helpers/render "resources/sass/screen.sass" data)]])

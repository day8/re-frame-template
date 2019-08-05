(ns leiningen.new.options.cider
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+cider")

(defn files [data]
  [[".dir-locals.el" (helpers/render "dir-locals.el" data)]])

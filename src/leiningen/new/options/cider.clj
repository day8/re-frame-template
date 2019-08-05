(ns leiningen.new.options.cider
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+cider")

(defn files [data]
  [["dir-local.el" (helpers/render "dir-local.el" data)]])

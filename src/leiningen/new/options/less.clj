(ns leiningen.new.options.less
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "less")

(defn files [data]
  [["less/site.less" (helpers/render "less/site.less" data)]])

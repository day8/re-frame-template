(ns leiningen.new.options.garden
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+garden")

(defn files [data]
  [["src/clj/{{sanitized}}/css.clj" (helpers/render "src/clj/css.clj" data)]])

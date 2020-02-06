(ns leiningen.new.options.kondo
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+kondo")

(defn files [data]
  [[".clj-kondo/config.edn" (helpers/render "clj-kondo/config.edn" data)]])

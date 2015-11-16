(ns leiningen.new.options.handler
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "handler")

(defn files [data]
  [["src/clj/{{sanitized}}/handler.clj" (helpers/render "src/clj/handler.clj" data)]])

(ns leiningen.new.options.handler
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "handler")

(defn files [data]
  [["Procfile" (helpers/render "Procfile" data)]
   ["src/clj/{{sanitized}}/handler.clj" (helpers/render "src/clj/handler.clj" data)]
   ["src/clj/{{sanitized}}/server.clj" (helpers/render "src/clj/server.clj" data)]])

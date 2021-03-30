(ns leiningen.new.options.routes
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+routes")

(defn routes-cljs [data]
  [["src/{{sanitized}}/routes.cljs" (helpers/render "src/routes.cljs" data)]])

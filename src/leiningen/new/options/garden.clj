(ns leiningen.new.options.garden
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+garden")

(defn files [data]
  [["src/{{sanitized}}/styles.cljs" (helpers/render "src/styles.cljs" data)]])

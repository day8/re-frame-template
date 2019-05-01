(ns leiningen.new.options.shadow-cljs
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+shadow-cljs")

(defn files [data]
  [["shadow-cljs.edn" (helpers/render "shadow-cljs.edn" data)]
   ["package.json" (helpers/render "package.json" data)]])

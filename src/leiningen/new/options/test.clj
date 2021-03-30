(ns leiningen.new.options.test
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+test")

(defn files [data]
  [["test/{{sanitized}}/core_test.cljs" (helpers/render "test/core_test.cljs" data)]])

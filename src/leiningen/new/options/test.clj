(ns leiningen.new.options.test
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+test")

(defn files [data]
  [["test/cljs/{{sanitized}}/runner.cljs" (helpers/render "test/cljs/runner.cljs" data)]
   ["test/cljs/{{sanitized}}/core_test.cljs" (helpers/render "test/cljs/core_test.cljs" data)]])

(ns leiningen.new.options.test
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "test")

(defn files [data]
  [["test/phantomjs-shims.js" (helpers/render "test/phantomjs-shims.js")]
   ["test/unit-test.js" (helpers/render "test/unit-test.js")]
   ["test/unit-test.html" (helpers/render "test/unit-test.html")]

   ["test/cljs/test_runner.cljs" (helpers/render "test/cljs/test_runner.cljs" data)]
   ["test/cljs/{{sanitized}}/core_test.cljs" (helpers/render "test/cljs/core_test.cljs" data)]])

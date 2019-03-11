(ns leiningen.new.options.base
  (:require [leiningen.new.options.helpers :as helpers]))

(defn files [data]
  [["README.md" (helpers/render "README.md" data)]
   ["project.clj" (helpers/render "project.clj" data)]
   [".gitignore" (helpers/render "gitignore" data)]
   ["resources/public/index.html" (helpers/render "resources/public/index.html" data)]
   ["src/clj/{{sanitized}}/core.clj" (helpers/render "src/clj/core.clj" data)]
   ["src/cljs/{{sanitized}}/core.cljs" (helpers/render "src/cljs/core.cljs" data)]
   ["src/cljs/{{sanitized}}/config.cljs" (helpers/render "src/cljs/config.cljs" data)]
   ["src/cljs/{{sanitized}}/db.cljs" (helpers/render "src/cljs/db.cljs" data)]
   ["src/cljs/{{sanitized}}/subs.cljs" (helpers/render "src/cljs/subs.cljs" data)]
   ["src/cljs/{{sanitized}}/events.cljs" (helpers/render "src/cljs/events.cljs" data)]])

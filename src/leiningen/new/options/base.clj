(ns leiningen.new.options.base
  (:require [leiningen.new.options.helpers :as helpers]))

(defn files [data]
  [[".gitignore" (helpers/render "gitignore" data)]
   ["README.md" (helpers/render "README.md" data)]
   ["package.json" (helpers/render "package.json" data)]
   ["shadow-cljs.edn" (helpers/render "shadow-cljs.edn" data)]
   ["karma.conf.js" (helpers/render "karma.conf.js" data)]
   ["dev/user.cljs" (helpers/render "dev/user.cljs" data)]
   ["resources/public/index.html" (helpers/render "resources/public/index.html" data)]
   ["src/{{sanitized}}/core.cljs" (helpers/render "src/core.cljs" data)]
   ["src/{{sanitized}}/config.cljs" (helpers/render "src/config.cljs" data)]
   ["src/{{sanitized}}/db.cljs" (helpers/render "src/db.cljs" data)]
   ["src/{{sanitized}}/subs.cljs" (helpers/render "src/subs.cljs" data)]
   ["src/{{sanitized}}/events.cljs" (helpers/render "src/events.cljs" data)]])

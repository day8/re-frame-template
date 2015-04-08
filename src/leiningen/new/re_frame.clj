(ns leiningen.new.re-frame
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "re-frame"))

(defn- build-files
  [data]
  [["env/dev/clj/{{sanitized}}/dev.clj"
    (render "env/dev/clj/project_name/dev.clj" data)]

   ["env/dev/cljs/{{sanitized}}/dev.cljs"
    (render "env/dev/cljs/project_name/dev.cljs" data)]

   ["env/prod/cljs/{{sanitized}}/prod.cljs"
    (render "env/prod/cljs/project_name/prod.cljs" data)]

   ["LICENSE" (render "LICENSE" data)]
   ["Procfile" (render "Procfile" data)]
   ["project.clj" (render "project.clj" data)]
   ["README.md" (render "README.md" data)]

   ["resources/public/css/site.css"
    (render "resources/public/css/site.css" data)]

   ["resources/templates/index.html"
    (render "resources/templates/index.html" data)]

   ["src/clj/{{sanitized}}/handler.clj"
    (render "src/clj/project_name/handler.clj" data)]

   ["src/clj/{{sanitized}}/server.clj"
    (render "src/clj/project_name/server.clj" data)]

   ["src/cljs/{{sanitized}}/core.cljs"
    (render "src/cljs/project_name/core.cljs" data)]

   ["src/cljs/{{sanitized}}/db.cljs"
    (render "src/cljs/project_name/db.cljs" data)]

   ["src/cljs/{{sanitized}}/handlers.cljs"
    (render "src/cljs/project_name/handlers.cljs" data)]

   ["src/cljs/{{sanitized}}/subs.cljs"
    (render "src/cljs/project_name/subs.cljs" data)]

   ["src/cljs/{{sanitized}}/views.cljs"
    (render "src/cljs/project_name/views.cljs" data)]

   ["system.properties" (render "system.properties" data)]

   ["test/cljs/{{sanitized}}/core_test.cljs"
    (render "test/cljs/project_name/core_test.cljs" data)]

   ["test/vendor/console-polyfill.js"
    (render "test/vendor/console-polyfill.js" data)]

   ["test/vendor/es5-sham.js"
    (render "test/vendor/es5-sham.js" data)]

   ["test/vendor/es5-shim.js"
    (render "test/vendor/es5-shim.js" data)]])

(defn re-frame
  [name]
  (let [data {:name      name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' re-frame project.")
    (apply ->files data (build-files data))))

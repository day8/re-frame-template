(ns leiningen.new.options.gadfly
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+gadfly")

(defn files [data]
  [;; top-level
   ["bitbucket-pipelines.yml" (helpers/render "gadfly/bitbucket-pipelines.yml" data)]
   [".gitignore" (helpers/render "gadfly/.gitignore" data)]
   ["project.clj" (helpers/render "gadfly/project.clj" data)]
   ["README.md" (helpers/render "gadfly/README.md" data)]

   ;; resources
   ["resources/public/index.html"
    (helpers/render "gadfly/resources/public/index.html" data)]

   ;; cljc (& a few .clj test files)
   ["src/cljc/{{sanitized}}/event_handlers.cljc"
    (helpers/render "gadfly/src/cljc/event_handlers.cljc" data)]
   ["src/cljc/{{sanitized}}/event_handlers_test.clj"
    (helpers/render "gadfly/src/cljc/event_handlers_test.clj" data)]
   ["src/cljc/{{sanitized}}/sub_handlers.cljc"
    (helpers/render "gadfly/src/cljc/sub_handlers.cljc" data)]
   ["src/cljc/{{sanitized}}/surface_util.cljc"
    (helpers/render "gadfly/src/cljc/surface_util.cljc" data)]
   ["src/cljc/{{sanitized}}/surface_util_test.clj"
    (helpers/render "gadfly/src/cljc/surface_util_test.clj" data)]
   ["src/cljc/{{sanitized}}/vars.cljc"
    (helpers/render "gadfly/src/cljc/vars.cljc" data)]

   ;; css
   ["src/css/{{sanitized}}/css.clj"
    (helpers/render "gadfly/src/css/css.clj" data)]
   ["src/css/{{sanitized}}/css/base.clj"
    (helpers/render "gadfly/src/css/css/base.clj" data)]
   ["src/css/{{sanitized}}/css/flex.clj"
    (helpers/render "gadfly/src/css/css/flex.clj" data)]
   ["src/css/{{sanitized}}/css/headings.clj"
    (helpers/render "gadfly/src/css/css/headings.clj" data)]
   ["src/css/{{sanitized}}/css/margins.clj"
    (helpers/render "gadfly/src/css/css/margins.clj" data)]
   ["src/css/{{sanitized}}/css/paddings.clj"
    (helpers/render "gadfly/src/css/css/paddings.clj" data)]
   ["src/css/{{sanitized}}/css/page.clj"
    (helpers/render "gadfly/src/css/css/page.clj" data)]

   ;; cljs
   ["src/cljs/{{sanitized}}/coeffects.cljs"
    (helpers/render "gadfly/src/cljs/coeffects.cljs" data)]
   ["src/cljs/{{sanitized}}/config.cljs"
    (helpers/render "gadfly/src/cljs/config.cljs" data)]
   ["src/cljs/{{sanitized}}/core.cljs"
    (helpers/render "gadfly/src/cljs/core.cljs" data)]
   ["src/cljs/{{sanitized}}/db.cljs"
    (helpers/render "gadfly/src/cljs/db.cljs" data)]
   ["src/cljs/{{sanitized}}/effects.cljs"
    (helpers/render "gadfly/src/cljs/effects.cljs" data)]
   ["src/cljs/{{sanitized}}/events.cljs"
    (helpers/render "gadfly/src/cljs/events.cljs" data)]
   ["src/cljs/{{sanitized}}/interceptors.cljs"
    (helpers/render "gadfly/src/cljs/interceptors.cljs" data)]
   ["src/cljs/{{sanitized}}/registries.cljs"
    (helpers/render "gadfly/src/cljs/registries.cljs" data)]
   ["src/cljs/{{sanitized}}/routes.cljs"
    (helpers/render "gadfly/src/cljs/routes.cljs" data)]
   ["src/cljs/{{sanitized}}/subs.cljs"
    (helpers/render "gadfly/src/cljs/subs.cljs" data)]

   ;; cljs / pages
   ["src/cljs/{{sanitized}}/pages/about/comps.cljs"
    (helpers/render "gadfly/src/cljs/pages/about/comps.cljs" data)]
   ["src/cljs/{{sanitized}}/pages/about/page.cljs"
    (helpers/render "gadfly/src/cljs/pages/about/page.cljs" data)]

   ["src/cljs/{{sanitized}}/pages/home/comps.cljs"
    (helpers/render "gadfly/src/cljs/pages/home/comps.cljs" data)]
   ["src/cljs/{{sanitized}}/pages/home/page.cljs"
    (helpers/render "gadfly/src/cljs/pages/home/page.cljs" data)]
   ])

(ns leiningen.new.options.gadfly
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+gadfly")

(defn files [data]
  [;; top-level
   [".gitignore" (helpers/render "gadfly/gitignore" data)]
   ["project.clj" (helpers/render "gadfly/project.clj" data)]
   ["README.md" (helpers/render "gadfly/README.md" data)]

   ;; resources
   ["resources/public/index.html"
    (helpers/render "gadfly/resources/public/index.html" data)]

   ;; css
   ["src/css/{{sanitized}}/css.clj"
    (helpers/render "gadfly/src/css/css.clj" data)]

   ;; app
   ["src/app/{{sanitized}}/cofx.cljs"
    (helpers/render "gadfly/src/app/cofx.cljs" data)]
   ["src/app/{{sanitized}}/config.cljs"
    (helpers/render "gadfly/src/app/config.cljs" data)]
   ["src/app/{{sanitized}}/core.cljs"
    (helpers/render "gadfly/src/app/core.cljs" data)]
   ["src/app/{{sanitized}}/db.cljc"
    (helpers/render "gadfly/src/app/db.cljc" data)]
   ["src/app/{{sanitized}}/fx.cljs"
    (helpers/render "gadfly/src/app/fx.cljs" data)]

   ;; app > pages
   ["src/app/{{sanitized}}/pages/bundle.cljs"
    (helpers/render "gadfly/src/app/pages/bundle.cljs" data)]

   ;; app > pages > about
   ["src/app/{{sanitized}}/pages/about/bundle.cljs"
    (helpers/render "gadfly/src/app/pages/about/bundle.cljs" data)]
   ["src/app/{{sanitized}}/pages/about/page.cljs"
    (helpers/render "gadfly/src/app/pages/about/page.cljs" data)]
   ["src/app/{{sanitized}}/pages/about/route.cljs"
    (helpers/render "gadfly/src/app/pages/about/route.cljs" data)]
   ;; app > pages > about > comps
   ["src/app/{{sanitized}}/pages/about/comps/link_home.cljs"
    (helpers/render "gadfly/src/app/pages/about/comps/link_home.cljs" data)]
   ["src/app/{{sanitized}}/pages/about/comps/title.cljs"
    (helpers/render "gadfly/src/app/pages/about/comps/title.cljs" data)]

   ;; app > pages > home
   ["src/app/{{sanitized}}/pages/home/bundle.cljs"
    (helpers/render "gadfly/src/app/pages/home/bundle.cljs" data)]
   ["src/app/{{sanitized}}/pages/home/event_handlers.cljc"
    (helpers/render "gadfly/src/app/pages/home/event_handlers.cljc" data)]
   ["src/app/{{sanitized}}/pages/home/events.cljs"
    (helpers/render "gadfly/src/app/pages/home/events.cljs" data)]
   ["src/app/{{sanitized}}/pages/home/page.cljs"
    (helpers/render "gadfly/src/app/pages/home/page.cljs" data)]
   ["src/app/{{sanitized}}/pages/home/route.cljs"
    (helpers/render "gadfly/src/app/pages/home/route.cljs" data)]
   ["src/app/{{sanitized}}/pages/home/subs.cljs"
    (helpers/render "gadfly/src/app/pages/home/subs.cljs" data)]
   ;; app > pages > home >comps
   ["src/app/{{sanitized}}/pages/home/comps/link_about.cljs"
    (helpers/render "gadfly/src/app/pages/home/comps/link_about.cljs" data)]
   ["src/app/{{sanitized}}/pages/home/comps/re_pressed_example.cljs"
    (helpers/render "gadfly/src/app/pages/home/comps/re_pressed_example.cljs" data)]
   ["src/app/{{sanitized}}/pages/home/comps/title.cljs"
    (helpers/render "gadfly/src/app/pages/home/comps/title.cljs" data)]

   ;; app > shared > bin
   ["src/app/{{sanitized}}/shared/bin/event_handlers.cljc"
    (helpers/render "gadfly/src/app/shared/bin/event_handlers.cljc" data)]
   ["src/app/{{sanitized}}/shared/bin/events.cljs"
    (helpers/render "gadfly/src/app/shared/bin/events.cljs" data)]
   ["src/app/{{sanitized}}/shared/bin/sub_handlers.cljc"
    (helpers/render "gadfly/src/app/shared/bin/sub_handlers.cljc" data)]
   ["src/app/{{sanitized}}/shared/bin/subs.cljc"
    (helpers/render "gadfly/src/app/shared/bin/subs.cljc" data)]

   ;; app > shared > comps
   ["src/app/{{sanitized}}/shared/comps/appbar.cljs"
    (helpers/render "gadfly/src/app/shared/comps/appbar.cljs" data)]

   ;; app > shared > navigation
   ["src/app/{{sanitized}}/shared/navigation/event_handlers.cljc"
    (helpers/render "gadfly/src/app/shared/navigation/event_handlers.cljc" data)]
   ["src/app/{{sanitized}}/shared/navigation/events.cljs"
    (helpers/render "gadfly/src/app/shared/navigation/events.cljs" data)]
   ["src/app/{{sanitized}}/shared/navigation/fx.cljs"
    (helpers/render "gadfly/src/app/shared/navigation/fx.cljs" data)]
   ["src/app/{{sanitized}}/shared/navigation/fx_handlers.cljs"
    (helpers/render "gadfly/src/app/shared/navigation/fx_handlers.cljs" data)]
   ["src/app/{{sanitized}}/shared/navigation/sub_handlers.cljc"
    (helpers/render "gadfly/src/app/shared/navigation/sub_handlers.cljc" data)]
   ["src/app/{{sanitized}}/shared/navigation/subs.cljc"
    (helpers/render "gadfly/src/app/shared/navigation/subs.cljc" data)]

   ])

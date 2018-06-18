(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.7.0"]
                 [re-frame "0.10.5"]{{#re-com?}}
                 [com.andrewmcveigh/cljs-time "0.5.2"]
                 [org.clojure/core.async "0.2.391"]
                 [re-com "2.1.0"]{{/re-com?}}{{#routes?}}
                 [secretary "1.2.3"]{{/routes?}}{{#garden?}}
                 [garden "1.3.5"]
                 [ns-tracker "0.3.1"]{{/garden?}}{{#handler?}}
                 [compojure "1.5.0"]
                 [yogthos/config "0.8"]
                 [ring "1.4.0"]{{/handler?}}{{#re-pressed?}}
                 [re-pressed "0.2.2"]{{/re-pressed?}}{{#breaking-point?}}
                 [breaking-point "0.1.1"]{{/breaking-point?}}]

  :plugins [[lein-cljsbuild "1.1.7"]{{#garden?}}
            [lein-garden "0.2.8"]{{/garden?}}{{#less?}}
            [lein-less "1.7.5"]{{/less?}}]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj" "src/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"{{#test?}}
                                    "test/js"{{/test?}}{{#garden?}}
                                    "resources/public/css"{{/garden?}}]

  :figwheel {:css-dirs ["resources/public/css"]{{#handler?}}
             :ring-handler {{name}}.handler/dev-handler{{/handler?}}}
{{#garden?}}

  :garden {:builds [{:id           "screen"
                     :source-paths ["src/clj"]
                     :stylesheet   {{name}}.css/screen
                     :compiler     {:output-to     "resources/public/css/screen.css"
                                    :pretty-print? true}}]}
{{/garden?}}{{#less?}}
  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}
{{/less?}}{{#cider?}}
  :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
{{/cider?}}
{{#aliases?}}

  :aliases {"dev" ["do" "clean"
                        ["pdo" ["figwheel" "dev"]{{#less?}}
                               ["less" "auto"]{{/less?}}{{#garden?}}
                               ["garden" "auto"]{{/garden?}}]]
            "build" ["with-profile" "+prod,-dev" "do"
                          ["clean"]
                          ["cljsbuild" "once" "min"]{{#less?}}
                          ["less" "once"]{{/less?}}{{#garden?}}
                          ["garden" "once"]{{/garden?}}]}
{{/aliases?}}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]{{#10x?}}
                   [day8.re-frame/re-frame-10x "0.3.3"]
                   [day8.re-frame/tracing "0.5.1"]{{/10x?}}{{#cider?}}
                   [figwheel-sidecar "0.5.16"]
                   [cider/piggieback "0.3.5"]{{/cider?}}{{#re-frisk?}}
                   [re-frisk "0.5.3"]{{/re-frisk?}}]

    :plugins      [[lein-figwheel "0.5.16"]{{#test?}}
                   [lein-doo "0.1.8"]{{/test?}}{{#aliases?}}
                   [lein-pdo "0.1.1"]{{/aliases?}}]}
   :prod { {{#10x?}}:dependencies [[day8.re-frame/tracing-stubs "0.5.1"]]{{/10x?}}}}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "{{name}}.core/mount-root"}
     :compiler     {:main                 {{name}}.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload{{#10x?}}
                                           day8.re-frame-10x.preload{{/10x?}}{{#re-frisk?}}
                                           re-frisk.preload{{/re-frisk?}}]{{#10x?}}
                    :closure-defines      {"re_frame.trace.trace_enabled_QMARK_" true
                                           "day8.re_frame.tracing.trace_enabled_QMARK_" true}{{/10x?}}
                    :external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]{{#handler?}}
     :jar true{{/handler?}}
     :compiler     {:main            {{name}}.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}

    {{#test?}}
    {:id           "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler     {:main          {{name}}.runner
                    :output-to     "resources/public/js/compiled/test.js"
                    :output-dir    "resources/public/js/compiled/test/out"
                    :optimizations :none}}{{/test?}}
    ]}
{{#handler?}}

  :main {{ns-name}}.server

  :aot [{{ns-name}}.server]

  :uberjar-name "{{name}}.jar"

  :prep-tasks [["cljsbuild" "once" "min"]{{{prep-garden}}}{{{prep-less}}} "compile"]{{/handler?}}
  )

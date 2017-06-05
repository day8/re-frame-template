(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [reagent "0.6.0"]
                 [re-frame "0.9.2"]{{#re-frisk?}}
                 [re-frisk "0.3.2"]{{/re-frisk?}}{{#re-com?}}
                 [org.clojure/core.async "0.2.391"]
                 [re-com "2.0.0"]{{/re-com?}}{{#routes?}}
                 [secretary "1.2.3"]{{/routes?}}{{#garden?}}
                 [garden "1.3.2"]
                 [ns-tracker "0.3.0"]{{/garden?}}{{#handler?}}
                 [compojure "1.5.0"]
                 [yogthos/config "0.8"]
                 [ring "1.4.0"]{{/handler?}}]

  :plugins [[lein-cljsbuild "1.1.4"]{{#garden?}}
            [lein-garden "0.2.8"]{{/garden?}}{{#less?}}
            [lein-less "1.7.5"]{{/less?}}{{#sass?}}
            [lein-sassy "1.0.8"]{{/sass?}}]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

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
{{/less?}}{{#sass?}}
  :sass {:src "sass"
         :dst "resources/public/css/"}
{{/sass?}}{{#cider?}}
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
{{/cider?}}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.8.2"]{{#cider?}}
                   [figwheel-sidecar "0.5.9"]
                   [com.cemerick/piggieback "0.2.1"]{{/cider?}}]

    :plugins      [[lein-figwheel "0.5.9"]{{#test?}}
                   [lein-doo "0.1.7"]{{/test?}}]
    }}

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
                    :preloads             [devtools.preload]
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

  :prep-tasks [["cljsbuild" "once" "min"]{{{prep-garden}}}{{{prep-less}}}{{{prep-sass}}} "compile"]{{/handler?}}
  )

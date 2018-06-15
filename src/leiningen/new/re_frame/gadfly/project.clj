(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [ns-tracker "0.3.1"]
                 [reagent "0.7.0"]
                 [re-frame "0.10.5"]
                 [re-frame-utils "0.1.0"]
                 [day8.re-frame/async-flow-fx "0.0.10"]
                 [guaranteed-rate/re-flow "0.8.0"]
                 [funcool/bide "1.6.0"]
                 [garden "1.3.5"]
                 [re-pressed "0.2.1"]
                 [rid3 "0.2.1"]
                 [soda-ash "0.79.1"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-garden "0.2.8"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/css"]

  :clean-targets ^{:protect false} ["resources/public/js"
                                    "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :garden {:builds [{:id           "screen"
                     :source-paths ["src/css"]
                     :stylesheet   {{name}}.css/screen
                     :compiler     {:output-to     "resources/public/css/screen.css"
                                    :pretty-print? true}}]}

  :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]
                   [day8.re-frame/re-frame-10x "0.3.3"]
                   [day8.re-frame/tracing "0.5.1"]
                   [figwheel-sidecar "0.5.16"]
                   [cider/piggieback "0.3.5"]
                   [re-frisk "0.5.3"]]

    :plugins      [[lein-figwheel "0.5.16"]]}
   :prod { :dependencies [[day8.re-frame/tracing-stubs "0.5.1"]]}}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/app"]
     :figwheel     {:on-jsload "{{name}}.core/mount-root"}
     :compiler     {:main                 {{name}}.core
                    :output-to            "resources/public/js/app.js"
                    :output-dir           "resources/public/js/app"
                    :asset-path           "js/app"
                    :source-map-timestamp true
                    :preloads             [devtools.preload
                                           day8.re-frame-10x.preload
                                           re-frisk.preload]
                    :closure-defines      {"re_frame.trace.trace_enabled_QMARK_" true
                                           "day8.re_frame.tracing.trace_enabled_QMARK_" true}
                    :external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/app"]
     :compiler     {:main            {{name}}.core
                    :output-to       "resources/public/js/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}

    ]})

(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library
                               org.clojure/google-closure-library-third-party]]
                 [thheller/shadow-cljs "2.8.76"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.9"]{{#re-com?}}
                 [re-com "2.6.0"]{{/re-com?}}{{#routes?}}
                 [secretary "1.2.3"]{{/routes?}}{{#garden?}}
                 [garden "1.3.9"]
                 [ns-tracker "0.4.0"]{{/garden?}}{{#handler?}}
                 [compojure "1.6.1"]
                 [yogthos/config "1.1.6"]
                 [ring "1.7.1"]{{/handler?}}{{#re-pressed?}}
                 [re-pressed "0.3.1"]{{/re-pressed?}}{{#breaking-point?}}
                 [breaking-point "0.1.2"]{{/breaking-point?}}]

  :plugins [{{#garden?}}[lein-garden "0.3.0"]{{/garden?}}{{#less?}}
            [lein-less "1.7.5"]{{/less?}}
            [lein-shell "0.5.0"]]

  :min-lein-version "2.5.3"{{#cider?}}

  :jvm-opts ["-Xmx1G"]{{/cider?}}

  :source-paths ["src/clj" "src/cljs"]{{#test?}}

  :test-paths   ["test/cljs"]{{/test?}}

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"{{#test?}}
                                    "test/js"{{/test?}}{{#garden?}}
                                    "resources/public/css"{{/garden?}}]

{{#garden?}}

  :garden {:builds [{:id           "screen"
                     :source-paths ["src/clj"]
                     :stylesheet   {{name}}.css/screen
                     :compiler     {:output-to     "resources/public/css/screen.css"
                                    :pretty-print? true}}]}
{{/garden?}}{{#less?}}
  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}
{{/less?}}

  :shell {:commands {"open" {:windows ["cmd" "/c" "start"]
                             :macosx  "open"
                             :linux   "xdg-open"}}}

  :aliases {"dev"          ["with-profile" "dev" "do"
                            ["clean"]
                            ["run" "-m" "shadow.cljs.devtools.cli" "watch" "app"]]
            "prod"         ["with-profile" "prod" "do"
                            ["clean"]
                            ["run" "-m" "shadow.cljs.devtools.cli" "release" "app"]]
            "build-report" ["with-profile" "prod" "do"
                            ["clean"]
                            ["run" "-m" "shadow.cljs.devtools.cli" "run" "shadow.cljs.build-report" "app" "target/build-report.html"]
                            ["shell" "open" "target/build-report.html"]]
            "karma"        ["with-profile" "prod" "do"
                            ["clean"]
                            ["run" "-m" "shadow.cljs.devtools.cli" "compile" "karma-test"]
                            ["shell" "karma" "start" "--single-run" "--reporters" "junit,dots"]]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.11"]{{#10x?}}
                   [day8.re-frame/re-frame-10x "0.4.5"]
                   [day8.re-frame/tracing "0.5.3"]{{/10x?}}{{#re-frisk?}}
                   [re-frisk "0.5.4.1"]{{/re-frisk?}}]}

   :prod { {{#10x?}}:dependencies [[day8.re-frame/tracing-stubs "0.5.3"]]{{/10x?}}}{{#handler?}}

   :uberjar {:source-paths ["env/prod/clj"]{{#10x?}}
             :dependencies [[day8.re-frame/tracing-stubs "0.5.3"]]{{/10x?}}
             :omit-source  true
             :main         {{ns-name}}.server
             :aot          [{{ns-name}}.server]
             :uberjar-name "{{name}}.jar"
             :prep-tasks   ["compile" ["prod"]{{{prep-garden}}}{{{prep-less}}}]}{{/handler?}}
   })

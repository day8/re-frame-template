(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.2"]
                 [org.clojure/clojurescript "1.10.773"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library
                               org.clojure/google-closure-library-third-party]]
                 [thheller/shadow-cljs "2.11.18"]
                 [reagent "1.0.0"]
                 [re-frame "1.1.2"]{{#10x?}}
                 [day8.re-frame/tracing "0.6.0"]{{/10x?}}{{#re-com?}}
                 [re-com "2.13.2"]{{/re-com?}}{{#routes?}}
                 [clj-commons/secretary "1.2.4"]{{/routes?}}{{#garden?}}
                 [garden "1.3.10"]
                 [ns-tracker "0.4.0"]{{/garden?}}{{#handler?}}
                 [compojure "1.6.2"]
                 [yogthos/config "1.1.7"]
                 [ring "1.8.2"]{{/handler?}}{{#re-pressed?}}
                 [re-pressed "0.3.1"]{{/re-pressed?}}{{#breaking-point?}}
                 [breaking-point "0.1.2"]{{/breaking-point?}}]

  :plugins [[lein-shadow "0.3.1"]
            {{#garden?}}[lein-garden "0.3.0"]{{/garden?}}{{#less?}}
            [lein-less "1.7.5"]{{/less?}}
            [lein-shell "0.5.0"]]

  :min-lein-version "2.9.0"{{#cider?}}

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

  :shadow-cljs {:nrepl {:port 8777}
                
                :builds {:app {:target :browser
                               :output-dir "resources/public/js/compiled"
                               :asset-path "/js/compiled"
                               :modules {:app {:init-fn {{name}}.core/init
                                               :preloads [devtools.preload{{#10x?}}
                                                          day8.re-frame-10x.preload{{/10x?}}{{#re-frisk?}}
                                                          re-frisk.preload{{/re-frisk?}}]}}{{#10x?}}
                               :dev {:compiler-options {:closure-defines {re-frame.trace.trace-enabled? true
                                                                          day8.re-frame.tracing.trace-enabled? true}}}
                               :release {:build-options
                                         {:ns-aliases
                                          {day8.re-frame.tracing day8.re-frame.tracing-stubs}}}{{/10x?}}

                               :devtools {:http-root "resources/public"
                                          :http-port 8280{{#handler?}}
                                          :http-handler {{name}}.handler/dev-handler{{/handler?}}
                                          }}{{#test?}}
                         :browser-test
                         {:target :browser-test
                          :ns-regexp "-test$"
                          :runner-ns shadow.test.browser
                          :test-dir "target/browser-test"
                          :devtools {:http-root "target/browser-test"
                                     :http-port 8290}}

                         :karma-test
                         {:target :karma
                          :ns-regexp "-test$"
                          :output-to "target/karma-test.js"}{{/test?}}}}
  
  :shell {:commands {"karma" {:windows         ["cmd" "/c" "karma"]
                              :default-command "karma"}
                     "open"  {:windows         ["cmd" "/c" "start"]
                              :macosx          "open"
                              :linux           "xdg-open"}}}

  :aliases {"dev"          ["do" 
                            ["shell" "echo" "\"DEPRECATED: Please use lein watch instead.\""]
                            ["watch"]]
            "watch"        ["with-profile" "dev" "do"
                            ["shadow" "watch" "app" "browser-test" "karma-test"]]

            "prod"         ["do"
                            ["shell" "echo" "\"DEPRECATED: Please use lein release instead.\""]
                            ["release"]]

            "release"      ["with-profile" "prod" "do"
                            ["shadow" "release" "app"]]

            "build-report" ["with-profile" "prod" "do"
                            ["shadow" "run" "shadow.cljs.build-report" "app" "target/build-report.html"]
                            ["shell" "open" "target/build-report.html"]]

            "karma"        ["do"
                            ["shell" "echo" "\"DEPRECATED: Please use lein ci instead.\""]
                            ["ci"]]
            "ci"           ["with-profile" "prod" "do"
                            ["shadow" "compile" "karma-test"]
                            ["shell" "karma" "start" "--single-run" "--reporters" "junit,dots"]]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "1.0.2"]{{#10x?}}
                   [day8.re-frame/re-frame-10x "0.7.0"]{{/10x?}}{{#re-frisk?}}
                   [re-frisk "1.3.10"]{{/re-frisk?}}]
    :source-paths ["dev"]}

   :prod {}
   
   {{#handler?}}
   :uberjar {:source-paths ["env/prod/clj"]
             :omit-source  true
             :main         {{ns-name}}.server
             :aot          [{{ns-name}}.server]
             :uberjar-name "{{name}}.jar"
             :prep-tasks   ["compile" ["release"]{{{prep-garden}}}{{{prep-less}}}]}{{/handler?}}}

  :prep-tasks [{{#garden?}}["garden" "once"]{{/garden?}}{{#less?}}
               ["less" "once"]{{/less?}}])

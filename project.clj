(defproject re-frame/lein-template "0.3.23-SNAPSHOT"
  :description "Leiningen template for a Reagent web app that implements the re-frame pattern."
  :url "https://github.com/Day8/re-frame-template"
  :license {:name "MIT"}
  
  :deploy-repositories [["clojars" {:sign-releases false
                                    :url "https://clojars.org/repo"
                                    :username :env/CLOJARS_USERNAME
                                    :password :env/CLOJARS_PASSWORD}]]

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "v" "--no-sign"]
                  ["deploy" "clojars"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]

  :scm {:name "git"
        :url "https://github.com/Day8/re-frame-template"}
  
  :eval-in-leiningen true)

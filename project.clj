(defproject re-frame/lein-template "lein-git-inject/version"
  :description "Leiningen template for a Reagent web app that implements the re-frame pattern."
  :url "https://github.com/day8/re-frame-template"
  :license {:name "MIT"}

  :plugins      [[day8/lein-git-inject "0.0.11"]
                 [lein-shadow          "0.2.2"]]

  :middleware   [leiningen.git-inject/middleware]

  :deploy-repositories [["clojars" {:sign-releases false
                                    :url "https://clojars.org/repo"
                                    :username :env/CLOJARS_USERNAME
                                    :password :env/CLOJARS_TOKEN}]]

  :release-tasks [["deploy" "clojars"]]

  :scm {:name "git"
        :url "https://github.com/day8/re-frame-template"}
  
  :eval-in-leiningen true)

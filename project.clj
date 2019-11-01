(defproject re-frame/lein-template "see :git-version below https://github.com/arrdem/lein-git-version"
  :description "Leiningen template for a Reagent web app that implements the re-frame pattern."
  :url "https://github.com/day8/re-frame-template"
  :license {:name "MIT"}

  :git-version
  {:status-to-version
   (fn [{:keys [tag version branch ahead ahead? dirty?] :as git}]
     (assert (re-find #"\d+\.\d+\.\d+" tag)
       "Tag is assumed to be a raw SemVer version")
     (if (and tag (not ahead?) (not dirty?))
       tag
       (let [[_ prefix patch] (re-find #"(\d+\.\d+)\.(\d+)" tag)
             patch            (Long/parseLong patch)
             patch+           (inc patch)]
         (format "%s.%d-%s-SNAPSHOT" prefix patch+ ahead))))}

  :plugins [[me.arrdem/lein-git-version "2.0.3"]]

  :deploy-repositories [["clojars" {:sign-releases false
                                    :url "https://clojars.org/repo"
                                    :username :env/CLOJARS_USERNAME
                                    :password :env/CLOJARS_PASSWORD}]]

  :release-tasks [["deploy" "clojars"]]

  :scm {:name "git"
        :url "https://github.com/day8/re-frame-template"}
  
  :eval-in-leiningen true)

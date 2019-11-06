(defproject re-frame/lein-template "see :git-version below https://github.com/arrdem/lein-git-version"
  :description "Leiningen template for a Reagent web app that implements the re-frame pattern."
  :url "https://github.com/day8/re-frame-template"
  :license {:name "MIT"}

  :git-version
  {:status-to-version
   (fn [{:keys [tag version branch ahead ahead? dirty?] :as git-status}]
     (if-not (string? tag)
       ;; If git-status is nil (i.e. IntelliJ reading project.clj) then return an empty version.
       "_"
       (if (and (not ahead?) (not dirty?))
         tag
         (let [[_ major minor patch suffix] (re-find #"v?(\d+)\.(\d+)\.(\d+)(-.+)?" tag)]
           (if (nil? major)
             ;; If tag is poorly formatted then return GIT-TAG-INVALID
             "GIT-TAG-INVALID"
             (let [patch' (try (Long/parseLong patch) (catch Throwable _ 0))
                   patch+ (inc patch')]
               (str major "." minor "." patch+ suffix "-" ahead "-SNAPSHOT")))))))}

  :plugins [[me.arrdem/lein-git-version "2.0.3"]]

  :deploy-repositories [["clojars" {:sign-releases false
                                    :url "https://clojars.org/repo"
                                    :username :env/CLOJARS_USERNAME
                                    :password :env/CLOJARS_PASSWORD}]]

  :release-tasks [["deploy" "clojars"]]

  :scm {:name "git"
        :url "https://github.com/day8/re-frame-template"}
  
  :eval-in-leiningen true)

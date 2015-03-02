(ns leiningen.new.re-frame
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "re-frame"))

(defn re-frame
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' re-frame project.")
    (->files data
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             ["{{sanitized}}.css" (render "project_name.css" data)]
             ["{{sanitized}}.html" (render "project_name.html" data)]

             ["devsrc/{{sanitized}}/dev.cljs" (render "devsrc/project_name/dev.cljs" data)]

             ["src/{{sanitized}}/core.cljs" (render "src/project_name/core.cljs" data)])))

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
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))

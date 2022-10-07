(ns leiningen.new.options.github-actions
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+github-actions")

(defn files [data]
  [[".github/workflows/test.yaml" (helpers/render "github/workflows/test.yaml" data)]])

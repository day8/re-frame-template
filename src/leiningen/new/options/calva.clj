(ns leiningen.new.options.calva
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+calva")

(defn files [data]
  [[".vscode/settings.json" (helpers/render "calva-settings.json" data)]])

(ns leiningen.new.options.helpers
  (:use [leiningen.new.templates :only [renderer sanitize]]
        [clojure.java.io :as io]))

(def template-name "re-frame")

(def render-text (renderer template-name))

(defn resource-input
  "Get resource input stream. Useful for binary resources like images."
  [resource-path]
  (-> (str "leiningen/new/" (sanitize template-name) "/" resource-path)
      io/resource
      io/input-stream))

(defn render
  "Render the content of a resource"
  ([resource-path]
   (resource-input resource-path))
  ([resource-path data]
   (render-text resource-path data)))

(defn option? [name options]
  (let [option-name (str "+" name)]
    (some #{option-name} options)))

(defn invoke-option [option options]
  (fn [block]
    (if (option? option options) (str block) "")))

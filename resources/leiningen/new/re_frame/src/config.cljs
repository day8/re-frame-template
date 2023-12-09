(ns {{ns-name}}.config)

(def debug?
  ^boolean goog.DEBUG){{#git-inject?}}

(goog-define ^js/String version "unknown"){{/git-inject?}}
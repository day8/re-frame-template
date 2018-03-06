(ns leiningen.new.re-frame
  (:require
   [leiningen.core.main :as main]
   [leiningen.new.options.base :as base]
   [leiningen.new.options.garden :as garden]
   [leiningen.new.options.less :as less]
   [leiningen.new.options.handler :as handler]
   [leiningen.new.options.re-com :as re-com]
   [leiningen.new.options.routes :as routes]
   [leiningen.new.options.test :as test]
   [leiningen.new.options.views :as views]
   [leiningen.new.options.helpers :as helpers]
   [leiningen.new.options.gadfly :as gadfly] ;; <-- intentionally undocumented
   [clojure.set :as set])
  (:use [leiningen.new.templates :only [name-to-path sanitize-ns ->files]]))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Files & Data for Template

(defn app-files [data options]
  (if (helpers/option? gadfly/option options)
    ;; then
    (gadfly/files data)
    ;;else
    (concat
     (base/files data)
     (views/view-cljs options data)

     (when (helpers/option? garden/option options) (garden/files data))
     (when (helpers/option? less/option options) (less/files data))
     (when (helpers/option? handler/option options) (handler/files data))
     (when (helpers/option? re-com/option options) (re-com/assets data))
     (when (helpers/option? routes/option options) (routes/routes-cljs data))
     (when (helpers/option? test/option options) (test/files data)))))

(defn template-data [name options]
  {:name      name
   :ns-name   (sanitize-ns name)
   :sanitized (name-to-path name)
   :cider?    (helpers/invoke-option "+cider" options)
   :aliases?  (helpers/option? "+aliases" options)
   :garden?   (helpers/invoke-option garden/option options)
   :handler?  (helpers/invoke-option handler/option options)
   :less?     (helpers/invoke-option less/option options)
   :re-com?   (helpers/invoke-option re-com/option options)
   :re-frisk? (helpers/invoke-option "+re-frisk" options)
   :routes?   (helpers/invoke-option routes/option options)
   :test?     (helpers/invoke-option test/option options)
   :10x?      (helpers/invoke-option "+10x" options)

   ;;prep-tasks
   :prep-garden (when (helpers/option? garden/option options)
                  ["garden" "once"])
   :prep-less   (when (helpers/option? less/option options)
                  ["less" "once"])
   })



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Check Options

(def available-set
  #{"+cider"
    "+aliases"
    garden/option
    handler/option
    less/option
    re-com/option
    "+re-frisk"
    routes/option
    test/option
    "+10x"
    ;; Note: this is a standalone, intentionally undocumented, option
    gadfly/option
    })

(defn check-available [options]
  (let [options-set (into #{} options)
        abort?      (not (set/superset? available-set
                                        options-set))]
    (when abort?
      (main/abort "\nError: invalid profile(s)\n"))))

(defn check-options
  "Check the user-provided options"
  [options]
  (doto options
    check-available))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Main

(defn re-frame [name & options]
  (let [data (template-data name options)]
    (check-options options)
    (main/info "Generating re-frame project.")
    (apply ->files data
           (app-files data options))))

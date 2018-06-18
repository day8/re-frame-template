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

     ;; css
     (when (helpers/option? garden/option options) (garden/files data))
     (when (helpers/option? less/option options) (less/files data))

     ;; debug
     ;;

     ;; development
     (when (helpers/option? test/option options) (test/files data))

     ;; full-stack
     (when (helpers/option? handler/option options) (handler/files data))

     ;; misc.
     (when (helpers/option? re-com/option options) (re-com/assets data))

     ;; routing
     (when (helpers/option? routes/option options) (routes/routes-cljs data))
     )))


(defn template-data [name options]
  {:name      name
   :ns-name   (sanitize-ns name)
   :sanitized (name-to-path name)

   ;; css
   :garden? (helpers/invoke-option garden/option options)
   :less?   (helpers/invoke-option less/option options)

   ;; debug
   :re-frisk? (helpers/invoke-option "+re-frisk" options)
   :10x?      (helpers/option? "+10x" options)

   ;; devlopment
   :cider?   (helpers/invoke-option "+cider" options)
   :test?    (helpers/invoke-option test/option options)
   :aliases? (helpers/option? "+aliases" options)

   ;; full-stack
   :handler?    (helpers/invoke-option handler/option options)
   :prep-garden (when (helpers/option? garden/option options)
                  ["garden" "once"])
   :prep-less   (when (helpers/option? less/option options)
                  ["less" "once"])

   ;; misc.
   :re-com?     (helpers/invoke-option re-com/option options)
   :re-pressed? (helpers/option? "+re-pressed" options)
   :breaking-point? (helpers/option? "+breaking-point" options)

   ;; routing
   :routes? (helpers/invoke-option routes/option options)
   })



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Check Options

(def available-set
  #{;; css
    garden/option
    less/option

    ;; debug
    "+re-frisk"
    "+10x"

    ;; development
    "+cider"
    test/option
    "+aliases"

    ;; full-stack
    handler/option

    ;; misc.
    re-com/option
    "+re-pressed"
    "+breaking-point"

    ;; routing
    routes/option

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

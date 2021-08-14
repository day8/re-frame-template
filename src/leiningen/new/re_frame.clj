(ns leiningen.new.re-frame
  (:require
   [leiningen.core.main :as main]
   [leiningen.new.options.base :as base]
   [leiningen.new.options.garden :as garden]
   [leiningen.new.options.kondo :as kondo]
   [leiningen.new.options.re-com :as re-com]
   [leiningen.new.options.routes :as routes]
   [leiningen.new.options.test :as test]
   [leiningen.new.options.views :as views]
   [leiningen.new.options.helpers :as helpers]
   [leiningen.new.options.cider :as cider]
   [leiningen.new.options.github-actions :as github-actions]
   [clojure.set :as set])
  (:use [leiningen.new.templates :only [name-to-path sanitize-ns ->files]]))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Files & Data for Template

(defn app-files [data options]
  (concat
   (base/files data)
   (views/view-cljs options data)

   ;; css
   (when (helpers/option? garden/option options) (garden/files data))

   ;; debug
   ;;

   ;; development
   (when (helpers/option? kondo/option options) (kondo/files data))
   (when (helpers/option? test/option options) (test/files data))

   ;; full-stack
   (when (helpers/option? cider/option options) (cider/files data))

   ;; misc.
   (when (helpers/option? re-com/option options) (re-com/assets data))
   (when (helpers/option? github-actions/option options) (github-actions/files data))

   ;; routing
   (when (helpers/option? routes/option options) (routes/routes-cljs data))))



(defn template-data [name options]
  {:name      name
   :ns-name   (sanitize-ns name)
   :sanitized (name-to-path name)

   ;; css
   :garden? (helpers/option? garden/option options)

   ;; debug
   :re-frisk? (helpers/option? "+re-frisk" options)
   :10x?      (helpers/option? "+10x" options)

   ;; development
   :cider?   (helpers/option? cider/option options)
   :kondo?   (helpers/option? kondo/option options)
   :test?    (helpers/option? test/option options)
   :git-inject? (helpers/option? "+git-inject" options)

   ;; misc.
   :re-com?     (helpers/option? re-com/option options)
   :re-pressed? (helpers/option? "+re-pressed" options)
   :breaking-point? (helpers/option? "+breaking-point" options)
   :github-actions? (helpers/option? github-actions/option options)

   ;; routing
   :routes? (helpers/option? routes/option options)})




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Check Options

(def available-set
  #{;; css
    garden/option

    ;; debug
    "+re-frisk"
    "+10x"

    ;; development
    cider/option
    kondo/option
    test/option
    "+git-inject"

    ;; misc.
    re-com/option
    "+re-pressed"
    "+breaking-point"
    github-actions/option

    ;; routing
    routes/option})



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

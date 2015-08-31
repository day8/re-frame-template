(ns leiningen.new.re-frame  
  (:require [leiningen.new.options.base :as base]
            [leiningen.new.options.garden :as garden]
            [leiningen.new.options.re-com :as re-com]
            [leiningen.new.options.routes :as routes]
            [leiningen.new.options.test :as test]
            [leiningen.new.options.views :as views]
            [leiningen.new.options.helpers :as helpers])
  (:use [leiningen.new.templates :only [name-to-path sanitize-ns ->files]]))

(defn app-files [data options]
  (concat
   (base/files data)
   (views/view-cljs options data)

   (when (helpers/option? garden/option options) (garden/files data))
   (when (helpers/option? re-com/option options) (re-com/assets data))
   (when (helpers/option? routes/option options) (routes/routes-cljs data))
   (when (helpers/option? test/option options) (test/files data)) ))

(defn template-data [name options]
  {:name name
   :ns-name (sanitize-ns name)
   :sanitized (name-to-path name)
   :garden? (helpers/invoke-option garden/option options)
   :re-com? (helpers/invoke-option re-com/option options)
   :routes? (helpers/invoke-option routes/option options)
   :test? (helpers/invoke-option test/option options)})

(defn re-frame [name & options]
  (let [data (template-data name options)]
    (apply ->files data
           (app-files data options))))

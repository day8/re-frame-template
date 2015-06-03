(ns leiningen.new.re-frame
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "re-frame"))

;; --------------------
(defn create-option [name]
  (let [option-name (str "+" name)]
    (partial some #{option-name})))

(defn invoke-option [option? options]
  (fn [block] 
    (if (option? options) (str block) "")))

;; available options
(defn re-com? [options]
  ((create-option "re-com") options))

(defn routes? [options]
  ((create-option "routes") options))

;; --------------------
(defn app-files [data options]
  (concat
   [["README.md" (render "README.md" data)]
    ["project.clj" (render "project.clj" data)]
    ["resources/public/index.html" (render "resources/public/index.html" data)]
    ["src/clj/{{sanitized}}/core.clj" (render "src/clj/core.clj" data)]
    ["src/cljs/{{sanitized}}/core.cljs" (render "src/cljs/core.cljs" data)]
    ["src/cljs/{{sanitized}}/db.cljs" (render "src/cljs/db.cljs" data)]
    ["src/cljs/{{sanitized}}/subs.cljs" (render "src/cljs/subs.cljs" data)]
    ["src/cljs/{{sanitized}}/handlers.cljs" (render "src/cljs/handlers.cljs" data)]]
   
   (if (re-com? options)
     [["resources/public/assets/css/re-com.css" (render "resources/public/vendor/css/re-com.css" data)]
      ["resources/public/assets/css/chosen-sprite@2x.png" (render "resources/public/vendor/css/chosen-sprite@2x.png" data)]
      ["resources/public/assets/css/chosen-sprite.png" (render "resources/public/vendor/css/chosen-sprite.png" data)]
      ["resources/public/assets/css/material-design-iconic-font.min.css" (render "resources/public/vendor/css/material-design-iconic-font.min.css" data)]

      ["resources/public/assets/fonts/Material-Design-Iconic-Font.eot" (render "resources/public/vendor/fonts/Material-Design-Iconic-Font.eot" data)]
      ["resources/public/assets/fonts/Material-Design-Iconic-Font.svg" (render "resources/public/vendor/fonts/Material-Design-Iconic-Font.svg" data)]
      ["resources/public/assets/fonts/Material-Design-Iconic-Font.ttf" (render "resources/public/vendor/fonts/Material-Design-Iconic-Font.ttf" data)]
      ["resources/public/assets/fonts/Material-Design-Iconic-Font.woff" (render "resources/public/vendor/fonts/Material-Design-Iconic-Font.woff" data)]])

   (if (routes? options)
     [["src/cljs/{{sanitized}}/routes.cljs" (render "src/cljs/routes.cljs" data)]])
   
   (cond (and (re-com? options) (routes? options))
         [["src/cljs/{{sanitized}}/views.cljs" (render "src/cljs/views_recom_routes.cljs" data)]]

         (re-com? options)
         [["src/cljs/{{sanitized}}/views.cljs" (render "src/cljs/views_recom.cljs" data)]]

         (routes? options)
         [["src/cljs/{{sanitized}}/views.cljs" (render "src/cljs/views_routes.cljs" data)]]

         :else
         [["src/cljs/{{sanitized}}/views.cljs" (render "src/cljs/views.cljs" data)]]) ))

;; --------------------
(defn template-data [name options]
  {:name name
   :ns-name (sanitize-ns name)
   :sanitized (name-to-path name)
   :re-com? (invoke-option re-com? options)
   :routes? (invoke-option routes? options)})

(defn re-frame [name & options]
  (let [data (template-data name options)]
    (apply ->files data
           (app-files data options))))

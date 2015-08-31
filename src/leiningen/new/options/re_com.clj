(ns leiningen.new.options.re-com
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "re-com")

(defn assets [data]
  [["resources/public/vendor/css/re-com.css" (helpers/render "resources/public/vendor/css/re-com.css" data)]
   ["resources/public/vendor/css/chosen-sprite@2x.png" (helpers/render "resources/public/vendor/css/chosen-sprite@2x.png")]
   ["resources/public/vendor/css/chosen-sprite.png" (helpers/render "resources/public/vendor/css/chosen-sprite.png")]
   ["resources/public/vendor/css/material-design-iconic-font.min.css" (helpers/render "resources/public/vendor/css/material-design-iconic-font.min.css" data)]

   ["resources/public/vendor/fonts/Material-Design-Iconic-Font.eot" (helpers/render "resources/public/vendor/fonts/Material-Design-Iconic-Font.eot")]
   ["resources/public/vendor/fonts/Material-Design-Iconic-Font.svg" (helpers/render "resources/public/vendor/fonts/Material-Design-Iconic-Font.svg")]
   ["resources/public/vendor/fonts/Material-Design-Iconic-Font.ttf" (helpers/render "resources/public/vendor/fonts/Material-Design-Iconic-Font.ttf")]
   ["resources/public/vendor/fonts/Material-Design-Iconic-Font.woff" (helpers/render "resources/public/vendor/fonts/Material-Design-Iconic-Font.woff")]
   ["resources/public/vendor/fonts/Material-Design-Iconic-Font.woff2" (helpers/render "resources/public/vendor/fonts/Material-Design-Iconic-Font.woff2")]])

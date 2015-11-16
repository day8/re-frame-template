(ns {{ns-name}}.handler
  (:require [compojure.core :refer [GET defroutes]]
            [ring.util.response :refer [file-response]]))

(defroutes handler
  (GET "/" [] (file-response "index.html" {:root "resources/public"})))

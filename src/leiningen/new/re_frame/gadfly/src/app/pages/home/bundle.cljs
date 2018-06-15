(ns {{ns-name}}.pages.home.bundle
  (:require
   [{{ns-name}}.pages.home.page :as page]
   [{{ns-name}}.pages.home.route :as route]
   ))


(def main
  {:page  page/main
   :route route/main
   })

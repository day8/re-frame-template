(ns {{ns-name}}.pages.about.bundle
  (:require
   [{{ns-name}}.pages.about.page :as page]
   [{{ns-name}}.pages.about.route :as route]
   ))


(def main
  {:page  page/main
   :route route/main
   })

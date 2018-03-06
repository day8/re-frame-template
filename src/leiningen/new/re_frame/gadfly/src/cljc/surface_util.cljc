(ns {{ns-name}}.surface-util
  (:require
   [{{ns-name}}.vars :as vars]))


(defn ->surface [page-key surface-extension]
  (cond
    (and page-key surface-extension)
    (some-> page-key
            name
            (str "-" (name surface-extension))
            keyword)

    page-key
    (some-> page-key
            name
            keyword)

    :else nil))

(def map-header-default
  {:key              :default
   :background-color vars/color-black
   })


(def map-header-dropdown-default
  {:key              :default
   :active?          false
   :full-width?      true
   :top              (+ vars/h3-line-height
                        (* 4 vars/spacer-padding))
   })

(def map-header-dropdown-default-active
  (assoc map-header-dropdown-default
         :active? true))

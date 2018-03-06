(ns {{ns-name}}.css.headings
  (:require
   [{{ns-name}}.vars :as vars]))

(def colors
  [;; default color
   {:color vars/color-black}

   [:&.white
    {:color "white"}]
   [:&.grey-light
    {:color vars/color-grey-light}]
   [:&.grey
    {:color vars/color-grey}]
   [:&.grey-dark
    {:color vars/color-grey-dark}]
   [:&.primary
    {:color vars/color-primary}]
   [:&.primary-active
    {:color vars/color-primary-active}]
   ])

(def weights
  [[:&.bold
    {:font-weight 500}]])

(defn heading [v]
  (into v (concat colors weights)))


(def span
  (heading
   [:span]))

(def p
  (heading
   [:p
    {:font-size vars/font-size-default-px
     :margin    0}
    ]))

(def h1
  (heading
   [:h1
    {:font-size   vars/h1-font-size-px
     :line-height vars/h1-line-height-px
     :font-family "Lato, sans-serif"
     :font-weight 400
     :margin      0}]))

(def h2
  (heading
   [:h2
    {:font-size   vars/h2-font-size-px
     :line-height vars/h2-line-height-px
     :font-family "Lato, sans-serif"
     :font-weight 400
     :margin      0}]))

(def h3
  (heading
   [:h3
    {:font-size   vars/h3-font-size-px
     :line-height vars/h3-line-height-px
     :font-family "Lato, sans-serif"
     :font-weight 400
     :margin      0}]))

(def h4
  (heading
   [:h4
    {:font-size   vars/h4-font-size-px
     :line-height vars/h4-line-height-px
     :font-family "Lato, sans-serif"
     :font-weight 400
     :margin      0}]))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Style

(def style
  [span
   p
   h1
   h2
   h3
   h4
   ])

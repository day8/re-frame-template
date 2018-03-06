(ns {{ns-name}}.css.paddings
  (:require
   [{{ns-name}}.vars :as vars]))


(defn create-padding-all [n]
  [(str ".pa" n)
   {:padding (str (* n vars/spacer-padding)
                  "px !important")}])

(defn create-padding-x [n]
  (let [padding (str (* n vars/spacer-padding)
                     "px !important")]
    [(str ".px" n)
     {:padding {:left  padding
                :right padding}}]))

(defn create-padding-y [n]
  (let [padding (str (* n vars/spacer-padding)
                     "px !important")]
    [(str ".py" n)
     {:padding {:top    padding
                :bottom padding}}]))

(defn create-padding-top [n]
  (let [padding (str (* n vars/spacer-padding)
                     "px !important")]
    [(str ".pt" n)
     {:padding-top padding}]))

(defn create-padding-bottom [n]
  (let [padding (str (* n vars/spacer-padding)
                     "px !important")]
    [(str ".pb" n)
     {:padding-bottom padding}]))

(defn create-padding-left [n]
  (let [padding (str (* n vars/spacer-padding)
                     "px !important")]
    [(str ".pl" n)
     {:padding-left padding}]))

(defn create-padding-right [n]
  (let [padding (str (* n vars/spacer-padding)
                     "px !important")]
    [(str ".pr" n)
     {:padding-right padding}]))



(def padding-all
  (mapv create-padding-all (range 0 9)))

(def padding-x
  (mapv create-padding-x (range 0 9)))

(def padding-y
  (mapv create-padding-y (range 0 9)))

(def padding-top
  (mapv create-padding-top (range 0 9)))

(def padding-bottom
  (mapv create-padding-bottom (range 0 9)))

(def padding-left
  (mapv create-padding-left (range 0 9)))

(def padding-right
  (mapv create-padding-right (range 0 9)))


(def style
  [padding-all
   padding-x
   padding-y
   padding-top
   padding-bottom
   padding-left
   padding-right])

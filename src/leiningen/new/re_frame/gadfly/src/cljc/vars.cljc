(ns {{ns-name}}.vars)

(defn px [x]
  (str x "px"))

(def font-size-default 14)
(def line-height-default (int (* 1.2 font-size-default)))

(def font-size-default-px (px font-size-default))
(def line-height-default-px (px line-height-default))

(def h1-font-size (int (* 3.157 font-size-default)))
(def h1-line-height (int (* 1.2 h1-font-size)))
(def h2-font-size (int (* 2.369 font-size-default)))
(def h2-line-height (int (* 1.2 h2-font-size)))
(def h3-font-size (int (* 1.777 font-size-default)))
(def h3-line-height (int (* 1.2 h3-font-size)))
(def h4-font-size (int (* 1.3333 font-size-default)))
(def h4-line-height (int (* 1.2 h4-font-size)))

(def h1-font-size-px (px h1-font-size))
(def h1-line-height-px (px h1-line-height))
(def h2-font-size-px (px h2-font-size))
(def h2-line-height-px (px h2-line-height))
(def h3-font-size-px (px h3-font-size))
(def h3-line-height-px (px h3-line-height))
(def h4-font-size-px (px h4-font-size))
(def h4-line-height-px (px h4-line-height))

(def spacer-padding 8)
(def spacer-margin 8)

(def color-black "#212121") ;; grey900
(def color-grey-dark "#616161") ;; grey700
(def color-grey "#9E9E9E") ;; grey500
(def color-grey-light "#E0E0E0") ;; grey300


(def color-primary "#26C6DA") ;;cyan400
(def color-primary-active "#00E5FF") ;; cyanA400

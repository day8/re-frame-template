(ns {{ns-name}}.db)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Path prefixes

(def breakpoints-prefix :breakpoints)
(def navigation-prefix :nav)
(def bin-prefix :bin)



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Default db

(def default-db
  {breakpoints-prefix nil
   navigation-prefix nil
   bin-prefix        nil
   })

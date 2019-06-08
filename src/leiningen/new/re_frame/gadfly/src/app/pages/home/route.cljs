(ns {{ns-name}}.pages.home.route
  (:require
   [re-frame.core :as rf]
   [re-pressed.core :as rp]
   [{{ns-name}}.db :as db]
   [{{ns-name}}.shared.bin.events :as be]
   [{{ns-name}}.shared.navigation.events :as ne]
   [{{ns-name}}.pages.home.events :as e]
   ))



(defn main [{:keys [id
                    params
                    query]}]
  (rf/dispatch [::ne/set-active-page id])
  (rf/dispatch [::be/reset-bin id])
  (rf/dispatch [::rp/set-keydown-rules
                {:event-keys [[[::e/set-re-pressed-example id "Hello, world!"]
                               [{:keyCode 72} ;; h
                                {:keyCode 69} ;; e
                                {:keyCode 76} ;; l
                                {:keyCode 76} ;; l
                                {:keyCode 79} ;; o
                                ]]]
                 :clear-keys
                 [[{:keyCode 27} ;; escape
                   ]]}]
               ))

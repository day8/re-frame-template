(ns {{ns-name}}.pages.about.route
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.shared.navigation.events :as ne]
   [{{ns-name}}.shared.bin.events :as be]
   ))



(defn main [{:keys [id
                    params
                    query]}]
  (rf/dispatch [::ne/set-active-page id])
  (rf/dispatch [::be/reset-bin id]))

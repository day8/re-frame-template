(ns {{ns-name}}.pages.bundle
  (:require
   [re-frame.core :as rf]
   [bide.core :as bide]
   [{{ns-name}}.shared.navigation.subs :as ns]
   [{{ns-name}}.pages.about.bundle :as about]
   [{{ns-name}}.pages.home.bundle :as home]
   ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

(defmulti page identity)
(defmethod page :home [] (:page home/main))
(defmethod page :about [] (:page about/main))
(defmethod page :default [] (fn [_] [:div]))


(defn current-page []
  (let [active-page @(rf/subscribe [::ns/active-page])]
    [:div
     [(page active-page)]]))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Route

(defmulti route identity)
(defmethod route :home [opts] (:route home/main))
(defmethod route :about [opts] (:route about/main))
(defmethod route :default [opts] (fn [] ))

(defonce router
  (bide/router
   [["/" :home]
    ["/about" :about]
    ]))


(defn on-navigate
  "A function which will be called on each route change."
  [active-page params query]
  (let [route-fn (route active-page)]
    (route-fn {:id     active-page
               :params params
               :query  query})))


(defn routes-start! []
  (bide/start! router {:default     :home
                       :on-navigate on-navigate}))

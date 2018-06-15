(ns {{ns-name}}.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as rf]
   [re-pressed.core :as rp]
   [day8.re-frame.async-flow-fx] ;; to include fx
   [{{ns-name}}.config :as config]
   [{{ns-name}}.db :as db]
   [{{ns-name}}.cofx] ;; to include cofxs
   [{{ns-name}}.fx] ;; to include fxs
   [{{ns-name}}.pages.bundle :as pages]
   [{{ns-name}}.shared.breakpoints.events :as bpe]
   ))



(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn track-page-width! []
  (rf/dispatch-sync [::bpe/set-page-width])
  (.addEventListener js/window "resize"
                     #(rf/dispatch-sync [::bpe/set-page-width])
                     true))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (reagent/render [pages/current-page]
                  (.getElementById js/document "app")))


(defn ^:export init []
  (rf/reg-event-db ::initialize-db (fn [_ _] db/default-db))
  (rf/dispatch-sync [::initialize-db])
  (rf/dispatch-sync [::rp/add-keyboard-event-listener "keydown"])
  (pages/routes-start!)
  (track-page-width!)
  (dev-setup)
  (mount-root))

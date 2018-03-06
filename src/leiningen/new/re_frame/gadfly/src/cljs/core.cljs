(ns {{ns-name}}.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as rf]
   [re-surface.core :as rs]
   [{{ns-name}}.coeffects :as coeffects]
   [{{ns-name}}.config :as config]
   [{{ns-name}}.effects :as effects]
   [{{ns-name}}.events :as events]
   [{{ns-name}}.routes :as routes]
   [{{ns-name}}.registries :as registries]
   [{{ns-name}}.subs :as subs]
   [{{ns-name}}.surface-util :as su]
   ))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn track-page-width! []
  (rf/dispatch-sync [::events/set-page-width])
  (.addEventListener js/window "resize"
                     #(rf/dispatch-sync [::events/set-page-width])
                     true))

(defn main-page []
  (let [active-page    @(rf/subscribe [::subs/active-page])
        active-surface @(rf/subscribe [::subs/active-surface])
        page-width     @(rf/subscribe [::subs/page-width])
        surface-key    (su/->surface active-page active-surface)]
    [:div
     (when (and active-surface
                page-width)
       [rs/surface {:app-state          (atom {})
                    :surface-key        surface-key
                    :surface-registry   (registries/surface-registry)
                    :component-registry (registries/component-registry)
                    :surface-config     {:debug? false}}])]))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (reagent/render [main-page]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (rf/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (track-page-width!)
  (mount-root))

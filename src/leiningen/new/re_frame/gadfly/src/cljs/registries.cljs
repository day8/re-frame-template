(ns {{ns-name}}.registries
  (:require
   [re-frame.core :as rf]
   [{{ns-name}}.events :as events]
   [{{ns-name}}.subs :as subs]
   [{{ns-name}}.surface-util :as su]
   [{{ns-name}}.pages.home.page :as home-page]
   [{{ns-name}}.pages.about.page :as about-page]
   ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Basic Components

(defn header-default []
  (let [active-surface   @(rf/subscribe [::subs/active-surface])
        dropdown-active? (= "dropdown-active" (some-> active-surface name))]
    [:div.pa2
     [:div.page-container
      [:div.flex-container.flex-space-between
       [:h3.primary.pointer.pr2
        {:on-click
         #(rf/dispatch [::events/set-hash "/"])}
        "{{name}}"]

       (if dropdown-active?
         ;; then
         [:h3.white.pointer.pl2
          {:on-click
           #(rf/dispatch[::events/set-active-surface :init])}
          [:i.fa.fa-close]]
         ;; else
         [:h3.white.pointer.pl2
          {:on-click
           #(rf/dispatch [::events/set-active-surface :dropdown-active])}
          [:i.fa.fa-chevron-down]])
       ]]]))

(defn header-dropdown-default []
  [:div.pa2
   [:div.page-container
    "THIS IS A DROPDOWN"
    ]])


(defn dimmer-noop []
  [:div])

(defn dimmer-default []
  [:div {:style {:width  "100%"
                 :height "100%"}
         :on-click
         #(rf/dispatch[::events/set-active-surface :init])}
   ])


(def basic-components
  {:header          {:default header-default}
   :header-dropdown {:default header-dropdown-default}
   :dimmer          {:noop    dimmer-noop
                     :default dimmer-default}})



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Registries

(defn component-registry []
  (reduce (fn [registry {:keys [header
                                header-dropdown
                                navbar
                                navbar-dropdown
                                body
                                footer
                                dimmer
                                sidebar-left
                                sidebar-right
                                modal
                                modal-fullscreen]}]
            (-> registry
                (update :header #(merge % header))
                (update :header-dropdown #(merge % header-dropdown))
                (update :navbar #(merge % navbar))
                (update :navbar-dropdown #(merge % navbar-dropdown))
                (update :body #(merge % body))
                (update :footer #(merge % footer))
                (update :dimmer #(merge % dimmer))
                (update :sidebar-left #(merge % sidebar-left))
                (update :sidebar-right #(merge % sidebar-right))
                (update :modal #(merge % modal))
                (update :modal-fullscreen #(merge % modal-fullscreen))))
          basic-components
          (remove nil?
                  [
                   home-page/components
                   about-page/components
                   ])))

(defn surface-registry []
  (merge
   {}
   home-page/surfaces
   about-page/surfaces
   ))

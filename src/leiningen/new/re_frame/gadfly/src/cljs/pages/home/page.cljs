(ns {{ns-name}}.pages.home.page
  (:require
   [{{ns-name}}.surface-util :as su]
   [{{ns-name}}.pages.home.comps :as comps]))



(def page-key :home)

(def surface-init (su/->surface page-key "init"))
(def surface-dropdown-active (su/->surface page-key "dropdown-active"))


(def surface-init-map
  {:header          su/map-header-default
   :header-dropdown su/map-header-dropdown-default
   :body            {:key              surface-init
                     :background-color "rgba(0,0,0,0)"}
   :dimmer          {:key :default}
   })

(def components
  {:body {surface-init comps/body}})

(def surfaces
  {surface-init surface-init-map

   surface-dropdown-active
   (-> surface-init-map
       (assoc-in [:header-dropdown :active?] true))})

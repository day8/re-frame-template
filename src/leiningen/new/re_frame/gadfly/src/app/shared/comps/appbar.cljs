(ns {{ns-name}}.shared.comps.appbar
  (:require
   [clojure.string :as string]
   [re-frame.core :as rf]
   [breaking-point.core :as bp]
   [soda-ash.core :as sa]
   [{{ns-name}}.shared.navigation.subs :as ns]
   [{{ns-name}}.shared.navigation.events :as ne]
   ))


(defn menu-item [id label active-page]
  [sa/MenuItem
   {:name     label
    :active   (= id active-page)
    :on-click #(rf/dispatch [::ne/navigate id])}])


(defn component []
  (let [active-page @(rf/subscribe [::ns/active-page])
        mobile? @(rf/subscribe [::bp/mobile?])]
    [sa/Menu
     {:inverted   true
      :color      "teal"
      :borderless true
      :style      {:border-radius 0}}

     [sa/Container
      [sa/MenuItem
       (merge
       {:on-click #(rf/dispatch [::ne/navigate :home])}
       (when-not mobile? {:fitted "horizontally"}))
       [sa/Header
        {:inverted true}
        "{{name}}"]]

      [sa/MenuMenu
       {:position "right"}
       [menu-item :home "Home" active-page]
       [menu-item :about "About" active-page]]]]
    ))

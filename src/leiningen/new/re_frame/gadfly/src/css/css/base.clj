(ns {{ns-name}}.css.base
  (:require
   [{{ns-name}}.vars :as vars]))

(def pointer
  [:.pointer
   {:cursor "pointer"}])


(def style
  [
   [:* {:font-family "Roboto, sans-serif"
        :font-weight 300
        :font-size   vars/font-size-default-px
        :margin      0
        :color       vars/color-black}]

   [:a {:color vars/color-primary}]
   [:i {:color "inherit"}]

   pointer

   ;; re-surface overrides
   [:.surf-main {:height "inherit !important"}]

   [:.surf-header-dropdown
    {:box-shadow "rgba(0, 0, 0, 0.117647) 0px 1px 6px, rgba(0, 0, 0, 0.117647) 0px 1px 4px"}
    ]
   ])

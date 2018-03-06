(ns {{ns-name}}.css.flex)


(def style
  [:.flex-container
   {:display "flex"}

   [:&.flex-end
    {:justify-content "flex-end"}]

   [:&.flex-space-around
    {:justify-content "space-around"}]

   [:&.flex-space-between
    {:justify-content "space-between"}]

   [:&.flex-center
    {:justify-content "center"}]

   [:&.flex-vert-center
    {:align-items "center"}]

   [:&.flex-vert-baseline
    {:align-items "baseline"}]

   [:&.flex-vert-end
    {:align-items "flex-end"}]

   [:&.flex-wrap
    {:flex-wrap "wrap"}]

   ;;
   [:.flex-1
    {:flex "1"}]
   ])

(ns {{ns-name}}.pages.home.comps.re-pressed-example
  (:require
   [re-frame.core :as rf]
   [soda-ash.core :as sa]
   [{{ns-name}}.pages.home.subs :as subs]))


(defn component []
  (let [re-pressed-example (rf/subscribe
                            [::subs/re-pressed-example])]
    [:div

     [:p
      [:span
       "Re-pressed is listening for keydown events. A message will be
       displayed when you type "]
      [:strong [:code "hello"]]
      [:span ". So go ahead, try it out!"]]

     (when-let [rpe @re-pressed-example]
       [sa/Message
        rpe])]))

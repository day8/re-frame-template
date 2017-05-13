(ns {{ns-name}}.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))
{{#routes?}}

(re-frame/reg-sub
 :active-panel
 (fn [db _]
   (:active-panel db)))
{{/routes?}}

(ns {{ns-name}}.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))
{{#routes?}}

(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))
{{/routes?}}
{{#re-pressed?}}

(re-frame/reg-sub
 ::re-pressed-example
 (fn [db _]
   (:re-pressed-example db)))
{{/re-pressed?}}

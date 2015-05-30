(ns {{ns-name}}.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :name
 (fn [db]
   (reaction (:name @db))))
{{#routes?}}

(re-frame/register-sub
 :active-panel
 (fn [db _]
   (reaction (:active-panel @db))))
{{/routes?}}

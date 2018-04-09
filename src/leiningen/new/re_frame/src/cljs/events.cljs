(ns {{ns-name}}.events
  (:require [re-frame.core :as re-frame]
            [{{ns-name}}.db :as db]
            {{#10x?}}[day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]{{/10x?}}))

(re-frame/reg-event-db
 ::initialize-db
 ({{^10x?}}fn{{/10x?}}{{#10x?}}fn-traced{{/10x?}} [_ _]
   db/default-db))
{{#routes?}}

(re-frame/reg-event-db
 ::set-active-panel
 ({{^10x?}}fn{{/10x?}}{{#10x?}}fn-traced{{/10x?}} [db [_ active-panel]]
   (assoc db :active-panel active-panel)))
{{/routes?}}

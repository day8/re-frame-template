(ns {{ns-name}}.interceptors
  (:require
   [cljs.spec.alpha :as spec]
   [re-frame.core :as rf]
   [{{ns-name}}.db :as db]))


(defn check-and-throw
  "Throws an exception if `db` doesn't match the Spec `a-spec`."
  [a-spec db]
  (when-not (spec/valid? a-spec db)
    (throw (ex-info
            (str "spec check failed: "
                 (spec/explain-str a-spec db)) {}))))


;; now we create an interceptor using `after`
(def check-db-spec
  (rf/after (partial check-and-throw ::db/db)))

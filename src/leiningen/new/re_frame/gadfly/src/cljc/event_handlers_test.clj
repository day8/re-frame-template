(ns {{ns-name}}.event-handlers-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [{{ns-name}}.event-handlers :as target]
   ))


(deftest db


  (testing "initial db"
    (is (= {}
           (target/initialize-db nil nil))))



  (testing "set-active-page"
    (is (= {:app {:page-key    nil
                  :surface-key nil}}
           (target/set-active-page {} [nil nil])))

    (is (= {:app {:page-key    "foo"
                  :surface-key :init}}
           (target/set-active-page {} [nil "foo"]))
        "surface-key should return keyword even if given string")

    (is (= {:app {:page-key    :foo
                  :surface-key :init}}
           (target/set-active-page {} [nil :foo]))))



  (testing "set-active-surface"
    (is (= {:app {:surface-key nil}}
           (target/set-active-surface {} [nil nil])))

    (is (= {:app {:surface-key :foo}}
           (target/set-active-surface {} [nil "foo"]))
        "should return keyword even if given string")

    (is (= {:app {:surface-key :foo}}
           (target/set-active-surface {} [nil :foo]))))

  )

(ns {{ns-name}}.surface-util-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [{{ns-name}}.surface-util :as target]
   ))


(deftest ->surface

  (testing "should return nil if no page-key"
    (is (nil? (target/->surface nil "foo"))))

  (testing "should return page-key if surface-extension is nil"
    (is (= :foo (target/->surface "foo" nil))))

  (testing "should return page-key plus surface-extension as keyword"
    (is (= :foo-bar (target/->surface "foo" "bar"))))

  )

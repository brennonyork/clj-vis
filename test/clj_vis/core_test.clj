(ns clj-vis.core-test
  (:require [clojure.test :refer :all]
            [clj-vis.core :refer :all]))

(deftest visuals
  (testing "Setting the visual elements"
    ;(is (->vis [1 2 3] ))
    )
  (testing "Retrieving the visual elements"
    ;; Manually setup objects for testing
    (let [; test collections with numbers
          obj1 (with-meta [1 2 3] {:clj-vis.core/vis "<ul>%v</ul>"
                                   :clj-vis.core/vis-combiner "<li>%v</li>"})
          ; test collections with various types
          obj2 (with-meta [1.0 "string" \b] {:clj-vis.core/vis "<ul>%v</ul>"
                                             :clj-vis.core/vis-combiner "<li>%v</li>"})
          ; test collections with arbitrary '%k' markers
          obj3 (with-meta [1.0 "string" \b] {:clj-vis.core/vis "<ul>%v</ul>"
                                             :clj-vis.core/vis-combiner "<li>%k%v</li>"})]
      (is (= (<-vis obj1) "<ul><li>1</li><li>2</li><li>3</li></ul>"))
      (is (= (<-vis obj2) "<ul><li>1.0</li><li>string</li><li>b</li></ul>"))
      (is (= (<-vis obj3) "<ul><li>1.0</li><li>string</li><li>b</li></ul>")))))

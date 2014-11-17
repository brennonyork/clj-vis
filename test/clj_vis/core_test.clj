(ns clj-vis.core-test
  (:require [clojure.test :refer :all]
            [clj-vis.core :refer :all]))

(deftest visuals
  (testing "Setting the visual elements"
    ;(is (->vis [1 2 3] ))
    )
  (testing "Retrieving the visual elements"
    (testing "With singular values"
      ;; Manually setup objects for testing
      (let [; test with only a value
            obj1 {:val (Integer. 1)}
            ; test a value and visualization
            obj2 {:clj-vis.core/vis "<ul>%v</ul>"
                  :val 1.0}
            ; test with visualizations and combiners
            obj3 {:clj-vis.core/vis "<ul>%v</ul>"
                  :clj-vis.core/combiner "<li>%v</li>"
                  :val "astr"}
            ; test with a combiner and no visualization
            obj4 {:clj-vis.core/combiner "<li>%v%k</li>"
                  :val \b}]
        (is (= (<vis obj1) "1"))
        (is (= (<vis obj2) "<ul>1.0</ul>"))
        (is (= (<vis obj3) "<ul><li>astr</li></ul>"))
        (is (= (<vis obj4) "<li>b</li>"))))
    (testing "With collections"
      ;; Manually setup objects for testing
      (let [; test collections with numbers
            obj1 {:clj-vis.core/vis "<ul>%v</ul>"
                  :clj-vis.core/combiner "<li>%v</li>"
                  :val [1 2 3]}
            ; test collections with various types
            obj2 {:clj-vis.core/vis "<ul>%v</ul>"
                  :clj-vis.core/combiner "<li>%v</li>"
                  :val [1.0 "string" \b]}
            ; test collections with arbitrary '%k' markers
            obj3 {:clj-vis.core/vis "<ul>%v</ul>"
                  :clj-vis.core/combiner "<li>%k%v</li>"
                  :val [1.0 "string" \b]}]
        (is (= (<vis obj1) "<ul><li>1</li><li>2</li><li>3</li></ul>"))
        (is (= (<vis obj2) "<ul><li>1.0</li><li>string</li><li>b</li></ul>"))
        (is (= (<vis obj3) "<ul><li>1.0</li><li>string</li><li>b</li></ul>"))))))

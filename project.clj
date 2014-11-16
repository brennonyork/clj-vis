(defproject clj-vis "0.1.0"
  :description "Simple way to add visual elements into Clojure data structures"
  :url "https://github.com/brennonyork/clj-vis"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot clj-vis.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

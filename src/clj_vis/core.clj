(ns clj-vis.core
  (:require [clojure.string :as clj-str])
  (:gen-class))

;; (->vis [1 2 3] "<ul class='testing'>%v</ul>" "<li>%v</li>")
;; => [1 2 3]
;; (meta [1 2 3]) => {:vis ""}
(defn ->vis
  [obj & [vis & combiner]]
  )

(defn <-vis
  [obj]
  (let [{vis-combiner :clj-vis.core/vis-combiner, vis :clj-vis.core/vis} (meta obj)
        replace-kvs (fn [k v]
                      (let [k (str k) v (str v)]
                        (clj-str/replace (clj-str/replace vis-combiner #"%k" k) #"%v" v)))
        collapsed-str (cond
                       ; handle maps (i.e. key-value pairs)
                       (map? obj) (clj-str/join "" (map replace-kvs obj))
                       ; handle collections of purely values (i.e. no keys)
                       (coll? obj) (loop [obj obj res ""]
                                     (if (empty? obj) res (recur
                                                           (rest obj) (str res (replace-kvs "" (first obj)))))))]
    (clj-str/replace vis #"%v" collapsed-str)))


;; (defn -main
;;   "I don't do a whole lot ... yet."
;;   [& args]
;;   (println "Hello, World!"))

(ns clj-vis.core
  (:require [clojure.string :as clj-str])
  (:gen-class))

(defn >vis
  [obj & [vis & combiner]]
  {::vis vis
   ::combiner combiner
   :val obj})

(defn <vis
  [obj]
  (let [{combiner :clj-vis.core/combiner, vis :clj-vis.core/vis, v :val} obj
        replace-kvs (fn [k v]
                      (let [k (str k) v (str v)]
                        (clj-str/replace (clj-str/replace combiner #"%k" k) #"%v" v)))
        collapsed-str (if (not combiner)
                        ; if no combiner, cast value (map, coll, etc.) to string and return
                        (str v)
                        (cond
                         ; handle maps (i.e. key-value pairs)
                         (map? v) (clj-str/join "" (map replace-kvs v))
                         ; handle collections of values (i.e. no keys)
                         (coll? v) (loop [v v res ""]
                                     (if (empty? v) res (recur
                                                         (rest v) (str res (replace-kvs "" (first v))))))
                         ; else we have a primitive singular value
                         :else (replace-kvs "" v)))]
    (if (not vis)
      collapsed-str
      (clj-str/replace vis #"%v" collapsed-str))))

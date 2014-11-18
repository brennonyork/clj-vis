(ns clj-vis.core
  (:refer-clojure :rename {replace core-replace})
  (:require [clojure.string :refer [replace join]])
  (:gen-class))

(defn >vis
  [obj & [vis & combiner]]
  {::vis vis
   ::combiner combiner
   :val obj})

(defn <vis
  [obj]
  (let [{combiner :clj-vis.core/combiner, vis :clj-vis.core/vis, v :val
         :or {combiner "%v" vis "%v"}} obj
        replace-fn (fn [k v] (replace (replace combiner #"%k" k) #"%v" v))
        combine-fn (fn
                     ([v] (let [v (str v)] (replace-fn "" v)))
                     ([k v] (let [k (str k) v (str v)] (replace-fn k v))))]
    (replace vis #"%v" (join "" (map combine-fn (if (not (coll? v)) (vector v) v))))))

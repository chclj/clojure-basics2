(ns basics-2.ex-01-play-with-collections
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))


(defn csv-data->maps [csv-data]
  (map zipmap
       (->> (first csv-data)
            (map keyword)
            repeat)
       (rest csv-data)))

(defn get-data
  ([file]
   (->
    (slurp file)
    (csv/read-csv)
    (csv-data->maps)))
  ([]
   (get-data "resources/books_new.csv")))

(count (get-data))

(reduce +
        (->> (get-data)
             (filter #(. (:Genre %1) contains "Programming"))
             (filter #(. (:Title %1) matches ".*Clojure.*"))
             #_(map :Price)
             (map #(Integer/parseInt (:Price %)))
             (reduce +)
             #_(set)
             #_(count)))



(count (set (map :Genre (get-data))))

(:Genre (nth (get-data) 1))
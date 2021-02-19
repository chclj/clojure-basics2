(ns basics-2.s_01_play_with_collections
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))


(defn csv-data->map
 "Reads the csv data to map" 
  [csv-data]
  (map zipmap
       (->> (first csv-data)
            (map keyword)
            repeat)
       (rest csv-data)))

(defn get-data
  "Gets the data from the file"
  ([file]
   (->
    (slurp file)
    (csv/read-csv)
    (csv-data->map)))
  ([]
   (get-data "resources/books_new.csv")))

(defn str-contains
  "Function that tells whether the given to-search string
   is part of the given source-str"
  [source-str to-search]
  (-> (str "(?i).*" to-search ".*")
      (re-pattern)
      (re-matches  source-str)
      (nil?)
      (not)))
  ;; (not  (nil? (re-matches (re-pattern (str "(?i).*" to-search ".*")) source-str))))

;; Practice:
;; 1. Get title of all the books
;; 2. Get tilte of all the books that has the word clojure in it
;; 3. Total price of all the Clojure books available

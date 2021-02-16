(ns basics-2.ex_03_recursion)

(defn fib 
  ([n]
   (cond 
   (= n 0) []
   (= n 1) [0]
   :else (fib [0 1] n)))
  ([x n]
   (let [cnt (count x)]
     (if (>= cnt n)
     x 
    (fib (conj x (apply +' (take-last 2 x))) n)))))

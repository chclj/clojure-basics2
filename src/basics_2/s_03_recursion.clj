(ns basics-2.s_03_recursion)

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


(last (fib 100))

(last (fib 10000))
;; StackOverflowError - The size of the stack is limited,
;; which recursion blowsup when done beyond the limit.

;; Regardless, recursion is a easy way of expressing the logic and
;; Invaraible almost that's the only way in most of functional programming languages

;; So, are Functional languages is inherently limited wrt the recursion.

;; Nope.
;; The solution is tail-call optimization

(defn fib-with-recur
  ([n]
   (cond
     (= n 0) []
     (= n 1) [0]
     :else (fib-with-recur [0 1] n)))
  ([x n]
   (let [cnt (count x)]
     (if (>= cnt n)
       x
       (recur (conj x (apply +' (take-last 2 x))) n)))))

(last (fib-with-recur 10000))

;; So you are overloading the function just for the purpose of additional
;; argument needed for recursion. You can get rid of it using loop


(defn fib-with-loop-recur
  ([n]
   (cond
     (= n 0) []
     (= n 1) [0]
     :else (loop [x [0 1] n n cnt (count x)]
               (if (>= cnt n)
                 x
                 (recur (conj x (apply +' (take-last 2 x))) n (inc cnt)))))))

(last (fib-with-loop-recur 5))
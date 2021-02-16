(ns basics-2.01_show_case)

;; Lazy - Seq

;; Takes first 2 element from the given list
(take 2 [1 2 3 4 5])

;; Takes first 10 elements from the range
(take 10 (range))

;; Takes first 20 elements from the range
(take 20 (range))

;; Able to guess what actually the range returns?

;; It returns a lazy sequence of numbers that is not realized until it's being
;; accessed.
;; 
;; This SoF answer gives a good mental model on how it works behind the scene.
;; https://stackoverflow.com/a/44102122



;; Fibonacci sequence under 50 characters

(def fib 
(lazy-cat 
 [0 1] 
 (map + fib (rest fib))))

(take 10 fib)

;; This gives a mental-model of how it works 
;; https://stackoverflow.com/a/56576524

;; With Macros you can write custom control structures

;; For ex, below is a handcrafter short-circuit or operator
(defmacro ||
  "Equivalent of or"
  ([] nil)
  ([expr]
   `~expr)
  ([expr & other-exprs]
   `(let [val# (|| ~expr)]
      (if val# val# (|| ~@other-exprs)))))

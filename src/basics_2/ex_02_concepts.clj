(ns basics-2.ex_02_concepts)


;; Pure functions
;; - Always returns the same value for the same parameters.
;; - Doesn't change any other part of the system

;; Not just simple mathematical functions,
;; Even operations on collections are pure in clojure

(sort > [2  3 4 1 -1])

;; Appends 5 at the end and returns a 'new' vector instead of changing
;; the given one
(conj [1 2 3 4] 5)

;; Immutable DS

(def v1 [1 2 3 4 5])

;; Removing all odd number from v1
(remove odd? v1)

;; Doesn't alter v1
(print v1)

;; Generally most of the functions with side-effects in Clojure ends with !
;; to indicate that it changes something in the system.
;; Note that all functions with side-effects are impue

;; Referential transparency
;; By-product of having pure functions, 
;; in which you can replace a function call with the value it returns
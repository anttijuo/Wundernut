(ns com.siili.wundernuts-test
  (:require [com.siili.wundernuts :refer :all])
  (:use midje.sweet))


(fact "Namelist is empty"
      namelist => ())

(fact "Read data from cube.txt and put it in vector format"
      (cube-from-text "cube.txt") => cube)

(fact "Get right letter from cube vector"
      (letter-from-cube 0 0 0) => "A"
      (letter-from-cube 0 0 1) => "J"
      (letter-from-cube 3 2 1) => "P")

(fact "Change words from words.txt to vector format"
      (wordlist "words.txt") => vector?
      (word 0) => #"aakkonen")

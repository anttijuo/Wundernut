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

(fact "get nth letter from word"
      (letter "derp" 0) => \d
      (letter "henrik" 4) => \i
      (letter "antti" 2) => \t)

(fact "Find distinct characters from cube"
      (distinct-letters) => ["A" "J" "F" "E"
                             "P" "U" "W" "O"
                             "G" "M" "R" "N"
                             "X" "K" "D" "S"
                             "I" "Q" "T" "L"])

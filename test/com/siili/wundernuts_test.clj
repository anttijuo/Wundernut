(ns com.siili.wundernuts-test
  (:require [com.siili.wundernuts :refer :all])
  (:use midje.sweet))


(fact "Namelist is empty"
      namelist => ())

(fact "Read data from cube.txt and put it in vector format"
      (cube-from-text "cube.txt") => cube)

(fact "Get right letter from cube vector"
      (letter-from-cube 0 0 0) => "a"
      (letter-from-cube 0 0 1) => "j"
      (letter-from-cube 3 2 1) => "p")

(fact "Change words from words.txt to vector format"
      (wordlist "words.txt") => vector?
      (word 0) => #"aakkonen")

(fact "get nth letter from word"
      (letter "derp" 0) => \d
      (letter "henrik" 4) => \i
      (letter "antti" 2) => \t)

(fact "Find distinct characters from cube"
      (distinct-letters) => ["a" "j" "f" "e"
                             "p" "u" "w" "o"
                             "g" "m" "r" "n"
                             "x" "k" "d" "s"
                             "i" "q" "t" "l"])

(fact "compare a letter to a letter of a word"
      (letter-found? "abra" "a") => true
      (letter-found? "derp" "b") => false
      (letter-found? "herpa" "p") => true)

(fact "get index of letter in a word"
      (letter-index "abra" "a") => 0
      (letter-index "derp" "r") => 2)

;(fact "create a new wordlist that has only words with distinct letters"
 ;     (words-with-distinct-letters ["apra" "kadabra" "alakazam"] => ["apra"]))

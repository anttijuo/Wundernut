(ns com.siili.wundernuts-test
  (:require [com.siili.wundernuts :refer :all])
  (:use midje.sweet))

(def test-cube [[["a" "j" "f" "e"]
                 ["a" "p" "u" "w"]
                 ["o" "g" "m" "r"]
                 ["m" "n" "x" "k"]]
                [["d" "n" "s" "i"]
                 ["f" "o" "d" "s"]
                 ["j" "e" "g" "i"]
                 ["w" "k" "p" "r"]]
                [["e" "q" "m" "f"]
                 ["r" "k" "i" "d"]
                 ["d" "m" "i" "r"]
                 ["e" "o" "s" "d"]]
                [["r" "t" "s" "l"]
                 ["d" "k" "p" "i"]
                 ["s" "p" "o" "i"]
                 ["j" "q" "d" "t"]]])

(fact "Namelist is empty"
      namelist => ())

(fact "Read data from cube.txt and put it in vector format"
      (cube "cube.txt") => test-cube)

(fact "Get right letter from cube vector"
      (letter-from-cube test-cube 0 0 0) => "a"
      (letter-from-cube test-cube 0 0 1) => "j"
      (letter-from-cube test-cube 3 2 1) => "p")

(fact "Change words from words.txt to vector format"
      (wordlist "words.txt") => vector?
      (word 0) => #"aakkonen")

(fact "get nth letter from word"
      (letter "derp" 0) => \d
      (letter "henrik" 4) => \i
      (letter "antti" 2) => \t)

(fact "Find distinct characters from cube"
      (distinct-letters test-cube) => ["a" "j" "f" "e"
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

;fact "show if all letters of a word exist in the distinct word list"
 ;     (all-letters-distinct?  distinct-word-list => true)

;(fact "create a new wordlist that has only words with distinct letters"
 ;     (words-with-distinct-letters ["apra" "kadabra" "alakazam"] => ["apra"]))

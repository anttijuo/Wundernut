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

(fact "does word consist of distinct letters only"
      (valid-word? "abra" ["a" "b" "r"]) => true
      (valid-word? "kadabra" ["k" "a" "z"]) => false
      (valid-word? "abra" ["a" "b" "d" "z" "r"]) => true
      (valid-word? "anu" ["a" "n" "z"]) => false)

(fact "generate a new wordlist that consists of words with only distinct-letters"
      (possible-words
        ["abra" "kadabra" "alakazam"] ["a" "b" "r"] ) => ["abra"])

(fact "does coordinate have an upper layer"
      (upper-layer? 0) => false
      (upper-layer? 1) => true
      (upper-layer? 2) => true
      (upper-layer? 3) => true)

(fact "does coordinate have a lower layer"
      (lower-layer? 0) => true
      (lower-layer? 1) => true
      (lower-layer? 2) => true
      (lower-layer? 3) => false)

(fact "calculate both upper and lower layer for coordinate"
      (layers 0) => "No Upper Layer"
      (layers 1) => "Both Layers"
      (layers 2) => "Both Layers"
      (layers 3) => "No Lower Layer")

(facts "check which quadrant of the square a character belongs to"
       (fact "check if the character belongs in the central quadrant"
             (central-quadrant? 1 1) => true
             (central-quadrant? 1 2) => true
             (central-quadrant? 2 1) => true
             (central-quadrant? 2 2) => true
             (central-quadrant? 2 3) => false
             (central-quadrant? 3 3) => false
             (central-quadrant? 0 0) => false)
       (fact "check if the character belongs in the left quadrant"
             (left-quadrant? 1 0) => true
             (left-quadrant? 2 0) => true
             (left-quadrant? 2 3) => false
             (left-quadrant? 3 2) => false)
       (fact "check if the character belongs in the right quadrant"
             (right-quadrant? 1 3) => true
             (right-quadrant? 2 3) => true
             (right-quadrant? 0 3) => false
             (right-quadrant? 0 0) => false)
       (fact "check if the character belongs in the top quadrant"
             (top-quadrant? 0 1) => true
             (top-quadrant? 0 2) => true
             (top-quadrant? 1 2) => false
             (top-quadrant? 3 3) => false)
       (fact "check if the character belongs in the top quadrant"
             (bottom-quadrant? 3 1) => true
             (bottom-quadrant? 3 2) => true
             (bottom-quadrant? 0 1) => false
             (bottom-quadrant? 2 1) => false)
       (fact "check if the character belongs in the top-left quadrant"
             (top-left-quadrant? 0 0) => true
             (top-left-quadrant? 2 3) => false
             (top-left-quadrant? 1 1) => false)
       (fact "check if the character belongs in the top-right quadrant"
             (top-right-quadrant? 0 3) => true
             (top-right-quadrant? 0 2) => false
             (top-right-quadrant? 3 3) => false)
       (fact "check if the character belongs in the bottom-left quadrant"
             (bottom-left-quadrant? 3 0) => true
             (bottom-left-quadrant? 1 1) => false
             (bottom-left-quadrant? 3 1) => false)
       (fact "check if the character belongs in the bottom-right quadrant"
             (bottom-right-quadrant? 3 3) => true
             (bottom-right-quadrant? 1 2) => false
             (bottom-right-quadrant? 2 3) => false))

(fact "determine which quadrant a letter belongs in"
      (quadrant 0 0) => "top-left"
      (quadrant 3 3) => "bottom-right"
      (quadrant 1 1) => "central"
      (quadrant 1 0) => "left"
      (quadrant 1 3) => "right"
      (quadrant 0 1) => "top"
      (quadrant 3 1) => "bottom"
      (quadrant 0 3) => "top-right"
      (quadrant 3 0) => "bottom-left")

(fact "computate adjacent coordinates based on current coordinates and quadrant"
      (adjacent-coordinates "central" 1 1) => [[0 0] [0 1] [0 2] [1 0] [1 2] [2 0] [2 1] [2 2]]
      (adjacent-coordinates "left" 1 0) => [[0 0] [0 1] [1 1] [2 0] [2 1]]
      (adjacent-coordinates "right" 1 3) => [[0 2] [0 3] [1 2] [2 2] [2 3]]
      (adjacent-coordinates "top" 0 1) => [[0 0] [0 2] [1 0] [1 1] [1 2]]
      (adjacent-coordinates "bottom" 3 1) => [[2 0] [2 1] [2 2] [3 0] [3 2]]
      (adjacent-coordinates "top-left" 0 0) => [[0 1] [1 0] [1 1]]
      (adjacent-coordinates "top-right" 0 3) => [[0 2] [1 2] [1 3]]
      (adjacent-coordinates "bottom-left" 3 0) => [[2 0] [2 1] [3 1]]
      (adjacent-coordinates "bottom-right" 3 3) => [[2 2] [2 3] [3 2]])

(fact "combine current coordinate with adjacent-coordinates"
      (layer-coordinates "central" 1 1) (contains [[0 0] [0 1] [0 2] [1 0] [1 1] [1 2] [2 0] [2 1] [2 2]])
      (layer-coordinates "left" 1 0) (contains [[0 0] [0 1] [1 0] [1 1] [2 0] [2 1]])
      (layer-coordinates "right" 1 3) (contains [[0 2] [0 3] [1 2] [1 3] [2 2] [2 3]])
      (layer-coordinates "top" 0 1) (contains [[0 0] [0 1] [0 2] [1 0] [1 1] [1 2]])
      (layer-coordinates "bottom" 3 1) (contains [[2 0] [2 1] [2 2] [3 0] [3 1] [3 2]])
      (layer-coordinates "top-left" 0 0) (contains [[0 0] [0 1] [1 0] [1 1]])
      (layer-coordinates "top-right" 0 3) (contains [[0 2] [0 3] [1 2] [1 3]])
      (layer-coordinates "bottom-left" 3 0) (contains [[2 0] [2 1] [3 0] [3 1]])
      (layer-coordinates "bottom-right" 3 3) (contains [[2 2] [2 3] [3 2] [3 3]]))

(fact "computate adjacent coordinates from all layers, if applicable"
      (all-coordinates "Both Layers" "central" 1 1) => {:current-layer [[0 0] [0 1] [0 2] [1 0] [1 2] [2 0] [2 1] [2 2]]
                                                        :upper-layer [[0 0] [0 1] [0 2] [1 0] [1 2] [2 0] [2 1] [2 2] [1 1]]
                                                        :lower-layer [[0 0] [0 1] [0 2] [1 0] [1 2] [2 0] [2 1] [2 2] [1 1]]}
      (all-coordinates "Both Layers" "left" 1 0) => {:current-layer [[0 0] [0 1] [1 1] [2 0] [2 1]]
                                                     :upper-layer [[0 0] [0 1] [1 1] [2 0] [2 1] [1 0]]
                                                     :lower-layer [[0 0] [0 1] [1 1] [2 0] [2 1] [1 0]]}
      (all-coordinates "No Upper Layer" "right" 1 3) => {:current-layer [[0 2] [0 3] [1 2] [2 2] [2 3]]
                                                         :lower-layer [[0 2] [0 3] [1 2] [2 2] [2 3] [1 3]]}
      (all-coordinates "No Lower Layer" "top" 0 1) => {:current-layer [[0 0] [0 2] [1 0] [1 1] [1 2]]
                                                        :upper-layer [[0 0] [0 2] [1 0] [1 1] [1 2] [0 1]]}
      (all-coordinates "Both Layers" "bottom" 3 1) => {:current-layer [[2 0] [2 1] [2 2] [3 0] [3 2]]
                                                       :upper-layer [[2 0] [2 1] [2 2] [3 0] [3 2] [3 1]]
                                                       :lower-layer [[2 0] [2 1] [2 2] [3 0] [3 2] [3 1]]}
      (all-coordinates "No Upper Layer" "top-left" 0 0) => {:current-layer [[0 1] [1 0] [1 1]]
                                                            :lower-layer [[0 1] [1 0] [1 1] [0 0]]}
      (all-coordinates "No Lower Layer" "top-right" 0 3) => {:current-layer [[0 2] [1 2] [1 3]]
                                                             :upper-layer [[0 2] [1 2] [1 3] [0 3]]}
      (all-coordinates "Both Layers" "bottom-left" 3 0) => {:current-layer [[2 0] [2 1] [3 1]]
                                                            :upper-layer [[2 0] [2 1] [3 1] [3 0]]
                                                            :lower-layer [[2 0] [2 1] [3 1] [3 0]]}
      (all-coordinates "No Upper Layer" "bottom-right" 3 3) => {:current-layer [[2 2] [2 3] [3 2]]
                                                                :lower-layer [[2 2] [2 3] [3 2] [3 3]]})

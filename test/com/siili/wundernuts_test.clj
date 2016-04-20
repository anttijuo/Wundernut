(ns com.siili.wundernuts-test
  (:require [com.siili.wundernuts :refer :all])
  (:use midje.sweet))


(fact "Namelist is empty"
      namelist => ())

(fact "Get right letter from cube vector"
      (letter-from-cube 0 0 0) => "A"
      (letter-from-cube 0 0 1) => "J"
      (letter-from-cube 3 2 1) => "P")

(fact "Read data from cube.txt and put it in Vector format"
    (cube-from-text "cube.txt") => cube)

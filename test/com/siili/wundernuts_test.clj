(ns com.siili.wundernuts-test
  (:require [com.siili.wundernuts :refer :all])
  (:use midje.sweet))


(fact "you could not find an empty namelist"
      namelist => ())

(fact "you could not find the first variable in the cube"
    (checkcube 0 0 0) => "A")

(fact "you incorrectly wrote data from cube.txt to the cube Vector"
    (checkcube 0 3 3) => "K")


(ns com.siili.wundernuts-test
  (:require [clojure.test :refer :all]
            [com.siili.wundernuts :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest try-to-test-a-variable
  (testing "you did not successfully test a variable"
    (is (= 0 number))))

(deftest try-to-test-a-function
  (testing "you did not successfully test a function"
    (is (= 0 (testfunction 2)))))

(deftest does-empty-namelist-exist
  (testing "you could not find an empty namelist"
    (is (= () namelist))))

;(deftest is-there-data-in-cube-list
 ; (testing "you could not find data in cube.txt file"
  ;  (is (= nil (readcube "cube.txt")))))

(deftest can-you-find-the-first-variable-in-the-cube
  (testing "you could not find the first variable in the cube"
    (is (= "A" (checkcube 0 0 0)))))

; can you write data from cube.txt to the cube vector?

(deftest can-you-write-data-from-cube-file-to-cube-vector
  (testing "you incorrectly wrote data from cube.txt to the cube Vector"
    (is (= "K" (checkcube 0 3 3)))))

;(deftest try-to-read-a-string-from-text-file
 ; (testing "you did not successfully read a string from a file"
  ;  (is (= "antti" (readstring "test-text-file.txt")))))

;(deftest read-word-from-file
 ; (testing "You we're unable to read a word from file correctly"
  ;  (is (= "antti" word))))

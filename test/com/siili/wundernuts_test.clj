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

(deftest try-to-read-a-string-from-text-file
  (testing "you did not successfully read a string from a file"
    (is (= "antti" (readstring "test-text-file.txt")))))

;(deftest read-word-from-file
 ; (testing "You we're unable to read a word from file correctly"
  ;  (is (= "antti" word))))

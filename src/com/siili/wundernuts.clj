(ns com.siili.wundernuts
  (:use [clojure.java.io]
        [clojure.string])
  (:gen-class))

(def cube [[["A" "J" "F" "E"]
            ["A" "P" "U" "W"]
            ["O" "G" "M" "R"]
            ["M" "N" "X" "K"]]
           [["D" "N" "S" "I"]
            ["F" "O" "D" "S"]
            ["J" "E" "G" "I"]
            ["W" "K" "P" "R"]]
           [["E" "Q" "M" "F"]
            ["R" "K" "I" "D"]
            ["D" "M" "I" "R"]
            ["E" "O" "S" "D"]]
           [["R" "T" "S" "L"]
            ["D" "K" "P" "I"]
            ["S" "P" "O" "I"]
            ["J" "Q" "D" "T"]]])

(defn letter-from-cube [layer row index]
  (get-in cube [layer row index]))

(def namelist (list))

(defn remove-newlines [text]
  (replace text #"\n" ""))

(defn cubeify [letters]
  (partition 4 (partition 4 letters)))

(defn split-string>vector [letters splitter]
  (split letters splitter))

(defn cube-from-text [filename]
  (let [letters (remove-newlines (slurp filename))]
    (cubeify (split-string>vector letters #""))))

(defn wordlist [filename]
  (split-string>vector (slurp filename) #"\n"))

(defn word [index]
  (get (wordlist "words.txt") index))

(defn -main
  [& args]
  (println "Hello, World!"))

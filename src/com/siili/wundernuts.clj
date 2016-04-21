(ns com.siili.wundernuts
  (:use [clojure.java.io]
        [clojure.string])
  (:gen-class))

(def cube [[["a" "j" "f" "e"]
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
    (cubeify (split-string>vector (lower-case letters) #""))))

(defn wordlist [filename]
  (split-string>vector (slurp filename) #"\n"))

(defn word [index]
  (get (wordlist "words.txt") index))

(defn letter [word index]
  (get word index))

(defn distinct-letters []
  (distinct (flatten cube)))

(defn distinct-letter [index]
  (get (distinct-letters) index))

(defn letter-found? [word letter]
  (.contains word letter))

(defn letter-index [word letter]
  (.indexOf word letter))

;(defn words-with-distinct-letters [words]
 ; (filter (fn [word] (contains? word ) words )

(defn -main
  [& args]
  (println "Hello, World!"))

(ns com.siili.wundernuts
  (:use [clojure.java.io]
        [clojure.string])
  (:gen-class))

(defn letter-from-cube [cube layer row column]
  (get-in cube [layer row column]))

(def namelist (list))

(defn remove-newlines [text]
  (replace text #"\n" ""))

(defn cubeify [letters]
  (partition 4 (partition 4 letters)))

(defn split-string>vector [letters splitter]
  (split letters splitter))

(defn cube [filename]
  (let [letters (remove-newlines (slurp filename))]
    (cubeify (split-string>vector (lower-case letters) #""))))

(defn wordlist [filename]
  (split-string>vector (slurp filename) #"\n"))

(defn word [index]
  (get (wordlist "words.txt") index))

(defn letter [word index]
  (get word index))

(defn distinct-letters [cube]
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
  (let [cube (cube "cube.txt")
        wordlist (wordlist "words.txt")
        distinct-letters (distinct-letters cube)]
    (prn cube)
    (prn distinct-letters))
  )

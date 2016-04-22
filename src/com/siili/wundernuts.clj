(ns com.siili.wundernuts
  (:use [clojure.java.io]
        [clojure.string])
  (:gen-class))

(defn letter-from-cube [cube layer row column]
  (get-in cube [layer row column]))

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

(defn valid-letters [word distinct-letters]
  (map
    #(.contains distinct-letters (str %))
    word))

(defn valid-word? [word distinct-letters]
  (every? true? (valid-letters word distinct-letters)))

(defn possible-words [words distinct-letters]
  (filter
    #(valid-word? % distinct-letters)
    words))

(defn upper-layer? [layer]
  (< 0 layer))

#_(defn adjacent-letters [layer row column]
  )

(defn -main
  [& args]
  (let [cube (cube "cube.txt")
        words (wordlist "words.txt")
        distinct-letters (distinct-letters cube)
        possible-words (possible-words words distinct-letters)]
    (prn cube)
    (prn distinct-letters)
    #_(prn possible-words)))

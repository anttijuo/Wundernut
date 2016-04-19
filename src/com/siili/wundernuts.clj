(ns com.siili.wundernuts
  (:gen-class))

(use 'clojure.java.io)
(use 'clojure.string)


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


(def test-list [[["A" "B"]["C" "D"]][["E" "F"]["G" "H"]][["I" "J"]["K" "L"]]])

(defn letter-from-cube [layer row index]
  (get-in test-list [layer row index]))

(def namelist (list))

(defn cube-from-text [filename]
  (let [all-letters (partition 4 (replace (slurp filename) #"\n" ""))]
    all-letters))

(defn -main
  [& args]
  (println "Hello, World!"))

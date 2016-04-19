(ns com.siili.wundernuts
  (:gen-class))

(use 'clojure.java.io) ;this enables us to use input/output commands



(def test-list [[["A" "B"]["C" "D"]][["E" "F"]["G" "H"]][["I" "J"]["K" "L"]]])

(defn checkcube [layer row index] ; inspect a specific index in the cube
  (get-in test-list [layer row index]))

(def namelist (list)) ; create empty list to which names will be added

(defn readstring [filename]
  (with-open [rdr (reader filename)] ;this enables us to open a .txt file
  (doseq [line (line-seq rdr)] ;line-seq returns text from rdr as a lazy sequence
                               ;doseq repeats process
    (println line)
    ;add functionality that adds read words into List
    ())))

(defn readcubefile [filename]  ; read data on cube from file, then create a vector
  (with-open [rdr (reader filename)]
    (doseq [line (line-seq rdr)]
      (println line))))

;(defn readstring [filename]
 ; (slurp filename))         ; read all content from file and print it, including newline

;FIX: Read data until newline, then stop

;(readstring "test-text-file.txt")

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(ns com.siili.wundernuts
  (:gen-class))

(use 'clojure.java.io) ;this enables us to use input/output commands

(def number 0)

(defn testfunction [x] (- x 2))

;(defn readstring [x]
 ; (with-open [rdr (reader "test-text-file.rtf")] ;this enables us to open a .rtf file
  ;(doseq [line (line-seq rdr)] ;line-seq returns text from rdr as a lazy sequence
                               ;doseq repeats process
   ; (println line))))

(defn readstring [filename]
  (slurp filename))         ; read all content from file and print it, including newline

;FIX: Read data until newline, then stop

;(readstring "test-text-file.txt")

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

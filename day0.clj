;;; DAY 1 2022 - to prepare for 2023
(ns day0)
(require '[aocd.core :as data]
         '[clojure.string :as str])


(defn part1 [input]
  (->>
   (str/split input #"\n\n")
   (map str/split-lines)
   (map (partial map parse-long))
   (map (partial reduce +))
   (apply max)))

(defn part2 [input]
  (->>
   (str/split input #"\n\n")
   (map str/split-lines)
   (map (partial map parse-long))
   (map (partial reduce +))
   (sort #(compare %2 %1))
   (take 3)
   (reduce +)))

(def example "1000
2000
3000

4000

5000
6000

7000
8000
9000

10000")

(part1 example)
;; => 24000
(part1 (data/input 2022 1))
;; => 69177

(part2 example)
;; => 45000
(part2 (data/input 2022 1))
;; => 207456

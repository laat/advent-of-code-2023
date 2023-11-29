;;; DAY 1 2022 - to prepare for 2023
(ns day0
  (:require
   [aocd.core :as data]
   [clojure.string :as str]))

(def input (data/input 2022 1))
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

;; part1
(->> input
     (#(str/split % #"\n\n"))
     (map str/split-lines)
     (map (partial map parse-long))
     (map (partial reduce +))
     (apply max))
;; => 69177
;; => 24000

;; part2
(->> input
     (#(str/split % #"\n\n"))
     (map str/split-lines)
     (map (partial map parse-long))
     (map (partial reduce +))
     (sort #(compare %2 %1))
     (take 3)
     (reduce +))
;; => 207456
;; => 45000

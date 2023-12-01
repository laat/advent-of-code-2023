(ns day1
  (:require
   [aocd.core :as data]
   [clojure.string :as str]))

(def input (data/input 2023 1))

;; part1
(->> input
     str/split-lines
     (map (partial re-seq #"\d"))
     (map (partial map parse-long))
     (map #(+ (* (first %) 10) (last %)))
     (reduce +))


;; part2
(def numbers {"one" 1 "two" 2 "three" 3 "four" 4 "five" 5
              "six" 6 "seven" 7 "eight" 8 "nine" 9
              "1" 1 "2" 2 "3" 3 "4" 4 "5" 5 "6" 6 "7" 7 "8" 8 "9" 9})
(->> input
     str/split-lines
     (map (partial re-seq #"(?=(one|two|three|four|five|six|seven|eight|nine|[0-9]))"))
     (map (partial map second))
     (map (partial map numbers))
     (map #(+ (* (first %) 10) (last %)))
     (reduce +))

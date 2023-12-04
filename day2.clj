(ns day2
  (:require
   [aocd.core :as data]
   [clojure.string :as str]))

(def input (data/input 2023 2))

(defn parse-cubes [cubes]
  (->> (re-seq #"(\d+) (\w+)" cubes)
       (map (fn [[_ v k]] [(keyword k) (parse-long v)]))
       (into {})))

(defn parse-line [index line]
  (->> (str/split (second (str/split line #": ")) #"; ")
       (mapv parse-cubes)
       (assoc {:game (+ index 1)} :bags)))

(defn is-possible? [bag]
  (and (<= (get bag :red 0) 12)
       (<= (get bag :green 0) 13)
       (<= (get bag :blue 0) 14)))

;; part1
(->> input
     str/split-lines
     (map-indexed parse-line)
     (filter #(every? is-possible? (:bags %)))
     (map :game)
     (reduce +))

;; part2
(->> input
     str/split-lines
     (map-indexed parse-line)
     (map :bags)
     (map (partial apply merge-with max))
     (map (partial reduce (fn [prod [_ v]] (* prod v)) 1))
     (reduce +))

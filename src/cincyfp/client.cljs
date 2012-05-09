(ns cincyfp.client
  (:require [enfocus.core :as ef]
            [goog.Timer :as timer]
            [goog.date.DateTime :as dt])
  (:require-macros [enfocus.macros :as em]))

(defn by-id [id] (.getElementById js/document id)) 

;; given the hours minutes and seconds
;; generate the number of lights that are on in a berlin clock,
;; for each of the 5 rows
(defn make-counts [hours minutes seconds]
  [(- 1 (mod seconds 2))
   (Math/floor (/ hours 5))
   (mod hours 5)
   (Math/floor (/ minutes 5))
   (mod minutes 5)])


;; return a sequence of "on" for active lights
;; and "" for inactive given active and total
(defn make-line [active total]
   (concat (repeat active "on") (repeat (- total active) "")))


;; given the counts for the 5 lines in a berlin clock
;; return each seq of rows
(defn make-lines [counts]
  (map make-line counts '(1 4 4 11 4)))
    

;; updates the display for the berlin clock by changing
;; class of the active and inactive lights
(defn update-display [lines]
  (dorun (map-indexed
          (fn [i r]
            (dorun (map-indexed
                    (fn [k c]
                      (set! (.-className (by-id (str "id" i "-"  k))) c))
                    r)))
          lines)))
                                          
;; gets the current time and updates
;; the berlin clock
(defn update-clock []
  (let [time (goog.date.DateTime.)
        counts (make-counts (.getHours time) (.getMinutes time) (.getSeconds time))
        lines (make-lines counts)]
    (update-display lines)))
    

;; initalizes the timer
(defn init []
  (let [timer (goog.Timer. 1000)]
    (.addEventListener timer timer/TICK update-clock)
    (.start timer))) 


;; sets the onload event
(set! (.-onload js/window) init)


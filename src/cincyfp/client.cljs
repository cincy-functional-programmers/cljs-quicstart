(ns cincyfp.client
  (:require [enfocus.core :as ef]
            [clojure.browser.repl :as repl]
            [fetch.remotes :as rm])
  (:require-macros [enfocus.macros :as em]
                   [fetch.macros :as fm]))

;TODO 
(defn init [] )

(set! (.-onload js/window)
      #(do
         (repl/connect "http://localhost:9000/repl")
         (init)))

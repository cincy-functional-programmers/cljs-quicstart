(ns cincyfp.core
  (:use [noir.core :only [defpage]]
        [noir.response :only [redirect]]
        [noir.fetch.remotes :only [defremote]])
  (:require [noir.server :as server]))



;;;;;;;;;;;;;;;;;;; initialize server ;;;;;;;;;;;;;;;;;;;;;;;;
(defpage "/" [] (redirect "/index.html"))


(defn -main [& args]
  (server/start 10000 {:mode :dev :ns 'cincyfp }))

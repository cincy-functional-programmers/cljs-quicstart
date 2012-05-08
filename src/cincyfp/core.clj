(ns cincyfp.core
  (:use [noir.core :only [defpage]]
        [noir.response :only [redirect]]
        [monger.core :only [connect! set-db! get-db]]
        [monger.collection :only [insert find-maps find-one find-one-as-map update]]
        [noir.fetch.remotes :only [defremote]])
  (:require [noir.server :as server]))

;;;;;;;;;;;;;;; initialize monodb connection ;;;;;;;;;;;;;;;;;;;;;
(connect!)
(set-db! (get-db "fixme"))    


;TODO


;;;;;;;;;;;;;;;;;;; initialize server ;;;;;;;;;;;;;;;;;;;;;;;;
(defpage "/" [] (redirect "/index.html"))


(defn -main [& args]
  (server/start 10012 {:mode :dev :ns 'cinjug1 }))

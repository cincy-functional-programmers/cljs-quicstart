(defproject cincyfp "1.0.0-SNAPSHOT"
  :description "CincyFP Quickstart"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [noir "1.2.0"]
                 [fetch "0.1.0-alpha2"]
                 [enfocus "0.9.1-SNAPSHOT"]
                 [com.novemberain/monger "1.0.0-beta4"]]
  :main cincyfp.core
  :cljsbuild {
       :repl-listen-port 9002
       :builds [{
         :source-path "src"
         :compiler {:output-to "resources/public/js/main.js"}}]})

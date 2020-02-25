(ns backend.main
  (:gen-class)
  (:require [backend.server :as server]))

(defn -main
  [& args]
  (server/run-server))

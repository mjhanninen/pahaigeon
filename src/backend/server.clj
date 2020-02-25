(ns backend.server
  (:require [ring.adapter.jetty :as jetty]))

(defn run-server
  []
  (jetty/run-jetty (fn [_]
                     {:status 200
                      :body "<html><body><h1>Pahaigeon"})
                   {:port 3000}))

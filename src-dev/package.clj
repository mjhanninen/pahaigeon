(ns package
  (:require [badigeon.bundle :as b]
            [badigeon.clean :refer [clean]]
            [badigeon.compile :as c]
            [clojure.java.io :as io]))

(defn stamp
  [label]
  (doto (->> label (str "target/stamps/") io/as-file)
    io/make-parents
    (spit "")))

(defn do-bundle
  []
  (clean "target/bundle")
  (b/bundle (b/make-out-path 'bundle nil))
  (stamp "bundle"))

(defn do-compile
  []
  (clean "target/classes")
  (c/compile ['backend.main])
  (stamp "compile"))

(defn -main
  [& args]
  (if-let [tasks (-> args set not-empty)]
    (do
      (when (tasks "bundle")
        (do-bundle))
      (when (tasks "compile")
        (do-compile)))
    (do
      (do-bundle)
      (do-compile))))

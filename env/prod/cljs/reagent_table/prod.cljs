(ns reagent-table.prod
  (:require [reagent-table.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)

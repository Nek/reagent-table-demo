(ns ^:figwheel-no-load reagent-table.dev
  (:require [reagent-table.core :as core]
            [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)

(ns reagent-table.core
  (:require [reagent.core :as r]))

(defonce counter (r/atom 0))

(defn next-id [] (swap! counter inc) @counter)

(defonce state
         (r/atom (sorted-map (next-id) "one" (next-id) "two" (next-id) "three")))

(defn update-row [id v] (swap! state assoc id v))

(defn add-row [] (let [id (next-id)] (swap! state assoc id (str "new row " id))))

(defn remove-row [id] (swap! state dissoc id))

(defn row
  [id v]
  [:tr
   [:td
    [:input
     {:type "text"
      :value v
      :on-change #(update-row id
                              (-> %
                                  .-target
                                  .-value))}]
    [:button {:on-click #(remove-row id)} "-"]]])

(defn home-page
  []
  [:div
   [:h2 "Welcome to Reagent"]
   [:table>tbody (for [[id v] @state] ^{:key id} [row id v])]
   [:button {:on-click add-row} "+"]])

(defn mount-root [] (r/render [home-page] (.getElementById js/document "app")))

(defn init! [] (mount-root))

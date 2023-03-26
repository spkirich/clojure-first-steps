; Определитель матрицы с помощью метода Гаусса

(defn transpose [matrix]
  (apply mapv vector matrix))

(defn swap-zero-column [data n]
  (let [sign (first data) rows (second data)]
    (cond (not (zero? (get-in rows [n n]))) data
          :else (list (* -1 sign)
                      (let [columns (transpose rows)]
                        (loop [i (- (count columns) 1)]
                          (cond (zero? (get-in columns [i (inc n)])) (recur (inc i))
                                :else (transpose (assoc-in (assoc-in columns
                                                                     [n]
                                                                     (nth columns i))
                                                           [i]
                                                           (nth columns n))))))))))

(defn pivot [rows n]
  (vec (concat (subvec rows 0 (+ 1 n))
               (map #(let [qoutient (/ (get-in rows [% n])
                                       (get-in rows [n n]))]
                       (mapv -
                             (nth rows %)
                             (map (partial * qoutient) (nth rows n))))
                    (range (+ 1 n) (count rows))))))


(defn triangular [matrix]
  (let [data (list 1 matrix)]
    (reduce (fn [d n]
              (let [swapped (swap-zero-column d n)]
                (list (first swapped) (pivot (second swapped) n))))
            data
            (range (- (count (first (second data))) 1)))))

(defn determinant [matrix]
  (let [m (triangular matrix)]
    (* (first m) (reduce (fn [result n]
                           (* result (get-in (second m) [n n])))
                         (cons 1 (range (count (first (second m)))))))))

; Определитель матрицы с помощью миноров

(defn remove-string [strings current-string & {:keys [res] :or {res []}}]
  (cond (empty? strings) res
        :else (remove-string (rest strings)
                             current-string
                             :res (concat res (cond (identical? current-string (first strings)) nil
                                                    :else (cons (rest (first strings)) nil))))))

(defn determinant-internal [det matrix & {:keys [answer, current-string] :or {answer (list 0 1) current-string matrix}}]
  (cond (empty? current-string) answer
        :else (determinant-internal det matrix
                                    :answer (list (+ (* (ffirst current-string)
                                                        (det (remove-string matrix (first current-string)))
                                                        (second answer))
                                                     (first answer))
                                                  (* -1 (second answer)))
                                    :current-string (rest current-string))))

(defn determinant [matrix]
  (cond (empty? (rest matrix)) (ffirst matrix)
        :else (first (determinant-internal determinant matrix))))

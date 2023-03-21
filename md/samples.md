# :notebook: Примеры

Настало время сделать последний шаг &mdash; изучить примеры функций на Clojure!

## Обращение списка

``` clojure
(defn my-reverse-helper [acc lst]
  (if (empty? lst) acc
    (my-reverse-helper (cons (first lst) acc) (rest lst))))

(defn my-reverse [lst]
  (my-reverse-helper nil lst))
```

## Поиск первого непустого списка

``` clojure
(defn first-not-empty [lst]
  (if (empty? lst) nil
    (if (and (list? (first lst)) (not (empty? (first lst)))) (first lst)
      (first-not-empty (rest lst)))))
```

## Умножение всех чисел в списке на данное

``` clojure
(defn mul-num [mul lst]
  (if (empty? lst) nil
    (conj (mul-num mul (rest lst))
      (if (number? (first lst)) (* mul (first lst))
        (first lst)))))
```

## Выбор всех чисел в данном интервале

``` clojure
(defn select-between [a b lst]
  (if (empty? lst) nil
    (if (< (min a b) (first lst) (max a b))
      (conj (select-between a b (rest lst)) (first lst))
      (select-between a b (rest-lst)))))
```

## Сумма всех чисел в многоуровневом списке

``` clojure
(defn rec-sum [lst]
  (if (empty? lst) 0
    (if (list? (first lst)) (+ (rec-sum (first lst)) (rec-sum (rest lst)))
      (+ (first lst) (rec-sum (rest lst))))))
```

[Предыдущий шаг](java_integration.md)

[Следующий шаг](use_cases.md)

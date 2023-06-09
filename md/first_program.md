# :page_facing_up: Первая программа

Настало время сделать следующий шаг &mdash; написать первую программу на Clojure!

## Программа

В файле `leap.clj` определим функцию `leap?`:

``` clojure
(defn leap? [y]
  (cond
    (= (mod y 400) 0) true
    (= (mod y 100) 0) false
    (= (mod y 4) 0) true
    :else false))
```

Добавим вывод приглашения ко вводу:

``` clojure
(println "Введите год:")
```

И, наконец, добавим вывод результата:

``` clojure
(let [y (Integer/parseInt (read-line))]
  (println
    (if (leap? y)
      "Високосный!"
      "Не високосный.")))
```

## Запуск

Запустим нашу программу следующей командой:

``` bash
clojure -M leap.clj
```

Проверим правильность её работы:

```
Введите год:
1900
Не високосный.
```

[Предыдущий шаг](environment.md)

[Следующий шаг](syntax_explain.md)

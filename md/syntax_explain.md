# :mortar_board: Понимание синтаксиса

В Clojure имя функции и её аргументы находятся внутри скобок, например
```clojure
(count foo) ;; Clojure
```
, что эквивалентно
```php
count($foo) // PHP
```

Теперь посмотрим на более сложный код:

![Syntax 1](/img/syntax_1.png)

С первого взгляда ничего не понятно! Но тут есть небольшой трюк: представьте xml-подобный язык шаблонизатора, в котором есть теги if, for или тег присваивающий значение переменной:

![Syntax 2](/img/syntax_2.png)

Теперь заменим угловые скобки на круглые скобки:

![Syntax 3](/img/syntax_3.png)

Немного упростим, убрав имена атрибутов, лишние кавычки и некоторые теги:

![Syntax 4](/img/syntax_4.png)

И в итоге получаем Clojure! (на самом деле, это ещё не Clojure, но уже очень близко):

![Syntax 5](/img/syntax_5.png)

Немного попрактиковавшись, вы обнаружите, что такой синтаксис даже удобнее, чем старый-добрый классический Си-подобный. Синтаксис Clojure компактный, выразительный и достаточно легко читаемый.

Единственное, что может смущать, это количество закрывающих скобок в конце, которые принято располагать на одной строке:

![Syntax 6](/img/syntax_6.png)

Однако, в реальной жизни это не проблема, т.к. все современные редакторы и IDE умеют подсвечивать парные скобки.

[Предыдущий шаг](first_program.md)

[Следующий шаг](java_integration.md)

# :blue_book: React

**Все примеры описанные ниже можно найти в папке examples.**

Как можно было уже заметить ClojureScript могут использовать библиотеки, написанные на JavaScript.

Одной из самых популярных библиотек в области веб-технологий, написанных на JavaScript, является **React**.

Если ещё не знакомы с React'ом и хотите попробовать себя в веб-разработке, то можете почитать про React [на официальном сайте](https://react.dev/).

Попробуем написать свою первую программу на React.

## Quick Start with React

### Установка зависимостей

#### Ubuntu 

Для начала стоит установить [Leiningen](https://leiningen.org/), это утилита, упрощающая использование Clojure, а именно импорт пакетов.

Для его установки необходимо ввести:
```bash
sudo apt install leiningen
```

Мы будем использовать Reagent, он предоставляет минималистичный интерфейс взаимодействия между ClojureScript и React. Данный пакет позволяет разработчику определять функциональные React-компоненты, используя ничего кроме ClojureScript-функций.

Сам [Reagent](https://reagent-project.github.io/) скачивать не нужно, он предоставляется при скачивании Leiningen.

Давайте инициализируем проект Reagent с именем `first-react`:
```bash
lein new reagent first-react
```

В файле `project.clj` указаны зависимости данного проекта и его описание. Можно сказать, данный файл является аналогом `package.json`, который очень знаком JavaScript-разработчикам, хотя и сам `package.json` имеется в проекте. Все доступные пакеты в ClojureScript можно поискать [здесь](http://cljsjs.github.io/).

Перейдём в директорию проекта:
```bash
cd first-react
```

Перед запуском необходимо установить JS-зависимости с помощью команды:
```bash
npm install
```

Для запуска проекта понадобится пакет shadow-cljs:
```bash
sudo npm i -g shadow-cljs
```

Для самого запуска проекта необходимо написать:
```bash
shadow-cljs watch app
```

shadow-cljs обнаружит файл `project.clj` и установит зависимости проекта. После чего запустит приложение на порте 3000.

### Структура проекта

```bash
first-react
├── env
│   ├── dev
│   │   ├── clj
│   │   │   ├── first_react
│   │   │   │   ├── middleware.clj
│   │   │   │   └── repl.clj
│   │   │   └── user.clj
│   │   └── cljs
│   │       └── first_react
│   │           └── dev.cljs
│   └── prod
│       ├── clj
│       │   └── first_react
│       │       └── middleware.clj
│       └── cljs
│           └── first_react
│               └── prod.cljs
├── package.json
├── package-lock.json
├── Procfile
├── project.clj
├── README.md
├── shadow-cljs.edn
├── src
│   ├── clj
│   │   └── first_react
│   │       ├── handler.clj
│   │       └── server.clj
│   ├── cljc
│   │   └── first_react
│   │       └── util.cljc
│   └── cljs
│       └── first_react
│           └── core.cljs
└── system.properties
```

### Компоненты

Компоненты в Reagent определяются при помощи [Hiccup-синтаксиса](https://github.com/weavejester/hiccup):

```clojure
[:<html-el>
  [:<html-el>]
  [:<html-el>]
  ...
  [:<html-el>]
]
```
, где `html-el` является html-элементом, то есть `button`, `span`, `div` и так далее. Атрибуты элемента передаются при помощи фигурных скобок {}:

```clojure
[:button 
  {:on-click (fn [] (js/console.log 123))} "some-title"
]
```

В примере выше будет создана кнопка с названием `"some-title"`, которая при нажатии будет выводить в консоль браузера `"123"`.

### Состояние

Ниже предоставлен компонент и атом `click-count`, которая связывается с значением 0. Данный атом играет роль счётчика кликов на кнопку. У компонента
`:button` можно установить слушатель события нажатия с помощью `:on-click <callback>`. В качестве коллбека используется функция swap!, которая изменяет состояние атома click-count на 2. 

```clojure
(def click-count (atom 0))

(defn current-page []
  (fn []
    (let [page (:current-page (session/get :route))]
      [:div
        [:button {:on-click #(swap! click-count (fn [v] (+ v 2)))} "You clicked " @click-count " times"]])))
```

Также ради избежания использования глобальных переменных, можно определить
атом внутри компонента `currrent-page` следующим образом:

```clojure
(defn current-page []
  (let [click-count (atom 0)]
  (fn []
    (let [page (:current-page (session/get :route))]
      [:div
        [:button {:on-click #(swap! click-count (fn [v] (+ v 2)))} "You clicked " @click-count " times"]]))))
```

Поздравляем, вы написали свой первый "счётчик", который чаще всего является первым приложением у frontend-разработчиков.

[Предыдущий шаг](./web_intro.md)
[Следующий шаг](./comparing_with_js.md)


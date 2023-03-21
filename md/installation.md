# :gear: Установка

Настало время сделать первый шаг &mdash; установить Clojure!
Мы рассмотрим несколько способов для операционных систем NixOS и Ubuntu.

## NixOS

Попробовать Clojure без полноценной установки можно с помощью интерактивной оболочки:

``` bash
nix-shell -p clojure
```

Для установки на уровне системы нужно изменить содержимое файла `/etc/nixos/configuration.nix`:

``` nix
{
  environment.systemPackages = with pkgs; [
    clojure
  ];
}
```

Чтобы изменения вступили в силу, систему надо пнуть:

``` bash
sudo nixos-rebuild switch
```

Установить Clojure на уровне пользователя можно с помощью Home Manager.
Для этого нужно изменить содержимое файла `~/.config/nixpkgs/home.nix`:

``` nix
{
  home.packages = with pkgs; [
    clojure
  ];
}
```

Чтобы изменения вступили в силу, надо пнуть Home Manager:

``` bash
home-manager switch
```

## Ubuntu

Для установки Clojure на уровне системы можно использовать APT:

``` bash
sudo apt update
sudo apt install clojure
```

А ещё можно заморочиться с установочным скриптом.
Для этого сначала необходимо установить зависимости:

``` bash
sudo apt update
sudo apt install bash curl default-jdk rlwrap
```

Затем скачать сам скрипт:

``` bash
curl -O https://download.clojure.org/install/linux-install-1.11.1.1252.sh
```

Настроить права доступа к нему:

``` bash
chmod +x linux-install-1.11.1.1252.sh
```

И, наконец, выполнить его:

``` bash
sudo ./linux-install-1.11.1.1252.sh
```

[Предыдущий шаг](motivation.md)

[Следующий шаг](environment.md)


# Шаг 1

Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослами, а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).

##  Создадим 2 файла и наполним их

```
cat > Domestic_Animals <<EOF
dogs
cats
hamsters
EOF

cat > Draught_Animals <<EOF
horses
camels
donkeys
EOF
```

Алтернативно, можно использовать другие команды

Пример использования команды `echo`:

```
echo "dogs
cats
hamsters" > Domestic_Animals

echo "horses
camels
donkeys" > Draught_Animals
```

Пример использования команд `touch` и `echo`:

```
touch Domestic_Animals Draught_Animals
echo "dogs\ncats\nhamsters" > Domestic_Animals
echo "horses\ncamels\ndonkeys" > Draught_Animals
```

## Объединим полученные файлы в один

```
cat Domestic_Animals Draught_Animals > all_animals
```

## Просмотрим содержимое получившегося файла

```
cat all_animals
```

Вывод:
```
dogs
cats
hamsters
horses
camels
donkeys
```

## Переименуем получившийся файл

```
mv all_animals Humans_Friends
```


# Шаг 2

Создать директорию, переместить файл туда.

```
mkdir Animal_Shelter
mv Humans_Friends Animal_Shelter
```

# Шаг 3

Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

```
sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb
sudo dpkg -i mysql-apt-config_0.8.23-1_all.deb
sudo apt update
sudo apt install mysql-server
```

# Шаг 4
Установить и удалить deb-пакет с помощью dpkg.

```
sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb
sudo dpkg -i docker-ce-cli_20.10.133-0ubuntu-jammy_amd64.deb
sudo dpkg -r docker-ce-cli
```

# Шаг 5

Выложить историю команд в терминале ubuntu.

```
history
```

Вывод:
```
 1011  echo "dogs\ncats\nhamsters" > Domestic_Animals
 1012  cat > Domestic_Animals <<EOF\ndogs\ncats\nhamsters\nEOF
 1013  cat Domestic_Animals Draught_Animals > all_animals
 1014  cat all_animals
 1015  mv all_animals Humans_Friends
 1016  mkdir Animal_Shelter
 1017  mv Humans_Friends Animal_Shelter
 1018  sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb
 1019  sudo dpkg -i mysql-apt-config_0.8.23-1_all.deb
 1020  sudo apt update
 1021  sudo apt install mysql-server
 1022  sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb   

 1023  sudo dpkg -i docker-ce-cli_20.10.133-0ubuntu-jammy_amd64.deb
 1024  sudo dpkg -r docker-ce-cli 
```



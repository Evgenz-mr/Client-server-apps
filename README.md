# Клиент серверное приложение Java

### **Приложение "Сервер" использует:**

* IP (пример 10.20.30.100)
* Port (необходимо использовать любой свободный порт в системе, пример 5000)
* Сервер хранит логи согласно заданным настройкам в конфигурационном файле **"/main/resources/log4j.properties"**. 
* Путь по умолчанию указан "D:\\tasks\\log_file.log". 
* Необходимо указать свой путь(существующий в системе) куда сервер будет записывать логи.

### **Приложение "Клиент" использует:**

* IP адрес сервера к которому будет подключаться клиент (**пример 10.20.30.100**)
* Port (необходимо указать порт по которому доступно приложение "Сервер", **пример 5000**)
* Необходимо пройти авторизацию пользователя(логин и пароль хранится в конфигурационном файле формата .ini)


#### **Запуск приложений**

* Перед запуском необходимо записать данные(IP адресс сервера, Port сервера, username, password) в конфигурационный файл .ini
* Так же для перед запуском в IJ может потребоваться подключить библиотеку log4j:log4j:1.2.17 для приложения "Сервер".

**Первым приложением мы запускаем "Сервер"**, после успешного старта можно убедиться в командной строке ("netstat -aon | more") 
что приложение, на порту который мы указали в конфигурационном файле, запущенно и использует указанный порт.

* После успешного запуска сервера - сообщение от сервера ("Server started"),
запускаем приложение "Клиент" и проходим авторизацию.

* **Для завершения работы клиента необходимо написать в терминале "quit"**

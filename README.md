# SSP
WebApp similar to TodoMVC (http://todomvc.com)

Deployment

1. Установка Java. Версия JDK 1.8.0, версия JRE 1.8.0 (ссылка для загрузки: http://www.oracle.com/technetwork/java/javase/downloads/index.html). Используемая среда разработки: IDE Eclipse Oxygen (ссылка для загрузки: https://www.eclipse.org/downloads/eclipse-packages/). Также требуется дополнительная установка платформы Java EE и плагинов для web-приложения: Maven, Hibernate (в Eclipse доступно через Help->Install New Software или Help->Eclipse Marketplace).
2. Установка Apache Tomcat 7 (ссылка для загрузки: http://tomcat.apache.org/download-70.cgi). Для установки Tomcat на машине требуется распаковать архив в каталоге и установить переменные JAVA_HOME=<путь к JDK>, JRE_HOME=<путь к JRE>, CATALINA_HOME=<путь к распакованному Apache Tomcat>. Запустить сервер с помощью startup.bat, находящегося в apache-tomcat/bin. Проверить работу сервера можно в браузере, введя URL http://localhost:8080/.
3. Создание БД. Установка MySQL (ссылка для загрузки: https://dev.mysql.com/downloads/windows/installer/5.7.html). Настройка базы данных: установка логина и пароля администратора; создание и заполнение таблиц.Для работы с этими таблицами (с помощью Hibernate) требуется подключение к БД, которое настраивается в hibernate.cfg.xml и hibernate.reveng.xml. С этой помощью таблицы с БД выгружаются в IDE в виде сгенерированных классов.
4. Запуск приложения в Tomcat. Сначала требуется добавить сервер Tomcat в IDE (Window->Show View->Servers). Затем в свойствах проекта во вкладке Targeted Runtimes установить добавленный сервер Apache Tomcat. В списке серверов правой кнопкой мыши нажать на Apache Tomcat и в контекстном меню выбрать Add and Remove. Добавить проект в правый столбец со списком сконфигурированных проектов. Зупаустить проект на сервере. Также запуск проекта возможен из браузера, если ввести в строке http://localhost:8080/<название проекта>.
5. Приложение собрано с помощью Maven, все необходимые для работы приложения библиотеки добавлены в скрипт сборки.

Тестовое задание не выполнено до конца (нет основной части приложения с отображением данных), но были попытки собрать все технологии вместе.

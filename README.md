# README #

Для запуска теста необходимо иметь IntelliJ + jdk, gecko driver (при использовании selenium web driver ver. > 3.0).

1. Открыть проект в IntelliJ. 
<!-- 1. Для того, чтобы добавить .jar файлы Selenium'a в IntelliJ в качестве внешних библиотек:
	* Скачать http://selenium-release.storage.googleapis.com/3.4/selenium-java-3.4.0.zip и
	разархивировать в любое место.

	* Кликнуть File -> Project Structure -> в настройках проекта перейти на вкладку Modules -> Dependencies -> кликнуть на '+' Sign -> выберите JAR файлы. -->


2. Для того, чтобы установить Gecko driver:

	* Скачать нужную версию (https://github.com/mozilla/geckodriver/releases), разархивировать в test/resources/gecko.  
	* Добавить путь к Gecko driver в test/resources/gecko, в коде указать абсолютный путь до драйвера в переменной PATH_TO_GECKODRIVER.
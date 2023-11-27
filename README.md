# Test task Selenium
### Запуск тестов
Перед запуском указать путь к exe файлу WebDriver хрома вашей версии в src/test/resources/properties.yml.
Скачать вебдрайверы хрома версий 114 и ниже - https://chromedriver.chromium.org/downloads
Скачать вебдрайверы хрома версий 115 и выше - https://googlechromelabs.github.io/chrome-for-testing/
Запуск тестов с помощью команды maven - mvn clean test
### Генерация allure отчета
maven - mvn allure:serve

# Aplikacja Bot API

Aplikacja ma na celu śledzenie działań wybranego przez siebie streamera na witrynie Twitch.tv.

## Sposób Działania Aplikacji

Aplikacja Bot API standardowo działa na serwerze Tomcat na porcie 8080. Po uruchomieniu aplikacji, możesz odwiedzić [localhost:8080](http://localhost:8080), aby uzyskać dostęp do interfejsu użytkownika.

### Strona Główna

![Strona Główna](https://github.com/GitHubCezary/botApi/blob/4385157e41d299129c25c7be46694f4290d9a73c/Zrzut%20ekranu%202024-01-24%20163227.png)

Na stronie głównej znajdują się opcje logowania z użyciem OAuth2. Użytkownik loguje się przez zewnętrznych dostawców usług GOOGLE lub GITHUB. Dostawcy udostępnią aplikacji nazwę użytkownika, adres e-mail, ustawienia języka i zdjęcie profilowe. Po poprawnym zalogowaniu użytkownik przechodzi do widoku aplikacji.

### Strona po Zalogowaniu

![Strona po Zalogowaniu](https://github.com/GitHubCezary/botApi/blob/91d578fd9050bec449f439e74ebcdb7198475758/Zrzut%20ekranu%202024-01-25%20105142.png)

Po wprowadzeniu nazwy streamera i kliknięciu przycisku "Send", aplikacja sprawdzi jednorazowo, czy stream jest online. Niezależnie od wyniku API powiadomi użytkownika o wyniku wyszukiwania.

Przykład:

![Przykład](https://github.com/GitHubCezary/botApi/blob/a7eae0e3ca3c31ac5eaaa35683443b8fa91eb003/Zrzut%20ekranu%202024-01-25%20110034.png)

Aby skorzystać z bota, użytkownik musi sprawdzić wcześniej jednorazowo. Po dokonaniu sprawdzenia nazwa szukanego streamera jest już w pamięci API, i nie trzeba jej wprowadzać ponownie. Następnie użytkownik ustawia czas działania bota - czas przeszukiwania sieci. (Standardowo maksymalny czas działania bota jest ograniczony do 60 minut - można to zmienić w kodzie aplikacji). Jeżeli podczas działania bota wyszukiwany streamer będzie online, aplikacja wyśle powiadomienie do grupy Telegram przez bota Telegram. API wyśle powiadomienie również, gdy bot zakończył swoje działanie, a streamer pozostawał offline. API z pobranych informacji od dostawcy usług wyświetla nazwę użytkownika. Na dole widoku dostępna jest opcja wylogowania.

## Bezpieczeństwo

Aplikacja nie przechowuje haseł i danych wrażliwych użytkowników. Autentykacja odbywa się za pomocą OAuth2 przez zewnętrznych dostawców usług. Aplikacja korzysta z publicznych danych użytkowników takich jak: nazwa, adres e-mail czy zdjęcie profilowe.

### Sposób Uruchomienia Aplikacji

1. **Sklonuj Repozytorium:**
    ```bash
    git clone https://github.com/GitHubCezary/botApi.git
    ```

2. **Zainstaluj WebDriver dla Selenium:**
    - Pobierz i zainstaluj odpowiedni WebDriver.
    - W klasie konfiguracyjnej podaj ścieżkę dostępu do zainstalowanego WebDrivera.

3. **Utwórz API dla Usługi Logowania OAuth2:**
    - Skonfiguruj zewnętrznego dostawcę usług logowania OAuth2 (np. Google, GitHub).
    - Utwórz konto deweloperskie i uzyskaj klienta ID oraz tajny klucz OAuth2.

4. **Dodaj Dane OAuth2 do Pliku `application.yml`:**
    - Wprowadź uzyskane klienta ID oraz tajny klucz OAuth2 do pliku `application.yml` w odpowiednich miejscach.

    ```yaml
    oauth2:
      client_id: TWÓJ_CLIENT_ID
      client_secret: TWÓJ_CLIENT_SECRET
    ```

5. **Utwórz Bota Telegram:**
    - Przejdź do Aplikacji Telegram i utwórz własnego bota.
    - Utwórz grupę na Telegramie z czatem, w którym będzie działać bot.

6. **Konfiguruj Aplikację:**
    - Skonfiguruj aplikację zgodnie z potrzebami, korzystając z danych OAuth2 oraz ustawień bota Telegram.

7. **Uruchom Aplikację:**
    - Uruchom aplikację i sprawdź, czy wszystko działa poprawnie.

 
 

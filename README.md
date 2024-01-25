# Aplikacja Bot API

Aplikacja ma na celu śledzenie działań wybranego przez siebie streamera na witrynie Twitch.tv.
## Sposób Działania Aplikacji

Aplikacja Bot API standardowo działa na serwerze Tomcat na porcie 8080. Po uruchomieniu aplikacji, możesz odwiedzić [localhost:8080](http://localhost:8080), aby uzyskać dostęp do interfejsu użytkownika.

### Strona Główna

![Strona Główna](https://github.com/GitHubCezary/botApi/blob/4385157e41d299129c25c7be46694f4290d9a73c/Zrzut%20ekranu%202024-01-24%20163227.png)

Na stronie głównej znajdują sie opcje logowania z użyciem OAuth2. Użytkownik loguje się przez zewnętrzynych dostawców usług GOOGLE lub GITHUB. dostawcy udostępnią aplikacji nazwę użytkownika, adres e-mail, ustawienia języka i zdjęcie profilowe.
Po poprawnym zalogowaniu użytkownik przechodzi do widoku aplikacji
### Strona po zalogowaniu
![Strona po zalogowaniu](https://github.com/GitHubCezary/botApi/blob/91d578fd9050bec449f439e74ebcdb7198475758/Zrzut%20ekranu%202024-01-25%20105142.png)
Po wprowadzeniu nazwy Streamera i kliknięcia przycisku Send aplikacja sprawdzi jednorazowo czy stream jest online, niezależnie od wyniku api powiadomi użytkownika o wyniku wyszukiwania.
przykład: ![Strona po zalogowaniu](https://github.com/GitHubCezary/botApi/blob/a7eae0e3ca3c31ac5eaaa35683443b8fa91eb003/Zrzut%20ekranu%202024-01-25%20110034.png)
Aby skorzystać z bota użytkownik musi sprawdzić wcześniej jednorazowo. Po dokonaniu sprawdzenia nazwa szukanego Stremera jest juz w Pamięci Api i nie trzeba wprowadzać jej ponownie.
Następnie użytkownik ustawia czas działania bota - czas przeszukiwania sieci. (Standardowo maksymalny czas działania bota jest ograniczony do 60 minut - można to zmienić w kodzie aplikacji)


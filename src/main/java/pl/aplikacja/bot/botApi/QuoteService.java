package pl.aplikacja.bot.botApi;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    private static final List<String> quotes = new ArrayList<>();

    static {
        quotes.add("Wiadomość 1");
        quotes.add("Wiadomość 2");
        quotes.add("Wiadomość 3");
        quotes.add("Wiadomość 4");
        quotes.add("Wiadomość 5");

    }

    public String getRandomQuote() {
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }
}

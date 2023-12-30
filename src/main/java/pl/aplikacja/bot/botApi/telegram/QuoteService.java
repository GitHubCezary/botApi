package pl.aplikacja.bot.botApi.telegram;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService {

    private static final List<String> quotes = new ArrayList<>();

    static {
        quotes.add("STREAM ONLINE");
        quotes.add("W CZASIE DZIAŁANIA BOTA STREAM BYŁ OFFLINE");
    }

    public List<String> getQuotes() {
        return quotes;
    }
}

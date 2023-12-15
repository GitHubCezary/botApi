package pl.aplikacja.bot.botApi;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
public class QuoteGeneratorTelegramBot {

    private final TelegramBot telegramBot;
    private final QuoteService quoteGenerator;


    @Autowired
    public QuoteGeneratorTelegramBot(TelegramBot telegramBot, QuoteService quoteGenerator) {
        this.telegramBot = telegramBot;
        this.quoteGenerator = quoteGenerator;
    }

    @PostConstruct
    //    @Scheduled(fixedRate = 60000) // Adjust the interval as needed (e.g., 60000 ms = 1 minute)
    public void sendScheduledQuote() throws TelegramApiException {
//        telegramBot.getBotToken();
//        telegramBot.getChatId();

        String randomQuote = quoteGenerator.getRandomQuote();
        long chatId = telegramBot.getChatId();
        telegramBot.execute(new SendMessage(String.valueOf(chatId), randomQuote));
    }
}


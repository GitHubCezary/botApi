package pl.aplikacja.bot.botApi;


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

    public QuoteGeneratorTelegramBot sendScheduledQuote() throws TelegramApiException {

        String randomQuote = quoteGenerator.getRandomQuote();
        long chatId = telegramBot.getChatId();
        telegramBot.execute(new SendMessage(String.valueOf(chatId), randomQuote));
        return null;
    }
}



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

    public QuoteGeneratorTelegramBot sendScheduledQuote(String status) throws TelegramApiException {
        String message;
        if (status.equals("live")) {
            message = quoteGenerator.getQuotes().get(1);
        } else {
            message = quoteGenerator.getQuotes().get(2);
        }
        long chatId = telegramBot.getChatId();
        telegramBot.execute(new SendMessage(String.valueOf(chatId), message));
        return null;
    }
}



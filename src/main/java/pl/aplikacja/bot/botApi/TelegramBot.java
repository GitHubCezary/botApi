package pl.aplikacja.bot.botApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class TelegramBot extends TelegramLongPollingBot {


//    @Value("${telegram.bot.token}")
    private String token = "6709114613:AAGo7ZeMIB_RkHuYe-Xi0aTlVoIC8tV4mkY";

    //    @Value("${telegram.bot.chatId}")
    private Long chatId = Long.parseLong("-4094230795");

    @Value("${telegram.bot.username}")
    private String username;

    public TelegramBot() {
    }


    public Long getChatId() {
        return chatId;
    }


    public String getBotToken() {

        return token;
    }


    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }


    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return username;
    }
}

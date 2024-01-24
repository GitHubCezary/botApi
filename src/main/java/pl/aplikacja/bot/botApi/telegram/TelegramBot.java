package pl.aplikacja.bot.botApi.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class TelegramBot extends TelegramLongPollingBot {


    @Value("${telegram.bot.token}")
    private final String token;

    @Value("${telegram.bot.chatId}")
    private final Long chatId = Long.parseLong("YOUR TELEGRAM GROUP ID");

    @Value("${telegram.bot.username}")
    private String username;


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

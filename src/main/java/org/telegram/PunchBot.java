package org.telegram;

import org.telegram.functions.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.telegram.BotConfig.*;
import static org.telegram.Commands.*;


public class PunchBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();
        Keyboard keyboard = new Keyboard();

        switch (message_text) {

            case HIDE:
                keyboard.removeCustomKeyboard(chat_id);
                break;

            case KEYBOARD:
                keyboard.sendCustomKeyboard(chat_id);
                break;

            case HELP:
                    Help help = new Help();
                    help.sendHelp(chat_id);
                break;
        }

        if (update.hasMessage() && update.getMessage().hasText()) {
            Generator generator = new Generator();
            generator.onUpdateReceived(update);
        }
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        return PUNCH_USER;
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return PUNCH_TOKEN;
    }
}
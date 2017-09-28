package org.telegram.functions;

import org.telegram.PunchBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by igor on 27.09.17.
 */
public class Lyrics extends PunchBot {

    public void sendLyrics(long chatId) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText("Скажите название песни");
        //TODO по названию песни возвращать текст из бд
        try {
            // Send the message
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
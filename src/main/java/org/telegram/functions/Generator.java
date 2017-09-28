package org.telegram.functions;

import org.telegram.PunchBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by igor on 27.09.17.
 */
public class Generator extends PunchBot {

    public void sendWords(long chatId, String msg) {

        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText("хуе"+msg.toLowerCase().trim().split(" ")[0]);

        try {
            // Send the message
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
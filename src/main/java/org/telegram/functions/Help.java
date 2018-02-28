package org.telegram.functions;

import org.telegram.PunchBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import static org.telegram.Commands.*;

/**
 * Created by igor on 28.09.17.
 */

public class Help extends PunchBot {

    public void sendHelp(long chatId) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText("Дорогой друг! Бот находится в разработке, пока от него мало толку. Он умеет рифмовать слова которые ему говорят, попробуйте. Используйте команды "+ KEYBOARD + ", " + HELP + ", " + HIDE + "." );

        try {
            // Send the message
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}

package org.telegram.functions;

import org.telegram.PunchBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static org.telegram.Commands.*;

public class Keyboard extends PunchBot {

    public void sendCustomKeyboard(long chatId) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText("Хей-хей давай рифмовать!");

        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row

        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add(KEYBOARD);
        // Add the first row to the keyboard
        keyboard.add(row);
        // Create another keyboard row
        row = new KeyboardRow();
        // Set each button for the second line
        row.add(HELP);
        // Add the second row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup
        row = new KeyboardRow();
        row.add(HIDE);
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        try {
            // Send the message
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void removeCustomKeyboard(long chatId) {
        SendMessage msg = new SendMessage()
                .setChatId(chatId)
                .setText("Скажи слово и я скажу рифму.");
        ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
        msg.setReplyMarkup(keyboardMarkup);
        try {
            sendMessage(msg); // Call method to send the photo
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}


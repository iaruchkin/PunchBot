package org.telegram;

import org.telegram.functions.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import sun.security.util.Length;

import static org.telegram.BotConfig.*;
import static org.telegram.Commands.*;


public class PunchBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();

        // We check if the update has a message and the message has text
        // Set variables

        if (message_text.equals(KEYBOARD)) {

            Keyboard keyboard = new Keyboard();
            keyboard.sendCustomKeyboard(chat_id);
        }

        if (message_text.equals(GENERATOR)) {

            Generator generator = new Generator();
            generator.sendWords(chat_id,message_text);
        }

        if (message_text.equals(PUNCH)) {

            Punch punch = new Punch();
            punch.sendPunch(chat_id);
        }

        if (message_text.equals(LYRICS)) {

            Lyrics lyrics = new Lyrics();
            lyrics.sendLyrics(chat_id);
        }

        if (message_text.equals(HELP)){
            Help help = new Help();
            help.sendHelp(chat_id);
        }

        if (message_text.endsWith("?")){
            String[] answer = {"Да мне как-то поебать","Я че ебанутый?","Изи-изи","Антихайп"};

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(answer[(int)(Math.random()*answer.length)]);

            try {
                sendMessage(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        else {

            String[] answer = {"Риал толк, синк эбаут зис"," Антихайп","Изи-изи","Я комар-парижанин", "МДМА-шку будешь?"};

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(answer[(int)(Math.random()*answer.length)]);

            try {
                Thread.sleep(1000);

                try {
                    sendMessage(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } catch(Exception e){
                e.printStackTrace();
            }
        }
        //TODO small talk+randomize
    }

    //  @Override
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
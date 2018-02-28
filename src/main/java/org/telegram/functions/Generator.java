package org.telegram.functions;

import org.telegram.PunchBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by igor on 27.09.17.
 */

import java.net.*;
import java.io.*;

import static org.telegram.Commands.GENERATOR;

public class Generator extends PunchBot  {

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();

                sendRythm(chat_id, message_text);
            }
        }

    public  String Generate(String symbol) {
        String theWholePage = null;
        String Word=null;
        URL url = null;
        URLConnection urlConn = null;
        InputStreamReader inStream = null;
        BufferedReader buff = null;

        try {
            // index.html is a default URL's  file name
            url  = new URL("http://rifma-online.ru/rifma/" + symbol);
            urlConn = url.openConnection();
            inStream = new InputStreamReader(
                    urlConn.getInputStream());
            buff  = new BufferedReader(inStream);

            String currentLine;
            while ((currentLine=buff.readLine()) !=null){
                theWholePage+=currentLine;
            }

            String str="data-suffix-len";
            int k=theWholePage.indexOf(str)+str.length();
            Word=theWholePage.substring(k,k+40).replaceAll("[^А-Яа-я]","");
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
       }
       catch (IOException e1) {
           System.out.println("Can't read  from the Internet");
            e1.printStackTrace();
        }

        //TODO try with resourses
        finally {
            try {
                inStream.close();
                buff.close();
            } catch (Exception e) {
                System.out.println("StockQuote: can't close streams" + e.getMessage());
            }
        }
        return Word;
    }

        public void sendWords(long chatId) {

            SendMessage message = new SendMessage()
                    .setChatId(chatId)
                    .setText("Слушаю...");

            try {
                // Send the message
                sendMessage(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        public void sendRythm(long chatId, String msg) {
            String rythm = Generate(msg);

            SendMessage message = new SendMessage()
                    .setChatId(chatId)
                    .setText(rythm);
            try {
            Thread.sleep(200);

            try {
                sendMessage(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
                e.printStackTrace();
            }

    }

}




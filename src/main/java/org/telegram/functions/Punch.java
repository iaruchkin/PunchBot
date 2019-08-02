package org.telegram.functions;

/**
 * Created by igor on 27.09.17.
 */
        import org.telegram.PunchBot;
        import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
        import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


        import java.util.ArrayList;
        import java.util.List;

        import static org.telegram.Commands.*;

public class Punch extends PunchBot {

    public void sendPunch(long chatId) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText("Панчи варятся");

        //TODO возвращать панч на фразу, анализируя последние 3 слова в лучшем случае и 1 слово в худшем

        try {
            // Send the message
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}

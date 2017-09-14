import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class PunchBot extends TelegramLongPollingBot {
   // @Override
    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            /*if (message.getText().equals("/help"))
                message_text = "Изи, изи, мэн";
            else if (message.getText().endsWith("?"))
                message_text = "Да мне как-то поебать";//randomize Я че ебанутый?
            else
                message_text = "Риал толк, синк эбаут зис. Антихайп.";*/

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(message_text);

            try {
                sendMessage(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

  //  @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "punch_bot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "423043743:AAFGkOhvnyoi1fBqC34xbSLQtLIHo2oTk4k";
    }
}
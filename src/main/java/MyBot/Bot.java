package MyBot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.LinkedList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    public static List<String> list = new LinkedList<>();
    static int x = 0;

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            System.out.println(e);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            try {
                ReadFile.readBR();
                for (int j = 0; j < 5; j++) {
                    sendMsg(chat_id, list.get(x));
                    x++;
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sendMsg(long chatId, String s) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        execute(sendMessage);
    }

    @Override
    public String getBotUsername() {
        return "Murasame_bot";
    }

    @Override
    public String getBotToken() {
        return "1244551745:AAFNigrhh3AF1O4kFwFNqKtOP2p3SEsX-NI";
    }
}

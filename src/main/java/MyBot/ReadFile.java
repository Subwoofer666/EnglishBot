package MyBot;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class ReadFile {

    public static void readBR() throws IOException {
        String fileName = "C:\\1.txt";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
            String line = null;
            while ((line = reader.readLine()) != null) {
                int index = line.lastIndexOf(' ');
                if (index == -1) {
                    // Wrong format
                } else {
                    String name = line.substring(0, index);
                    Bot.list.add(name);
                }
            }
            Collections.shuffle(Bot.list);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

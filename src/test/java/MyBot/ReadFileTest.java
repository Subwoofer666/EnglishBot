package MyBot;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ReadFileTest {

    @Test
    public void readBR() throws IOException {
        ReadFile.readBR();
        assertEquals(5000, Bot.list.size()-1);
    }
}
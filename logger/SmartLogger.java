package logger;

import java.time.LocalDateTime;

public class SmartLogger implements Logger {
    private int counter = 0;

    @Override
    public void log(String msg) {
        String oldWord = "INFO";
        String word = "error";
        String newWord = "ERROR";
        counter++;


        System.out.printf("%s#%d [%s] <%s>\n",
                msg.toLowerCase().contains(word) ? newWord : oldWord,
                counter,
                LocalDateTime.now(),
                msg);
    }
}

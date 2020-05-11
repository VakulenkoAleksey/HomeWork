package allhomework.homework19.messages;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleMessage implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;

    public SimpleMessage(String text) {
        this.text = text;
    }

    public SimpleMessage(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getText() {
        return text;
    }

    public SimpleMessage() {
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }



    @Override
    public String toString() {
        if (sender != null) {
            return "SimpleMessage{" +
                    "sender='" + sender + '\'' +
                    ", text='" + text + '\'' +
                    ", dateTime=" + dateTime.withNano(0) +
                    '}';
        }else {
            return text;
        }
    }
    public static SimpleMessage getInstance(String sender, String text){
        return new SimpleMessage(sender, text);
    }

    public static SimpleMessage getInstance(String text){
        return new SimpleMessage(text);
    }
}
package se.kth.ict.nextgenpos.view;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by nicla on 2017-05-16.
 * This class handel error messages to the user.
 */
public class ErrorMessageHandler {

    /**
     * Shows the error message.
     *
     * @param msg The error message.
     */
    void ShowErrorMessage(String msg){
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append(createTime());
        errorMsgBuilder.append(", Error; ");
        errorMsgBuilder.append(msg);
        System.out.println(errorMsgBuilder);
    }

    private String createTime(){
        LocalDateTime timeATM = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return timeATM.format(formatter);
    }
}

package se.kth.ict.nextgenpos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by nicla on 2017-05-16.
 *
 * The class that handel the log.
 */
public class LogHandler {
    private static final String LOG_FILE_NAME = "supermarket-log.txt";
    private PrintWriter logFile;

    public LogHandler() throws IOException{
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
    }

    /**
     * Writes log entries.
     *
     * @param exception The log entry.
     */
    public void logException(Exception exception){
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append("Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
    }
    private String createTime(){
        LocalDateTime timeATM = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return timeATM.format(formatter);
    }
}

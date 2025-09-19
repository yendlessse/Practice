package com.ohgiraffers.virtualpet.db;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogDB {
    private static final String FILE_PATH = "log.txt";

    //로그 기록
    public static void log(String message) {
        String timestamp = LocalDateTime.now().toString();
        String logMessage = timestamp + " - " + message;

        try (FileWriter fw = new FileWriter(FILE_PATH, true)) {
            fw.write(logMessage + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.okres.avajLauncher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger logger;
    private static String str = "";
    private static final String FILENAME = "/home/okres/IdeaProjects/AvajLauncher/src/LogFile.txt";

    private Logger() {
    }

    public static synchronized Logger getLogger() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    public void loggerAddLog(String log) {
        str += log + '\n';
    }

    public void loggerShowLog() {
        System.out.println(str);
    }

    public void writeInFile() {
        File file = new File(FILENAME);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

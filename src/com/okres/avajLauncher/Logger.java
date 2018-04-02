package com.okres.avajLauncher;

public class Logger {

    private static Logger logger;
    private static String str;

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
}

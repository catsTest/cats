package framework.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerMes {
    private static Logger logger;

    public static void log(String message) {
        logger = LogManager.getLogger();
        logger.log(Level.INFO, message);
    }

    public static void logError(String message) {
        logger = LogManager.getLogger();
        logger.log(Level.ERROR, message);
    }
}

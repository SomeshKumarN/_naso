package naso.utils;

import org.apache.log4j.*;

public class Log4jLogger {
    public static Logger log = Logger.getLogger(Log4jLogger.class);

    static {
        // creates pattern layout
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "[%p]:[%d]:[Activity Name] - %m%n";
        layout.setConversionPattern(conversionPattern);

        // creates console appender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.activateOptions();

        // configures the root logger
        log.setLevel(Level.ALL);
        log.addAppender(consoleAppender);
    }

    public static void logTrace(String message) {
        log.trace(message);
    }

    public static void logDebug(String message) {
        log.debug(message);
    }

    public static void logInfo(String message) {
        log.info(message);
    }

    public static void logWarn(String message) {
        log.warn(message);
    }

    public static void logError(String message) {
        log.error(message);
    }

    public static void logFatal(String message) {
        log.fatal(message);
    }

}

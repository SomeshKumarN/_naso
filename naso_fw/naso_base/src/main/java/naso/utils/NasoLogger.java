package naso.utils;

public class NasoLogger {
    public static void logTrace(String message) {
        Log4jLogger.logTrace(message);
    }

    public static void logDebug(String message) {
        Log4jLogger.logDebug(message);
    }

    public static void logInfo(String message) {
        Log4jLogger.logInfo(message);
    }

    public static void logWarn(String message) {
        Log4jLogger.logWarn(message);
    }

    public static void logError(String message) {
        Log4jLogger.logError(message);
    }

    public static void logFatal(String message) {
        Log4jLogger.logFatal(message);
    }
}

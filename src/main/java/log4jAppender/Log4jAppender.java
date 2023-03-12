package log4jAppender;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jAppender {
    /**
     * TRACE
     * Most detailed information. Expect these to be written to logs only. Since version 1.2.12
     *
     * DEBUG
     * Detailed information on the flow through the system. Expect these to be written to logs only. Generally speaking, most lines logged by your application should be written as DEBUG
     *
     * INFO
     * Interesting runtime events (startup/shutdown). Expect these to be immediately visible on a console, so be conservative and keep to a minimum.
     *
     * WARN
     * Use of deprecated APIs, poor use of API, 'almost' errors, other runtime situations that are undesirable or unexpected, but not necessarily "wrong". Expect these to be immediately visible on a status console.
     *
     * ERROR
     * Other runtime errors or unexpected conditions. Expect these to be immediately visible on a status console.
     *
     * FATAL
     * Severe errors that cause premature termination. Expect these to be immediately visible on a status console.
     */

    static Logger logger = LogManager.getLogger(Log4jAppender.class);

    public static void main(String[] args) {
        System.out.println("\nLearning Log4J\n");
        logger.trace("Logging with trace");
        logger.info("Logging with info");
        logger.debug("Logging with debug");
        logger.error("Logging with error");
        logger.warn("Logging with warn");
        logger.fatal("Logging with fatal");



    }
}

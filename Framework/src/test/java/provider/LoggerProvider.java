package provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerProvider {

    private static Logger log;

    public static Logger getLog() {

        if (log == null) {
            log = LogManager.getRootLogger();
        }
        return log;
    }
}
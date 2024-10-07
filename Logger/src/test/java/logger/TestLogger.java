package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class TestLogger {

		private static Logger logger = LogManager.getLogger(TestLogger.class);

	    public static void main(String[] args) {
	        logger.info("INfo");
	        logger.debug("Debug");
	        logger.error("Error");
	    }
}

package play;

import io.ib67.gol4j.Logger;
import io.ib67.gol4j.LoggerFactory;
import org.junit.jupiter.api.Test;

public class TestLog {
    @Test
    public void onTest() {
        Logger logger = LoggerFactory.getDefaultFactory().getLogger("TestLogger");
        logger.info("Hello World");
        logger.warn("Hello World");
        logger.error("Hello World");
        logger.fatal("Hello World");
        logger.verbose("Hello World");
        logger.debug("Hello World");
    }
}

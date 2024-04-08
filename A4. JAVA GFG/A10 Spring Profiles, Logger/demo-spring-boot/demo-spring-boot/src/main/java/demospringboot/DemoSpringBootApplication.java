package demospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBootApplication {
	static Logger logger = LoggerFactory.getLogger(DemoSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
//		System.out.println("Inside main method");
//		System.out.println("Another line of code");

		logger.error("Error log");
		logger.warn("Warn log");
		logger.info("Info log");
		logger.debug("Debug log");
		logger.trace("Trace log");
	}

}

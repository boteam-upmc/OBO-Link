package org.upmc.obolink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.upmc.obolink.configuration.WebMvcConfig;

import static java.lang.System.exit;

/**
 * The starting point of the application.
 */
@SpringBootApplication
public class OboLinkApplication {

	/**
	 * Start spring.
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Path to your resources folder missing.");
			exit(130);
		}
		WebMvcConfig.setRessourcesPathA(args[0]);
		SpringApplication.run(OboLinkApplication.class, args);
	}
}

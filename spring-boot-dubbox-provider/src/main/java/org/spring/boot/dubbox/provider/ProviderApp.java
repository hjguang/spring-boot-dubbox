package org.spring.boot.dubbox.provider;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.dubbox.api.JournalService;
import org.spring.boot.dubbox.provider.service.JournalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author houjianguang
 *
 */
@SpringBootApplication
public class ProviderApp implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ProviderApp.class);

	public static void main(String[] args) {
		SpringApplication.run(ProviderApp.class, args);
	}

	@Autowired
	JournalService journalService;

	@Override
	public void run(String... arg0) throws Exception {
		log.info("@@ Inserting Data....");
		journalService.insertData();
//		log.info("@@ findAll() call...");
//		service.findAll().forEach(entry -> log.info(entry.toString()));
	}

	// @Bean
	// public EmbeddedServletContainerFactory servletContainer() {
	// JettyEmbeddedServletContainerFactory factory = new
	// JettyEmbeddedServletContainerFactory();
	// return factory;
	// }

}

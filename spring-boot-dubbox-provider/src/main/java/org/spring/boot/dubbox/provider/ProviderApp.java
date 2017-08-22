package org.spring.boot.dubbox.provider;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author houjianguang
 *
 */
@SpringBootApplication
public class ProviderApp {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(ProviderApp.class, args);
	}

//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//		JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
//		return factory;
//	}

}

/**
 * 
 */
package org.spring.boot.dubbox.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author houjianguang
 *
 */
@SpringBootApplication
@ComponentScan("org.spring.boot.dubbox.consumer")
public class ConsumerApp {

	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApp.class, args);
	}

	
	
}

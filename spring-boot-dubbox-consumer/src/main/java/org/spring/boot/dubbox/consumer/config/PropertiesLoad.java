package org.spring.boot.dubbox.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @author houjianguang
 *
 */
@Configuration
@ImportResource("classpath:META-INF/spring/dubbo-consumer.xml")
public class PropertiesLoad {

}

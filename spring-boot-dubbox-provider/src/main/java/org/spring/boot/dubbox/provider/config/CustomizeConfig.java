/**
 * 
 */
package org.spring.boot.dubbox.provider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义配置属性
 * @author houjianguang
 *
 */
@Component
public class CustomizeConfig {

	@ConfigurationProperties(prefix="druid")
	class DruidConfig {
		private Integer initialSize;
		private Integer maxActive;

		public Integer getInitialSize() {
			return initialSize;
		}

		public void setInitialSize(Integer initialSize) {
			this.initialSize = initialSize;
		}

		public Integer getMaxActive() {
			return maxActive;
		}

		public void setMaxActive(Integer maxActive) {
			this.maxActive = maxActive;
		}
	}
}

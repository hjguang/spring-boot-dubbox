/**
 * 
 */
package org.spring.boot.dubbox.provider.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * @author houjianguang
 *
 */
@Configuration
public class DatabaseConfig {
	
	@Bean(name="dataSource", initMethod="init", destroyMethod="close")
	@Primary
	@ConfigurationProperties("spring.datasource.druid")
	public DataSource dataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean(name="otherDataSource", initMethod="init", destroyMethod="close")
	@ConfigurationProperties("other.datasource.druid")
	public DataSource otherDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(@Qualifier("dataSource")DataSource dataSource) {
		 return new JdbcTemplate(dataSource);
	}
	
	@Bean("otherJdbcTemplate")
	public JdbcTemplate otherJdbcTemplate(@Qualifier("otherDataSource")DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}

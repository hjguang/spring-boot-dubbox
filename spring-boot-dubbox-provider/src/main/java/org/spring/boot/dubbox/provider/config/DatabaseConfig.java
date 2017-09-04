/**
 * 
 */
package org.spring.boot.dubbox.provider.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageHelper;

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
	
	@Value("${first.mapper.locations}")
	private String firstMapperLocation; //第一个数据源的mapper路径
	
	@Bean("firstSqlSessionFactory")
//	@ConfigurationProperties("mybatis")
	public SqlSessionFactory firstSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean =new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources(firstMapperLocation));
		PageHelper pageHelper = this.initPageHelper();
        bean.setPlugins(new Interceptor[]{pageHelper});
		return bean.getObject();
	}

	/**
	 * 初始化分页信息
	 * @return
	 */
	private PageHelper initPageHelper() {
		PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
	}
}

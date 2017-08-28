package org.spring.boot.dubbox.provider;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

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

//	@Autowired
//	JournalService journalService;
//	@Autowired
//	DataSource dataSource;
	
	@Override
	public void run(String... arg0) throws Exception {
//		log.info("@@ Inserting Data....");
//		journalService.insertData();
//		System.out.println(dataSource);
//		log.info("@@ findAll() call...");
//		service.findAll().forEach(entry -> log.info(entry.toString()));
		
//		System.out.println(dataSource);
//		System.out.println(secondaryDataSource);
		jdbcTemplate.execute("select * from travelrecord");
		otherJdbcTemplate.execute("select * from travelrecord");
	}

	// @Bean
	// public EmbeddedServletContainerFactory servletContainer() {
	// JettyEmbeddedServletContainerFactory factory = new
	// JettyEmbeddedServletContainerFactory();
	// return factory;
	// }
	
//	@Primary
//	@Bean(name = "primaryDataSource")
//	@ConfigurationProperties(prefix = "spring.datasource.druid")
//	public DataSource primaryDataSource() {
//		 log.info("-------------------- primaryDataSource init ---------------------");
//		 return DruidDataSourceBuilder.create().build();
//	}
	
//	@Value("${druid.secondary.url}")
//	String url;
//	@Value("${druid.secondary.username}")
//	String username;
//	@Value("${druid.secondary.password}")
//	String password;
	
//	@Bean(name = "secondaryDataSource")
//    @ConfigurationProperties(prefix = "datasource.secondary")
//	public DataSource dataSourceTwo(){
//		 log.info("-------------------- secondaryDataSource init ---------------------");
//		return DruidDataSourceBuilder.create().build();
//	}
	 
	@Resource
    JdbcTemplate jdbcTemplate;
//
    @Resource(name = "otherJdbcTemplate")
    JdbcTemplate otherJdbcTemplate;
//
//    @Bean(name = "primaryJdbcTemplate")
//    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    @Bean(name = "secondaryJdbcTemplate")
//    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
	 
}

package org.spring.boot.dubbox.provider.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.dubbox.api.JournalService;
import org.spring.boot.dubbox.entity.Journal;
import org.spring.boot.dubbox.entity.TravelRecord;
import org.spring.boot.dubbox.model.PageWrapp;
import org.spring.boot.dubbox.provider.dao.FirstDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 
 * @author houjianguang
 *
 */
@Service
@Path("record")
@Produces({ "application/json; charset=UTF-8", "text/xml; charset=UTF-8" })
public class JournalServiceImpl implements JournalService {

	private static final Logger log = LoggerFactory.getLogger(JournalServiceImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	FirstDao firstDao;

	@Transactional
	public void insertData() {
		log.info("> Table creation");
		jdbcTemplate.execute("DROP TABLE JOURNAL IF EXISTS");
		jdbcTemplate
				.execute("CREATE TABLE JOURNAL(id SERIAL, title VARCHAR(255),summary VARCHAR(255), created TIMESTAMP)");
		log.info("> Inserting data...");
		jdbcTemplate.execute(
				"INSERT INTO JOURNAL(title,summary,created) VALUES('Get to know Spring Boot','Today I will learn Spring Boot', '2016-01-01 00:00:00.00')");
		jdbcTemplate.execute(
				"INSERT INTO JOURNAL(title,summary,created) VALUES('Simple Spring Boot Project','I will do my first Spring Boot project','2016-01-02 00:00:00.00')");
		jdbcTemplate.execute(
				"INSERT INTO JOURNAL(title,summary,created) VALUES('Spring Boot Reading','Read more about Spring Boot','2016-02-01 00:00:00.00')");
		jdbcTemplate.execute(
				"INSERT INTO JOURNAL(title,summary,created)	VALUES('Spring Boot in the Cloud','Learn Spring Boot using Cloud Foundry','2016-01-01 00:00:00.00')");
		log.info("> Done.");
	}

	public List<Journal> findAll() {
		List<Journal> entries = new ArrayList<>();
		jdbcTemplate
				.query("SELECT * FROM JOURNAL",
						new Object[] {}, (rs, row) -> new Journal(rs.getLong("id"), rs.getString("title"),
								rs.getString("summary"), new Date(rs.getTimestamp("created").getTime())))
				.forEach(entry -> entries.add(entry));
		return entries;
	}
	
	@GET
	@Path("list")
	public PageWrapp<TravelRecord> searchByPage(@QueryParam("pageNum") Integer pageNum,
			@QueryParam("pageSize") Integer pageSize) {
		return firstDao.selectByPage(null, pageNum, pageSize);
	}
}

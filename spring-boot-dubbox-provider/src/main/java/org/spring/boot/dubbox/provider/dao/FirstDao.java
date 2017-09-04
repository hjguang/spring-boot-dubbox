package org.spring.boot.dubbox.provider.dao;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.spring.boot.dubbox.entity.TravelRecord;
import org.spring.boot.dubbox.model.PageWrapp;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Repository
public class FirstDao extends SqlSessionDaoSupport{
	
	@Resource
	public void setFirstSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public TravelRecord selectById(Integer id) {
		return getSqlSession().selectOne("org.spring.boot.dubbox.entity.TravelRecord.selectById", id);
	}
	
	public  PageWrapp<TravelRecord> selectByPage(Object entity, int pageNum, int pageSize) {
		Page<TravelRecord> page = PageHelper.startPage(pageNum, pageSize);
		List<TravelRecord> list = getSqlSession().selectList("org.spring.boot.dubbox.entity.TravelRecord.selectByPage", entity);
		return new PageWrapp<>(page.getTotal(), page.getResult());
	}
}

/**
 * 
 */
package org.spring.boot.dubbox.api;

import java.util.List;

import org.spring.boot.dubbox.entity.Journal;
import org.spring.boot.dubbox.entity.TravelRecord;
import org.spring.boot.dubbox.model.PageWrapp;


/**
 * @author houjianguang
 *
 */
public interface JournalService {

	public void insertData();
	
	public List<Journal> findAll();
	
	public PageWrapp<TravelRecord> searchByPage(Integer pageNum, Integer pageSize);
}

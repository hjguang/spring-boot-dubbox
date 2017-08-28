/**
 * 
 */
package org.spring.boot.dubbox.api;

import java.util.List;

import javax.ws.rs.GET;

import org.spring.boot.dubbox.entity.Journal;

/**
 * @author houjianguang
 *
 */
public interface JournalService {

	public void insertData();
	
	public List<Journal> findAll();
}

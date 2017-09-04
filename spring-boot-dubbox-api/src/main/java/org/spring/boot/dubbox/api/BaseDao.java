/**
 * 
 */
package org.spring.boot.dubbox.api;

/**
 * @author houjianguang
 *
 */
public interface BaseDao {

	public <T>T selectById(Integer id);
}

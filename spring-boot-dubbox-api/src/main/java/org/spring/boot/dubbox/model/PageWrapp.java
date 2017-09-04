/**
 * 
 */
package org.spring.boot.dubbox.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author houjianguang
 *
 */
public class PageWrapp<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7461140142364756137L;
	
	private Long total;
	private List<T> result;
	
	public PageWrapp(Long total, List<T> result) {
		this.total = total;
		this.result = result;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}

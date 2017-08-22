package org.spring.boot.dubbox;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author houjianguang
 *
 */
@XmlRootElement
public class WrappResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	public WrappResult() {
		
	}

	public WrappResult(int id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

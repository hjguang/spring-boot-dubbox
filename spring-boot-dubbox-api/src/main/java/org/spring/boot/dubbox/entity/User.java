package org.spring.boot.dubbox.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author houjianguang
 *
 */
@XmlRootElement
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 196650204519004947L;
	
	private Long id;
    private String name;
    private int age;

    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public User(Long id, String name, int age) {
    	this.id = id;
    	this.name = name;
    	this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package org.spring.boot.dubbox.api;

import javax.servlet.http.HttpServletRequest;

import org.spring.boot.dubbox.WrappResult;
import org.spring.boot.dubbox.entity.User;

/**
 * 
 * @author houjianguang
 *
 */
 public interface UserService {

    public User getUserById(Long id, HttpServletRequest request);
    
    public WrappResult save();
    
    public User getUserByIdXml(Long id);
}

package org.spring.boot.dubbox.api;

import org.spring.boot.dubbox.WrappResult;
import org.spring.boot.dubbox.entity.User;

/**
 * 
 * @author houjianguang
 *
 */
 public interface UserService {

    public User getUserById(Long id);
    
    public WrappResult save();
}

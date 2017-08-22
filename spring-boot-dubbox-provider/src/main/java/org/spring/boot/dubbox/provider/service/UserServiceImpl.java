package org.spring.boot.dubbox.provider.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.dubbox.WrappResult;
import org.spring.boot.dubbox.api.UserService;
import org.spring.boot.dubbox.entity.User;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

/**
 * 
 * @author houjianguang
 *
 */
@Service
@Path("user")
@Produces({ "application/json; charset=UTF-8", "text/xml; charset=UTF-8" })
public class UserServiceImpl implements UserService {

	 private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@POST
	@Path("save")
	@Produces({ ContentType.APPLICATION_JSON_UTF_8 })
	public WrappResult save() {
		return new WrappResult((int) (Math.random() * 10));
	}
	
	@GET
	@Path("{id : \\d+}")
//	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public User getUserById(@PathParam("id") Long id, @Context HttpServletRequest request) {
		logger.info("Client address is:{}", request.getRemoteAddr());
		User user = new User(1L, "SpringBoog-Dubbox",20);
    	return user;
	}
	
	@GET
	@Path("/xml/{id : \\d+}")
	@Produces(ContentType.TEXT_XML_UTF_8)
	public User getUserByIdXml(@PathParam("id") Long id) {
		logger.info("Client address is:{}", RpcContext.getContext().getRemoteAddressString());
		User user = new User(10L, "Xml-Entity",20);
    	return user;
	}
}

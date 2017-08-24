/**
 * 
 */
package org.spring.boot.dubbox.customer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author houjianguang
 *
 */
public class RestClientTest extends TestCase {

	@Test
	public void test() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8090/user/1.json");
		Response response = target.request().get();
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
		} else {
			System.out.println(response.readEntity(String.class));
		}
	}
}

/**
 * 
 */
package org.spring.boot.dubbox.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author houjianguang
 *
 */
public class TravelRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4088212624482088671L;
	
	private Integer id;
	private String userId;
	private Date travelDate;
	private BigDecimal fee;
	private Integer days;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
}

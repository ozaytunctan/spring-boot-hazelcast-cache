package org.ozaytunctan.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Ticket implements Serializable {

	private Integer id;

	private String type;

	private Date createdDate;

	private Double price;
	

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}

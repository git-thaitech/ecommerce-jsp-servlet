package model;

import java.sql.Date;

public class Orders {
	private Integer order_id;
	private String user_mail;
	private Integer order_status;
	private Date order_date;
	private String order_discount_code;
	private String order_address;
	private Float total;
	public Orders() {
		super();
	}
	public Orders(Integer order_id, String user_mail, Integer order_status, Date order_date, String order_discount_code,
			String order_address, Float total) {
		super();
		this.order_id = order_id;
		this.user_mail = user_mail;
		this.order_status = order_status;
		this.order_date = order_date;
		this.order_discount_code = order_discount_code;
		this.order_address = order_address;
		this.total = total;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getOrder_discount_code() {
		return order_discount_code;
	}
	public void setOrder_discount_code(String order_discount_code) {
		this.order_discount_code = order_discount_code;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	
}

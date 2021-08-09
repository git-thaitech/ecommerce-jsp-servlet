package model;

public class Orders_detail {
	private Integer order_id;
	private Integer product_id;
	private Integer amount;
	
	

	public Orders_detail() {
		super();
	}

	public Orders_detail(Integer order_id, Integer product_id, Integer amount) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.amount = amount;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}

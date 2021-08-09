package model;

public class Products {

	private Integer product_id;
	private String product_name;
	private String product_des;
	private Float product_price;
	private String product_img_source;
	private String product_type;
	private String product_brand;
	private Integer product_quantity;

	public Products() {
		super();
	}

	public Products(String product_name, String product_des, Float product_price, String product_img_source,
			String product_type, String product_brand, Integer product_quantity) {
		super();
		this.product_name = product_name;
		this.product_des = product_des;
		this.product_price = product_price;
		this.product_img_source = product_img_source;
		this.product_type = product_type;
		this.product_brand = product_brand;
		this.product_quantity = product_quantity;
	}

	public Products(Integer product_id, String product_name, String product_des, Float product_price,
			String product_img_source, String product_type, String product_brand, Integer product_quantity) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_des = product_des;
		this.product_price = product_price;
		this.product_img_source = product_img_source;
		this.product_type = product_type;
		this.product_brand = product_brand;
		this.product_quantity = product_quantity;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_des() {
		return product_des;
	}

	public void setProduct_des(String product_des) {
		this.product_des = product_des;
	}

	public Float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Float product_price) {
		this.product_price = product_price;
	}

	public String getProduct_img_source() {
		return product_img_source;
	}

	public void setProduct_img_source(String product_img_source) {
		this.product_img_source = product_img_source;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

}

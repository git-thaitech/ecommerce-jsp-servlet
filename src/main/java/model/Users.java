package model;

public class Users {
	private String user_mail;
	private String password;
	private Integer account_role;
	private String full_name;
	private String user_address;
	private String user_phone;

	public Users() {
		super();
	}

	public Users(String user_mail, String password, Integer account_role, String full_name, String user_address,
			String user_phone) {
		super();
		this.user_mail = user_mail;
		this.password = password;
		this.account_role = account_role;
		this.full_name = full_name;
		this.user_address = user_address;
		this.user_phone = user_phone;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAccount_role() {
		return account_role;
	}

	public void setAccount_role(Integer account_role) {
		this.account_role = account_role;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	

}

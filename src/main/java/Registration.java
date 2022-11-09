
public class Registration {
	private String name, username, password;
	private String usertype;
	private String duedate,unit,amount;
	
	

	public Registration(String name, String username, String password,String usertype,String unit,String duedate,String amount) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.usertype=usertype;
		this.amount=amount;
		this.duedate=duedate;
		this.unit=unit;
	}
	public Registration() {
		// TODO Auto-generated constructor stub
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

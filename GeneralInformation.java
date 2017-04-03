
public class GeneralInformation extends Section{
	private String name = "-";
	private String address = "-";
	private String phone = "-";
	private String mobile = "-" ;
	private String email = "-";
	
	public GeneralInformation(String title,
			int number,
			String name,
			String address,
			String phone,
			String mobile,
			String email) {
		super(title, number);
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
	}
	
	public void setName(String x) {
		name = x;
	}
	
	public void setAddress(String x) {
		address = x;
	}
	
	public void setPhone(String x) {
		phone = x;
	}
	
	public void setMobile(String x) {
		mobile = x;
	}
	
	public void setEmail(String x) {
		email = x;
	}
}

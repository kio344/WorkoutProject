package dto;

public class UserDto {


	private int num;
	private String id;
	private String pw;
	private String name;
	private String email;
	private int mobile;
	private String address;

	public UserDto() {}

	public UserDto(String id, String pw, String name, String email, int mobile, String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public UserDto(int num, String id, String pw, String name, String email, int mobile, String address) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDto [num = " + num + ", id = " + id + ", pw = " + pw + ", name = " + name + ", email = " + email + ", mobile = "
				+ mobile + ", address = " + address + "]";
	}

	

}

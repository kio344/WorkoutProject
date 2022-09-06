package dto;

public class UserDto {

	private int num;
	private String id;
	private String password;
	private String name;
	private String fakeName;
	private String email;
	private String mobile;
	private String address;
	private String birthDay;
	private String sex;
	private String userType;

	public UserDto() {
	}

	public UserDto(String id, String password, String name, String fakeName, String email, String mobile,
			String address, String birthDay) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.fakeName = fakeName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.birthDay = birthDay;
	}

	public UserDto(int num, String id, String password, String name, String fakeName, String email, String mobile,
			String address, String userType) {
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.fakeName = fakeName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.userType = userType;
	}

	public UserDto(int num, String id, String password, String name, String fakeName, String email, String mobile,
			String address, String birthDay, String sex) {
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.fakeName = fakeName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.birthDay = birthDay;
		this.sex = sex;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFakeName() {
		return fakeName;
	}

	public void setFakeName(String fakeName) {
		this.fakeName = fakeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserDto [num=" + num + ", id=" + id + ", password=" + password + ", name=" + name + ", fakeName="
				+ fakeName + ", email=" + email + ", mobile=" + mobile + ", address=" + address + ", birthDay="
				+ birthDay + ", sex=" + sex + ", userType=" + userType + "]";
	}

}

package container;

public class UserRequest {

	private String user;
	private String address;
	private String position;
	
	public UserRequest(String user, String position, String address) {
		this.user = user;
		this.position = position;
		this.address = address;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}

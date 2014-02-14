package container;

public class UserReply {

	String message;
	String toUser;
	
	public UserReply(String toUser, String message) {
		this.message = message;
		this.toUser = toUser;	
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
}

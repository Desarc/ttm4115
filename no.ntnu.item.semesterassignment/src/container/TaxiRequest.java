package container;

public class TaxiRequest implements QueueItem {

	String userId;
	String toPosition;
	String fromPosition;
	
	public TaxiRequest(String userId, String fromPosition, String toPosition) {
		this.userId = userId;
		this.toPosition = toPosition;
		this.fromPosition = fromPosition;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToPosition() {
		return toPosition;
	}

	public void setToPosition(String toPosition) {
		this.toPosition = toPosition;
	}

	public String getFromPosition() {
		return fromPosition;
	}

	public void setFromPosition(String fromPosition) {
		this.fromPosition = fromPosition;
	}

	@Override
	public String getId() {
		return userId;
	}
	
	
}

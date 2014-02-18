package container;

public class WaitingTaxi implements QueueItem {
	
	public static final String ON_DUTY = "ON_DUTY";
	public static final String OFF_DUTY = "OFF_DUTY";
	public static final String AVAILABLE = "AVAILABLE";
	public static final String UNAVAILABLE = "UNAVAILABLE";
	public static final String WAITING_CONFIRM = "WAITING_CONFIRM";

	String taxiId;
	String status;
	String position;
	
	public WaitingTaxi(String taxiId, String status, String position) {
		this.taxiId = taxiId;
		this.status = status;
		this.position = position;
	}
	
	@Override
	public String getId() {
		return taxiId;
	}

	public void setTaxiId(String taxiId) {
		this.taxiId = taxiId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}

package container;

public class TaxiMessage {

	public static final int onDuty = 1;
	public static final int offDuty = 2;
	public static final int available = 3;
	public static final int unavailable = 4;
	public static final int confirm = 5;
	
	String taxiId;
	int type;
	String message;
	
	public TaxiMessage(String taxiId, int type, String message) {
		this.taxiId = taxiId;
		this.type = type;
		this.message = message;
	}

	public String getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(String taxiId) {
		this.taxiId = taxiId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}

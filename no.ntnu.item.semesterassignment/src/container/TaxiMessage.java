package container;

public class TaxiMessage {
	
	public static final String DISPATCHER = "DISPATCHER";
	public static final String SIMULATOR = "SIMULATOR";
	public static final String MAP = "MAP";

	public static final String onDuty = "ON_DUTY";					//no data
	public static final String offDuty = "OFF_DUTY";				//no data
	public static final String available = "AVAILABLE";				//data1: position
	public static final String unavailable = "UNAVAILABLE";			//no data
	public static final String confirm = "CONFIRM";					//data1: userId, data2: toPosition, data3: fromPosition
	public static final String decline = "DECLINE";					//data1: userId, data2: toPosition, data3: fromPosition
	public static final String taxiRequest = "TAXI_REQUEST";		//data1: toPosition, data2: fromPosition
	public static final String requestConfirm = "REQUEST_CONFIRM";	//data1: taxiId, data2: estimatedTime
	public static final String queueNo = "QUEUE_NO";				//data1: queueNo
	public static final String tourOrder = "TOUR_ORDER";			//data1: userId, data2: toPosition, data3: fromPosition
	public static final String addToMap = "ADD_TO_MAP";				//data1: taxiId, data2: position
	public static final String simulateTrip = "SIMULATE_TRIP";		//data1: taxiId, data2: destination
	
	private String to;
	private String from;
	private String type;
	private String fromAddress;
	private String toAddress;
	private String clientId;
	private int queueNumber;
	
	public TaxiMessage(String to, String from, String type) {
		this.to = to;
		this.from = from;
		this.type = type;
	}
	
	public TaxiMessage(String to, String from, String type, String fromAddress) {
		this.to = to;
		this.from = from;
		this.type = type;
		this.fromAddress = fromAddress;
	}
	
	public TaxiMessage(String to, String from, String type, int queueNumber) {
		this.to = to;
		this.from = from;
		this.type = type;
		this.queueNumber = queueNumber;
	}
	
	public TaxiMessage(String to, String from, String type, String fromAddress, String toAddress) {
		this.to = to;
		this.from = from;
		this.type = type;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
	}
	
	public TaxiMessage(String to, String from, String type, String clientId, String fromAddress, String toAddress) {
		this.to = to;
		this.from = from;
		this.type = type;
		this.clientId = clientId;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
	}
	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}
	
	public int getQueueNumber() {
		return queueNumber;
	}

	public String getClientId() {
		return clientId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

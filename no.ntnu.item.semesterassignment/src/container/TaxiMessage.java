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
	
	String to;
	String from;
	String type;
	String data1;
	String data2;
	String data3;
	
	public TaxiMessage(String to, String from, String type) {
		this.to = to;
		this.from = from;
		this.type = type;
	}
	
	public TaxiMessage(String to, String from, String type, String data1) {
		this.to = to;
		this.from = from;
		this.type = type;
		this.data1 = data1;
	}
	
	public TaxiMessage(String to, String from, String type, String data1, String data2) {
		this.to = to;
		this.from = from;
		this.type = type;
		this.data1 = data1;
		this.data2 = data2;
	}
	
	public TaxiMessage(String to, String from, String type, String data1, String data2, String data3) {
		this.to = to;
		this.from = from;
		this.type = type;
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
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

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}
	
	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

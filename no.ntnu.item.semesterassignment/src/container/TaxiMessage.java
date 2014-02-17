package container;

public class TaxiMessage {
	
	public static final String DISPATCHER = "DISPATCHER";

	public static final int onDuty = 1;
	public static final int offDuty = 2;
	public static final int available = 3;
	public static final int unavailable = 4;
	public static final int confirm = 5;
	public static final int taxiRequest = 6;
	public static final int requestReply = 7;
	
	String to;
	String from;
	int type;
	String data1;
	String data2;
	
	public TaxiMessage(String to, String from, int type) {
		this.to = to;
		this.from = from;
		this.type = type;
	}
	
	public TaxiMessage(String to, String from, int type, String data1) {
		this.to = to;
		this.from = from;
		this.type = type;
		this.data1 = data1;
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

	public TaxiMessage(String to, String from, int type, String data1, String data2) {
		this.to = to;
		this.from = from;
		this.type = type;
		this.data1 = data1;
		this.data2 = data2;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}

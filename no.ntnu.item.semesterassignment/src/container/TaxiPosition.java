package container;

public class TaxiPosition {

	String taxiId;
	String position;
	
	public TaxiPosition(String taxiId, String position) {
		this.taxiId = taxiId;
		this.position = position;
	}

	public String getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(String taxiId) {
		this.taxiId = taxiId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}

package no.ntnu.item.ttm4115.semesterassignment.routeplanner;

public class Journey {
	private String fromAddress;
	private String toAddress;
	private String taxiId;
	
	public Journey(String fromAddress,String toAddress,String taxiId){
		this.setFromAddress(fromAddress);
		this.setToAddress(toAddress);
		this.setTaxiId(taxiId);
		
	}

	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(String taxiId) {
		this.taxiId = taxiId;
	}

}

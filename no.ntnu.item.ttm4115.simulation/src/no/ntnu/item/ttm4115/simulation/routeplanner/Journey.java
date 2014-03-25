package no.ntnu.item.ttm4115.simulation.routeplanner;

public final class Journey {

	public final String fromAddress;
	public final String toAddress;

	public String taxiAlias;

	public Journey(String taxiAlias, String fromAddress, String toAddress) {
		if (fromAddress == null)
			throw new NullPointerException("fromAddress");
		if (toAddress == null)
			throw new NullPointerException("toAddress");
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.taxiAlias = taxiAlias;
	}

	public Journey(String fromAddress, String toAddress) {
		this(null, fromAddress, toAddress);
	}

}

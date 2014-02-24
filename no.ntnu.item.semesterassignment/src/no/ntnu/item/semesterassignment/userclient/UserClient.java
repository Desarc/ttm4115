package no.ntnu.item.semesterassignment.userclient;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class UserClient extends Block {

	public java.lang.String userId;

	public static final String NTNUGløs = "Hogskoleringen 1, 7034 Trondheim, Norge";
	public static final String NTNUDragvoll = "Loholt alle 85, 7049 Trondheim, Norge";
	public static final String TrondheimSpektrum = "Klostergata 88, 7030 Trondheim, Norge";
	public static final String MoholtStudBy = "Moholt Alle 3, 7050 Trondheim, Norge";
	public static final String VollStudBy = "Vegamot 1, 7048 Trondheim, Norge";
	public static final String Sirkus = "Thoning Owesens gate 31, 7044 Trondheim, Norge";
	public static final String Granåsen = "Kongsvegen 204, 7026 Trondheim, Norge";
	public static final String CitySyd = "Ostre Rosten 28, 7075 Tiller, Norge";
	public static final String IKEA = "Landbruksvegen 2, 7047 Trondheim, Norge";
	public static final String TrondheimTorg = "Kongens gate 22B, 7011 Trondheim, Norge";
	public static final String NidarosDomen = "Kongsgardsgata 1, 7013 Trondheim, Norge";
	
	private String[] locations = {NTNUGløs, NTNUDragvoll, TrondheimSpektrum, MoholtStudBy, VollStudBy, Sirkus, Granåsen, CitySyd, IKEA, TrondheimTorg, NidarosDomen};

	public java.lang.String location;
	
	public String selectRandomLocation() {
		int rand = (int)(Math.random()*locations.length);
		this.location = locations[rand];
		return this.location;
	}
	
	public TaxiMessage generateRequest(String address) {
		System.out.println("Generating new request for taxi to "+address);
		return new TaxiMessage(TaxiMessage.DISPATCHER, userId, TaxiMessage.taxiRequest, address, this.location);
	}

	public String handleQueueNo(TaxiMessage message) {
		return "You are number "+message.getData1()+" in the queue.";
	}
	
	public String handleConfirm(TaxiMessage message) {
		return "Taxi reserved! "+message.getData1()+" will pick you up shortly.";
	}

	public String taxiRequested(String address) {
		return "Taxi requested to "+address;
	}

}

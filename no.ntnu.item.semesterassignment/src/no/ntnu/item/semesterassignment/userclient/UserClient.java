package no.ntnu.item.semesterassignment.userclient;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class UserClient extends Block {

	public java.lang.String userId;

	public static final String NTNUGløs = "63.419437,10.402002";
	public static final String NTNUDragvoll = "63.408412,10.469792";
	public static final String TrondheimSpektrum = "63.427587,10.376489";
	public static final String MoholtStudBy = "63.411121,10.43237";
	public static final String VollStudBy = "63.409719,10.446918";
	public static final String Sirkus = "63.436158,10.455931";
	public static final String Værnes = "63.454307,10.91751";
	public static final String Granåsen = "63.377121,10.308001";
	public static final String CitySyd = "63.361905,10.377009";
	public static final String IKEA = "63.428653,10.472796";
	public static final String TrondheimTorg = "63.430524,10.395059";
	public static final String NidarosDomen = "63.426935,10.396432";
	
	private String[] locations = {NTNUGløs, NTNUDragvoll, TrondheimSpektrum, MoholtStudBy, VollStudBy, Sirkus, Værnes, Granåsen, CitySyd, IKEA, TrondheimTorg, NidarosDomen};

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

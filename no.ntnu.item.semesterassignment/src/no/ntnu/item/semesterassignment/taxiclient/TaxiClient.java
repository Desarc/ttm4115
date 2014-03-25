package no.ntnu.item.semesterassignment.taxiclient;

import container.TaxiMessage;
import container.TaxiRequest;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiClient extends Block {
	
	final String OFFLINE = "Offline";
	final String ONLINE_AVAIL = "Online, available";
	final String ONLINE_UNAVAIL = "Online, not available";
	final String ORDER_WAITING = "Online, TourOrder waiting";
	final String DRIVING = "Online, driving";
	
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
	

	public String taxiId;
	public TaxiRequest currentRequest;
	public java.lang.String state;
	
	public TaxiClient() {
		state = OFFLINE;
	}
	
	public TaxiMessage generateOnDuty() {
		if (state.equals(OFFLINE)) {
			System.out.println("Logging in...");
			state = ONLINE_UNAVAIL;
		}
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.onDuty);
	}
	
	public TaxiMessage generateOffDuty() {
		if (!state.equals(OFFLINE)) {
			System.out.println("Logging out...");
			state = OFFLINE;
		}
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.offDuty);
	}
	
	private String selectRandomLocation() {
		int rand = (int)(Math.random()*locations.length);
		return locations[rand];
	}
	
	public TaxiMessage generateAvailable() {
		String location = selectRandomLocation();
		if (state.equals(ONLINE_UNAVAIL) || state.equals(DRIVING)) {
			System.out.println("Setting status to available, location: "+location);
			state = ONLINE_AVAIL;
		}
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.available, location);
	}
	
	public TaxiMessage generateUnavailable() {
		if (state.equals(ONLINE_AVAIL)) {
			System.out.println("Setting status to unavailable.");
			state = ONLINE_UNAVAIL;
		}
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.unavailable);
	}
	
	public TaxiMessage generateConfirm() {
		if (state.equals(ORDER_WAITING) && currentRequest != null) {
			System.out.println("Request confirmed.");
			state = DRIVING;
		}
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.confirm, currentRequest.getId(), currentRequest.getFromPosition(), currentRequest.getToPosition());
	}
	
	public TaxiMessage generateDecline() {
		if (state.equals(ORDER_WAITING)) {
			System.out.println("Request declined, setting status to unavailable.");
			state = ONLINE_UNAVAIL;
		}
		TaxiMessage message = new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.decline, currentRequest.getId(), currentRequest.getFromPosition(), currentRequest.getToPosition()); 
		currentRequest = null;
		return message;
	}

	public String handleRequest(TaxiMessage message) {
		if (state.equals(ONLINE_AVAIL)) {
			state = ORDER_WAITING;
		}
		currentRequest = new TaxiRequest(message.getClientId(), message.getFromAddress(), message.getToAddress());
		return "Taxi requested from "+currentRequest.getFromPosition()+" to "+currentRequest.getToPosition()+". Accept?";
	}

}

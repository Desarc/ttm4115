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
	
	public TaxiMessage generateAvailable() {
		if (state.equals(ONLINE_UNAVAIL) || state.equals(DRIVING)) {
			System.out.println("Setting status to available.");
			state = ONLINE_AVAIL;
		}
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.available);
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
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.confirm);
	}
	
	public TaxiMessage generateDecline() {
		if (state.equals(ORDER_WAITING)) {
			System.out.println("Request declined, setting status to unavailable.");
			state = ONLINE_UNAVAIL;
		}
		TaxiMessage message = new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.decline, currentRequest.getId(), currentRequest.getToPosition(), currentRequest.getFromPosition()); 
		currentRequest = null;
		return message;
	}

	public String handleRequest(TaxiMessage message) {
		if (state.equals(ONLINE_AVAIL)) {
			state = ORDER_WAITING;
		}
		currentRequest = new TaxiRequest(message.getData1(), message.getData2(), message.getData3());
		return "Taxi requested from "+currentRequest.getFromPosition()+" to "+currentRequest.getToPosition()+". Accept?";
	}

}

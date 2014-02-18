package no.ntnu.item.semesterassignment.taxiclient;

import container.TaxiMessage;
import container.TaxiRequest;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiClient extends Block {

	public String taxiId;
	public TaxiRequest currentRequest;
	
	public TaxiMessage generateOnDuty() {
		System.out.println("Logging in...");
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.onDuty);
	}
	
	public TaxiMessage generateOffDuty() {
		System.out.println("Logging out...");
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.offDuty);
	}
	
	public TaxiMessage generateAvailable() {
		System.out.println("Setting status to available.");
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.available);
	}
	
	public TaxiMessage generateUnavailable() {
		System.out.println("Setting status to unavailable.");
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.unavailable);
	}
	
	public TaxiMessage generateConfirm() {
		System.out.println("Request confirmed.");
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.confirm);
	}
	
	public TaxiMessage generateDecline() {
		currentRequest = null;
		System.out.println("Request declined, setting status to unavailable.");
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.decline);
	}

	public String handleRequest(TaxiMessage message) {
		currentRequest = new TaxiRequest(message.getData1(), message.getData2(), message.getData3());
		return "Taxi requested from "+currentRequest.getFromPosition()+" to "+currentRequest.getToPosition()+". Accept?";
	}

}

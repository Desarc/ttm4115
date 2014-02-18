package no.ntnu.item.semesterassignment.taxiclient;

import container.TaxiMessage;
import container.TaxiRequest;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiClient extends Block {

	public String taxiId;
	public TaxiRequest currentRequest;
	
	public TaxiMessage generateOnDuty() {
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.onDuty);
	}
	
	public TaxiMessage generateOffDuty() {
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.offDuty);
	}
	
	public TaxiMessage generateAvailable() {
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.available);
	}
	
	public TaxiMessage generateUnavailable() {
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.unavailable);
	}
	
	public TaxiMessage generateConfirm() {
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.confirm);
	}
	
	public TaxiMessage generateDecline() {
		currentRequest = null;
		return new TaxiMessage(TaxiMessage.DISPATCHER, taxiId, TaxiMessage.decline);
	}

	public String handleRequest(TaxiMessage message) {
		currentRequest = new TaxiRequest(message.getData1(), message.getData2(), message.getData3());
		return "Taxi requested from "+currentRequest.getFromPosition()+" to "+currentRequest.getToPosition()+". Accept?";
	}

}

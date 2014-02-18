package no.ntnu.item.semesterassignment.userclient;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class UserClient extends Block {

	public java.lang.String userId;

	public TaxiMessage generateRequest(String address) {
		System.out.println("Generating new request for taxi to "+address);
		return new TaxiMessage(TaxiMessage.DISPATCHER, userId, TaxiMessage.taxiRequest, address);
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

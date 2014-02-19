package no.ntnu.item.semesterassignment.taxicentral.component;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	public String getTopic(TaxiMessage message) {
		return message.getTo();
	}

	public String dispatcherId() {
		return "DISPATCHER";
	}

	public void publishOk() {
		System.out.println("Publish Ok.");
	}

	public void publishError(String error) {
		System.out.println("Publish error: "+error);
	}



}

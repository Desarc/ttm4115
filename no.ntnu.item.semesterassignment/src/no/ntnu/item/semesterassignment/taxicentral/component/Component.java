package no.ntnu.item.semesterassignment.taxicentral.component;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	public String getDispatcherTopic(TaxiMessage message) {
		return message.getTo();
	}
	
	public String getSimulatorTopic() {
		return TaxiMessage.MAP;
	}

	public String getDispatcherId() {
		return TaxiMessage.DISPATCHER;
	}

	public void publishOk() {
		System.out.println("Publish Ok.");
	}

	public void publishError(String error) {
		System.out.println("Publish error: "+error);
	}

	public String getSimulatorId() {
		return TaxiMessage.SIMULATOR;
	}



}

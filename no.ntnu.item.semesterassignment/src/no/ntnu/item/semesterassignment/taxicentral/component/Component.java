package no.ntnu.item.semesterassignment.taxicentral.component;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	public String getDispatcherTopic(TaxiMessage message) {
		return message.getTo();
	}
	
	public String getMapTopic() {
		return TaxiMessage.MAP;
	}

	public String getDispatcherId() {
		return TaxiMessage.DISPATCHER;
	}

	public void publishOk() {
		//System.out.println("Publish Ok.");
	}

	public void publishError(String error) {
		System.out.println("Publish error: "+error);
	}

	public String getSimulatorId() {
		return TaxiMessage.SIMULATOR;
	}

	public void startFailed(String error) {
		System.out.println("Start failed: "+error);
	}

	public void connectionLost(String error) {
		System.out.println("Connection lost: "+error);
	}



}

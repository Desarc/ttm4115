package no.ntnu.item.semesterassignment.taximqtt;

import no.ntnu.item.arctis.runtime.Block;

public class TaxiMQTT extends Block {
	
	public void deserializeError(String error) {
		System.out.println("Deserialize error in TaxiMQTT: "+error);
	}

	public void incomingTopic(String topic) {
		System.out.println(topic);
	}
}

package no.ntnu.item.semesterassignment.taximqtt;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiMQTT extends Block {
	
	public void deserializeError(String error) {
		System.out.println("Deserialize error in TaxiMQTT: "+error);
	}

	public TaxiMessage toTaxiMessage(Object message) {
		return (TaxiMessage)message;
		
	}
}

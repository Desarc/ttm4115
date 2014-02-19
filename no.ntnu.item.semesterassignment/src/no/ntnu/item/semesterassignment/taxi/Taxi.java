package no.ntnu.item.semesterassignment.taxi;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class Taxi extends Block {

	public java.lang.String alias_taxi;
	public container.TaxiMessage currentMessage;
	
	public static String getAlias(String alias) {
		return alias;
	}

	public String getMessageType(TaxiMessage message) {
		return message.getType();
	}

	public String getTopic(TaxiMessage message) {
		return message.getTo();
	}

	public void publishedOk() {
		System.out.println("Publish OK.");
	}

	public void publishError(String error) {
		System.out.println("Publish error: "+error);
	}

}

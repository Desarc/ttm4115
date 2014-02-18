package no.ntnu.item.semesterassignment.user;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class User extends Block {

	public java.lang.String user_alias;
	
	public static String getAlias(String alias) {
		return alias;
	}

	public TaxiMessage generateRequest(String address) {
		System.out.println("Generating new request for taxi to "+address);
		return new TaxiMessage(TaxiMessage.DISPATCHER, this.user_alias, TaxiMessage.taxiRequest, address);
	}

	public String readMessage(TaxiMessage message) {
		return ""+message.getType();
	}

	public String taxiRequested(String address) {
		return "Taxi requested to "+address;
	}
	
}

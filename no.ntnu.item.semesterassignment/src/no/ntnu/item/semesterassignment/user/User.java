package no.ntnu.item.semesterassignment.user;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class User extends Block {

	public java.lang.String user_alias;
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

	public void publishError(String error) {
		System.out.println("Publish error: "+error);
	}

	public void publishedOk() {
		//System.out.println("Publish Ok.");
	}
	
}

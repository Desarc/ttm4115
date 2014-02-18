package no.ntnu.item.semesterassignment.taxi;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class Taxi extends Block {

	public java.lang.String alias_taxi;
	
	public static String getAlias(String alias) {
		return alias;
	}

	public String readMessage(TaxiMessage message) {
		return ""+message.getType();
	}

	public TaxiMessage generateOnDuty() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.DISPATCHER, TaxiMessage.onDuty);
	}
	
	public TaxiMessage generateOffDuty() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.DISPATCHER, TaxiMessage.offDuty);
	}
	
	public TaxiMessage generateAvailable() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.DISPATCHER, TaxiMessage.available);
	}
	
	public TaxiMessage generateUnavailable() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.DISPATCHER, TaxiMessage.unavailable);
	}
	
	public TaxiMessage generateConfirm() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.DISPATCHER, TaxiMessage.confirm);
	}

}

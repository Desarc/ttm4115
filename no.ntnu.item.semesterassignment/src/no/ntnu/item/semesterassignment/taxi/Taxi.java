package no.ntnu.item.semesterassignment.taxi;

import com.bitreactive.library.mqtt.MQTTConfigParam;
import com.bitreactive.library.mqtt.mqttstm.MQTTSTM.Message;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class Taxi extends Block {

	public java.lang.String alias_taxi;
	
	public static String getAlias(String alias) {
		return alias;
	}

	public Message toBytes(String text) {
		return new Message(text.getBytes());
	}
	
	public String toString(Message message) {
		return message.getPayload().toString();
	}

	public MQTTConfigParam generateMQTTParam() {
		MQTTConfigParam param = new MQTTConfigParam("broker.mqttdashboard.com", "generic-map-ui-studass");
		return param;
	}

	public String readMessage(Object message) {
		return ((TaxiMessage)message).getMessage();
	}

	public TaxiMessage generateOnDuty() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.onDuty, "");
	}
	
	public TaxiMessage generateOffDuty() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.offDuty, "");
	}

}

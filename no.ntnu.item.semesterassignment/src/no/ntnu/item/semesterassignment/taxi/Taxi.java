package no.ntnu.item.semesterassignment.taxi;

import com.bitreactive.library.mqtt.MQTTConfigParam;
import com.bitreactive.library.mqtt.mqtt.MQTT.Message;

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
		try {
			return ((TaxiMessage)message).getMessage();
		} catch (ClassCastException cce) {
			return "invalid message type";
		}
	}

	public TaxiMessage generateOnDuty() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.onDuty, "");
	}
	
	public TaxiMessage generateOffDuty() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.offDuty, "");
	}
	
	public TaxiMessage generateAvailable() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.available, "");
	}
	
	public TaxiMessage generateUnavailable() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.unavailable, "");
	}
	
	public TaxiMessage generateConfirm() {
		return new TaxiMessage(this.alias_taxi, TaxiMessage.confirm, "");
	}
	
	public void publishOK() {
		System.out.println("Publish OK.");
	}

	public void publishNOK() {
		System.out.println("Publish not OK.");
	}

	public void connected() {
		System.out.println("Connected.");
	}

	public void connectionLost() {
		System.out.println("Connection lost.");
	}

	public void startFailed() {
		System.out.println("Start failed.");
	}

}

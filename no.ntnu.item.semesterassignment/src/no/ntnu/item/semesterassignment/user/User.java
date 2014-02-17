package no.ntnu.item.semesterassignment.user;

import java.nio.charset.Charset;
import java.util.UUID;

import com.bitreactive.library.mqtt.mqtt.MQTT;
import com.bitreactive.library.mqtt.mqtt.MQTT.Message;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class User extends Block {

	public java.lang.String user_alias;
	
	public static String getAlias(String alias) {
		return alias;
	}

	public Message toBytes(String text) {
		return new Message(text.getBytes(Charset.forName("UTF-8")));
	}

	public String toString(Message message) {
		return new String(message.getPayload());
	}

	public TaxiMessage generateRequest(String address) {
		System.out.println("Generating new request for taxi to "+address);
		return new TaxiMessage(this.user_alias, TaxiMessage.DISPATCHER, TaxiMessage.taxiRequest, address);
	}

	public String readMessage(Object message) {
		try {
			return ""+((TaxiMessage)message).getType();
		}
		catch (ClassCastException cce) {
			return "invalid message type";
		}
		
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
	
	public void deserializeError() {
		System.out.println("Deserialize error.");
	}

	public String taxiRequested(String address) {
		return "Taxi requested to "+address;
	}
	
	public void configureMQTT() {
		setProperty(MQTT.P_MQTT_SERVER, "broker.mqttdashboard.com");
		setProperty(MQTT.P_MQTT_PORT, "1883");    
		setProperty(MQTT.P_MQTT_TOPIC_PUBLISH, "generic-map-ui-studass");
		setProperty(MQTT.P_MQTT_TOPIC_SUBSCRIBE,"generic-map-ui-studass");
		String clientID = UUID.randomUUID().toString().substring(0, 20);
		setProperty(MQTT.P_MQTT_CLIENT_ID, clientID);
	}

}

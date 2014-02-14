package no.ntnu.item.semesterassignment.user;

import com.bitreactive.library.mqtt.MQTTConfigParam;
import com.bitreactive.library.mqtt.mqtt.MQTT.Message;

import container.UserReply;
import container.UserRequest;
import no.ntnu.item.arctis.runtime.Block;

public class User extends Block {

	public java.lang.String user_alias;
	
	public static String getAlias(String alias) {
		return alias;
	}

	public Message toBytes(String text) {
		return new Message(text.getBytes());
	}

	public MQTTConfigParam getMQTTParam() {
		MQTTConfigParam param = new MQTTConfigParam("broker.mqttdashboard.com", "generic-map-ui-studass");
		return param;
	}

	public String toString(Message message) {
		return message.getPayload().toString();
	}

	public UserRequest generateRequest(String address) {
		System.out.println("Generating new request for taxi to "+address);
		return new UserRequest(this.user_alias, "", address);
	}

	public String readReply(Object reply) {
		try {
			return ((UserReply)reply).getMessage();
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

}

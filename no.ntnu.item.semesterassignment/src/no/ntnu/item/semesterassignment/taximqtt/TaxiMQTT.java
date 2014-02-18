package no.ntnu.item.semesterassignment.taximqtt;

import java.nio.charset.Charset;
import java.util.UUID;

import com.bitreactive.library.mqtt.mqtt.MQTT;
import com.bitreactive.library.mqtt.mqtt.MQTT.Message;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiMQTT extends Block {
	
	private String subscribeTopics;
	private String publishTopic;
	// Instance parameter. Edit only in overview page.
	public final java.lang.String groupId;
	
	public void configureMQTT() {
		subscribeTopics = "generic-map-ui-"+groupId;
		publishTopic = "generic-map-ui-"+groupId;
		setProperty(MQTT.P_MQTT_SERVER, "broker.mqttdashboard.com");
		setProperty(MQTT.P_MQTT_PORT, "1883");    
		setProperty(MQTT.P_MQTT_TOPIC_PUBLISH, "generic-map-ui-"+groupId);
		setProperty(MQTT.P_MQTT_TOPIC_SUBSCRIBE, subscribeTopics);
		String clientID = UUID.randomUUID().toString().substring(0, 20);
		setProperty(MQTT.P_MQTT_CLIENT_ID, clientID);
	}
	
	public Message toMessage(String text) {
		return new Message(text.getBytes(Charset.forName("UTF-8")), publishTopic);
	}
	
	public String toString(Message message) {
		return new String(message.getPayload());
	}

	public void setPublishTopic(String topic) {
		if (topic != null) {
			publishTopic = "generic-map-ui-"+groupId+"/"+topic;			
		}
		else {
			publishTopic = "generic-map-ui-"+groupId;
		}
	}
	
	public void addSubscribeTopic(String topic) {
		subscribeTopics += ","+topic;
		setProperty(MQTT.P_MQTT_TOPIC_SUBSCRIBE, subscribeTopics);
	}

	public void publishOK() {
		System.out.println("Publish OK.");
	}

	public void publishNOK(String error) {
		System.out.println("Publish error: "+error);
	}

	public void connected() {
		System.out.println("Connected.");
	}

	public void connectionLost(String error) {
		System.out.println("Connection lost: "+error);
	}

	public void startFailed(String error) {
		System.out.println("Start failed: "+error);
	}

	public void deserializeError(String error) {
		System.out.println("Deserialize error: "+error);
	}

	public TaxiMessage toTaxiMessage(Object message) {
		return (TaxiMessage)message;
		
	}

	// Do not edit this constructor.
	public TaxiMQTT(java.lang.String groupId) {
	    this.groupId = groupId;
	}

}

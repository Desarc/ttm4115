package no.ntnu.item.semesterassignment.taximqtt;

import java.nio.charset.Charset;
import java.util.UUID;

import com.bitreactive.library.mqtt.mqtt.MQTT;
import com.bitreactive.library.mqtt.mqtt.MQTT.Message;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiMQTT extends Block {
	
	private String baseTopic;
	private String subscribeTopics;
	private String publishTopic;
	// Instance parameter. Edit only in overview page.
	public final java.lang.String groupId;
	
	public void configureMQTT() {
		baseTopic = "generic-map-ui-"+groupId;
		subscribeTopics = baseTopic;
		publishTopic = baseTopic;
		setProperty(MQTT.P_MQTT_SERVER, "broker.mqttdashboard.com");
		setProperty(MQTT.P_MQTT_PORT, "1883");    
		setProperty(MQTT.P_MQTT_TOPIC_PUBLISH, publishTopic);
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
			publishTopic = baseTopic+"/"+topic;			
		}
		else {
			publishTopic = baseTopic;
		}
	}
	
	public void addSubscribeTopic(String topic) {
		subscribeTopics += ","+baseTopic+"/"+topic;
		setProperty(MQTT.P_MQTT_TOPIC_SUBSCRIBE, subscribeTopics);
	}

	public void deserializeError(String error) {
		System.out.println("Deserialize error in TaxiMQTT: "+error);
	}

	public TaxiMessage toTaxiMessage(Object message) {
		return (TaxiMessage)message;
		
	}

	// Do not edit this constructor.
	public TaxiMQTT(java.lang.String groupId) {
	    this.groupId = groupId;
	}

}

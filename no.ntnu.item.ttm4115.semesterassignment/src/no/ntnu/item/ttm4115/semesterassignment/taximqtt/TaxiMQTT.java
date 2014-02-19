package no.ntnu.item.ttm4115.semesterassignment.taximqtt;

import java.nio.charset.Charset;
import java.util.UUID;

import com.bitreactive.library.mqtt.MQTTConfigParam;
import com.bitreactive.library.mqtt.mqtt.MQTT.Message;

import container.TaxiMessage;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiMQTT extends Block {

	private String baseTopic;
	// Instance parameter. Edit only in overview page.
	public final java.lang.String groupId;
	
	public MQTTConfigParam configureMQTT(String id) {
		baseTopic = "generic-map-ui-"+groupId;
		String clientID = UUID.randomUUID().toString().substring(0, 20);
		MQTTConfigParam param = new MQTTConfigParam("broker.mqttdashboard.com", 1883, clientID);
		//param.addSubscribeTopic(baseTopic);
		param.addSubscribeTopic(baseTopic+"/"+id);
		param.setDefaultPublishTopic(baseTopic);
		return param;
	}
	
	public Message toMessage(String text, String topic) {
		if (topic == null || topic.isEmpty()) {
			return new Message(text.getBytes(Charset.forName("UTF-8")), baseTopic);
		}
		else {
			return new Message(text.getBytes(Charset.forName("UTF-8")), baseTopic+"/"+topic);
		}
	}
	
	public String toString(Message message) {
		return new String(message.getPayload());
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
package no.ntnu.item.semesterassignment.mapmqtt;

import java.nio.charset.Charset;
import java.util.UUID;

import com.bitreactive.library.mqtt.MQTTConfigParam;
import com.bitreactive.library.mqtt.mqtt.MQTT.Message;

import no.ntnu.item.arctis.runtime.Block;

public class MapMQTT extends Block {

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
	
	public Message toMessage(String data, String topic) {
		if (topic == null || topic.isEmpty()) {
			return new Message(data.getBytes(Charset.forName("UTF-8")), baseTopic);
		}
		else {
			return new Message(data.getBytes(Charset.forName("UTF-8")), baseTopic+"/"+topic);
		}
	}
	
	public String toString(Message message) {
		return new String(message.getPayload());
	}

	// Do not edit this constructor.
	public MapMQTT(java.lang.String groupId) {
	    this.groupId = groupId;
	}
}
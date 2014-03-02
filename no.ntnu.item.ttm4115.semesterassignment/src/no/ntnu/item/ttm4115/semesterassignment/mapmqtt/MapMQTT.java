package no.ntnu.item.ttm4115.semesterassignment.mapmqtt;

import java.nio.charset.Charset;
import java.util.UUID;

import com.bitreactive.library.mqtt.MQTTConfigParam;
import com.bitreactive.library.mqtt.mqtt.MQTT.Message;

import no.ntnu.item.arctis.runtime.Block;

public class MapMQTT extends Block {

	private String baseTopic;
	// Instance parameter. Edit only in overview page.
	public final java.lang.String groupId;
	
	private String[] getTopics(String topics) {
		String[] topicList = topics.split(",");
		return topicList;
	}
	
	public MQTTConfigParam configureMQTT(String topics) {
		baseTopic = "generic-map-ui-"+groupId;
		String clientID = UUID.randomUUID().toString().substring(0, 20);
		MQTTConfigParam param = new MQTTConfigParam("broker.mqttdashboard.com", 1883, clientID);
		if (topics == null || topics.isEmpty()) {
			param.addSubscribeTopic(baseTopic);
		}
		else {
			String[] topicList = getTopics(topics);
			for (String topic : topicList) {
				if (topic.equals("")) {
					param.addSubscribeTopic(baseTopic);
				}
				else {
					param.addSubscribeTopic(baseTopic+"/"+topic);			
				}
			}
		}
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
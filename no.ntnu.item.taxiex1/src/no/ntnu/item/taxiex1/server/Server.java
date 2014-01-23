package no.ntnu.item.taxiex1.server;

import container.Ack;
import container.Order;
import no.ntnu.item.arctis.runtime.Block;

public class Server extends Block {

	boolean alt = false;
	
	public Ack createAck(String message) {
		if (alt) {
			alt = false;
			return new Ack("Ok");
		} else {
			alt = true;
			return new Ack("Not Ok");
		}
	}

	public String handleOrder(Order order) {
		return order.message;
	}

}

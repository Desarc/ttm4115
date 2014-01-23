package no.ntnu.item.taxiex1.server;

import container.Ack;
import container.Order;
import no.ntnu.item.arctis.runtime.Block;

public class Server extends Block {

	boolean alt = false;

	public String displayOrder(Order order) {
		if (order.alias != null) {
			return order.alias+": "+order.message;
		} else {
			return order.message;
		}
	}

	public Ack handleOrder(container.Order order) {
		if (alt) {
			alt = false;
			return new Ack(order.alias, "Ok");
		} else {
			alt = true;
			return new Ack(order.alias, "Not Ok");
		}
	}

}

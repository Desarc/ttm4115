package no.ntnu.item.taxiex1.client;

import container.Ack;
import container.Order;
import no.ntnu.item.arctis.runtime.Block;

public class Client extends Block {

	public Order createOrder() {
		return new Order("Order!");
	}

	public String handleAck(Ack ack) {
		return ack.result;
	}

}

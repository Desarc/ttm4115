package no.ntnu.item.taxiex2.client;

import container.Ack;
import container.Order;
import no.ntnu.item.arctis.runtime.Block;

public class Client extends Block {


	public java.lang.String alias_str;

	public static String getAlias(String alias) {
		return alias;
	}
	
	public static String getAlias(Ack ack) {
		return ack.getAlias();
	}
	
	public Order createOrder() {
		return new Order(alias_str, "Order!");
	}

	public String handleAck(Ack ack) {
		return ack.getResult();
	}
}
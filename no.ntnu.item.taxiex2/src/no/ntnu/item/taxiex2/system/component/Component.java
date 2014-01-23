package no.ntnu.item.taxiex2.system.component;

import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {

	int counter = 0;
	
	public String createAlias() {
		counter++;
		return "Client"+counter;	
	}

}

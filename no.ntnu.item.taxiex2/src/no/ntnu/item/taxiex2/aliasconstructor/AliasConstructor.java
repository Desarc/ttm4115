package no.ntnu.item.taxiex2.aliasconstructor;

import no.ntnu.item.arctis.runtime.Block;

public class AliasConstructor extends Block {

	int counter = 0;
	
	public String createAlias() {
		counter++;
		return ""+counter;
	}

}

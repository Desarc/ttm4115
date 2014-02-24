package no.ntnu.item.semesterassignment.taxifleetsimulator;

import com.bitreactive.library.android.maps.model.MapUpdate;
import com.bitreactive.library.android.maps.model.Marker;
import com.bitreactive.library.android.maps.model.Position;

import container.TaxiMessage;
import container.TaxiPosition;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiFleetSimulator extends Block {



	public container.TaxiMessage currentMessage;

	public String getMessageType(TaxiMessage message) {
		return message.getType();
	}

	public TaxiPosition createPosition() {
		return new TaxiPosition(currentMessage.getData1(), currentMessage.getData2());
	}

	private Position convertPosition(String position) {
		int commaIndex = position.indexOf(",");
		return new Position(Double.parseDouble(position.substring(0, commaIndex)), Double.parseDouble(position.substring(commaIndex+1)));
	}
	
	public MapUpdate updateMap(TaxiPosition position) {
		MapUpdate m = new MapUpdate();
		m.addMarker(Marker.createMarker(position.getTaxiId()).title(position.getTaxiId()).position(convertPosition(position.getPosition())));
		return m;
	}

}

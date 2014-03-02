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
		return new Position(Double.parseDouble(position.substring(0, commaIndex))*1E6, Double.parseDouble(position.substring(commaIndex+1))*1E6);
	}
	
	public MapUpdate updateMap(TaxiPosition position) {
		System.out.println("Putting "+position.getTaxiId()+" on the map with position "+position.getPosition());
		MapUpdate m = new MapUpdate();
		Position p = convertPosition(position.getPosition());
		m.addMarker(Marker.createMarker(position.getTaxiId()).title(position.getTaxiId()).position(p));
		m.setCenter(p);
		m.setZoom(11);
		return m;
	}

	public MapUpdate modifyUpdate(MapUpdate update) {
//		for (Marker marker : update.getMarkers()) {
//			marker.position(new Position(marker.getPosition().getLatitude()*1E6, marker.getPosition().getLongitude()*1E6));
//			//System.out.println(marker.getPosition().getLatitude()+","+marker.getPosition().getLongitude()+"\n");
//		}
		return update;
	}

}

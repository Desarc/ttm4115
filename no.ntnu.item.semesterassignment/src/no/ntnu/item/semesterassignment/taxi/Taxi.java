package no.ntnu.item.semesterassignment.taxi;

import com.bitreactive.library.android.maps.model.MapUpdate;
import com.bitreactive.library.android.maps.model.Marker;
import com.bitreactive.library.android.maps.model.Position;

import container.TaxiMessage;
import container.TaxiPosition;
import no.ntnu.item.arctis.runtime.Block;

public class Taxi extends Block {

	public java.lang.String alias_taxi;
	public container.TaxiMessage currentMessage;
	
	public static String getAlias(String alias) {
		return alias;
	}

	public String getMessageType(TaxiMessage message) {
		return message.getType();
	}

	public String getTopic(TaxiMessage message) {
		return message.getTo();
	}

	public void publishedOk() {
		//System.out.println("Publish OK.");
	}

	public void publishError(String error) {
		System.out.println("Publish error: "+error);
	}

	public TaxiPosition createPositionUpdate(TaxiMessage message) {
		return new TaxiPosition(message.getFrom(), message.getData1());
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
	
	private Position convertPosition(String position) {
		int commaIndex = position.indexOf(",");
		return new Position(Double.parseDouble(position.substring(0, commaIndex))*1E6, Double.parseDouble(position.substring(commaIndex+1))*1E6);
	}

}

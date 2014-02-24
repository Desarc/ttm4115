package no.ntnu.item.semesterassignment.taxisimulator;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm4115.library.routeplanner.routeplanner.Journey;

import com.bitreactive.library.android.maps.model.MapUpdate;

import container.TaxiPosition;

public class TaxiSimulator extends Block {

	
	
	public java.lang.String alias_taxi;
	public java.lang.String currentPosition;

	public static String getAlias(TaxiPosition position) {
		return position.getTaxiId();
	}
	
	public static String getAlias(String alias) {
		return alias;
	}
	
	public Journey createJourney(TaxiPosition position) {
		return new Journey(currentPosition, position.getPosition(), position.getTaxiId());
	}

	public void setPosition(MapUpdate newPosition) {
		this.currentPosition = newPosition.getCenter().getLatitude()+","+newPosition.getCenter().getLongitude();
		System.out.println("New position for "+newPosition.getMarkers().get(0).getId()+": "+currentPosition);
	}

	public void init(TaxiPosition position) {
		this.alias_taxi = position.getTaxiId();
		this.currentPosition = position.getPosition();
	}

	public void remoteError() {
		System.out.println("Remote error (RoutePlanner).");
	}

	public void localError() {
		System.out.println("Local error (RoutePlanner).");
	}

}

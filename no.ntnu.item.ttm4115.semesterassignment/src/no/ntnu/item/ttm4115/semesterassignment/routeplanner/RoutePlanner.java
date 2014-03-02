package no.ntnu.item.ttm4115.semesterassignment.routeplanner;

import no.ntnu.item.ttm4115.semesterassignment.routeplanner.Direction;
import no.ntnu.item.ttm4115.semesterassignment.routeplanner.Journey;
import no.ntnu.item.ttm4115.semesterassignment.routeplanner.Route;
import no.ntnu.item.arctis.runtime.Block;

public class RoutePlanner extends Block {

	private String taxiId;

	public String createURI(Journey journey) {
		this.setTaxiId(journey.getTaxiId());
		return "http://maps.googleapis.com/maps/api/directions/json?origin="+journey.getFromAddress()+"&destination="+journey.getToAddress()+"&sensor=true";
	}

	public Route getRoute(Direction dir) {
		Route route = dir.routes.get(0);
		route.taxiId = this.getTaxiId();
		return route;
	}

	private String getTaxiId() {
		return taxiId;
	}

	private void setTaxiId(String taxiId) {
		this.taxiId = taxiId;
	}
}
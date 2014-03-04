package no.ntnu.item.ttm4115.termassignment.routeplanner;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm4115.termassignment.routeplanner.Direction;
import no.ntnu.item.ttm4115.termassignment.routeplanner.Journey;
import no.ntnu.item.ttm4115.termassignment.routeplanner.Route;

public class RoutePlanner extends Block {

	private String taxiId;

	public String createURI(Journey journey) {
		this.setTaxiId(journey.getTaxiId());
		String fromAddress = journey.getFromAddress().replace(" ", "%20");
		String toAddress = journey.getToAddress().replace(" ", "%20");
		return "http://maps.googleapis.com/maps/api/directions/json?origin="+fromAddress+"&destination="+toAddress+"&sensor=true";
	}

	public Route getRoute(Direction dir) {
		Route route;
		if (dir.routes.size() > 0) {
			route = dir.routes.get(0);
		}
		else {
			route = new Route();
		}
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
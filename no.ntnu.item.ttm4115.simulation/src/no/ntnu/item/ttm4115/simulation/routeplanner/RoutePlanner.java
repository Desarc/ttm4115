package no.ntnu.item.ttm4115.simulation.routeplanner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm4115.simulation.routeplanner.Direction;
import no.ntnu.item.ttm4115.simulation.routeplanner.Journey;
import no.ntnu.item.ttm4115.simulation.routeplanner.Route;

public class RoutePlanner extends Block {

	private static final String ENC = "UTF-8";
	
	private String taxiAlias;

	@SuppressWarnings("deprecation")
	public String createURI(Journey journey) {
		this.taxiAlias = journey.taxiAlias;
		String fromAddress, toAddress;
		try {
			fromAddress = URLEncoder.encode(journey.fromAddress, ENC);
			toAddress = URLEncoder.encode(journey.toAddress, ENC);
		} catch (UnsupportedEncodingException e) {
			// Deprecated code
			fromAddress = URLEncoder.encode(journey.fromAddress);
			toAddress = URLEncoder.encode(journey.toAddress);
		}
		return "http://maps.googleapis.com/maps/api/directions/json?origin="+fromAddress+"&destination="+toAddress+"&sensor=true";
	}

	public Route getRoute(Direction dir) {
		Route route;
		if (dir.routes.size() > 0) {
			route = dir.routes.get(0);
			route.taxiAlias = taxiAlias;
		} else {
			route = new Route(Collections.<Leg>emptyList(), taxiAlias);
		}
		return route;
	}

}
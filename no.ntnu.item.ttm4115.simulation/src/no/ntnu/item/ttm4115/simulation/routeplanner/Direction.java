package no.ntnu.item.ttm4115.simulation.routeplanner;

import java.util.List;

public final class Direction {
	public final String status;
	public final List<Route> routes;

	public Direction(String status, List<Route> routes) {
		if (status == null)
			throw new NullPointerException("status");
		if (routes == null)
			throw new NullPointerException("routes");
		this.status = status;
		this.routes = routes;
	}
}

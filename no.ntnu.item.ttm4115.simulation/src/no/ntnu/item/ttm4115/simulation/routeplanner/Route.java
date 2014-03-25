package no.ntnu.item.ttm4115.simulation.routeplanner;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public final class Route {
	@SerializedName("summary")
	public final String summary;
	@SerializedName("legs")
	public final List<Leg> legs;

	public String taxiAlias;

	public Route(List<Leg> legs, String summary) {
		if (legs == null)
			throw new NullPointerException("legs");
		this.legs = legs;
		this.summary = summary;
	}
}

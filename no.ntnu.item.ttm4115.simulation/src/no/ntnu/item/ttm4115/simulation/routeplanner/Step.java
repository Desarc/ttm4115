package no.ntnu.item.ttm4115.simulation.routeplanner;

import com.google.gson.annotations.SerializedName;

public class Step {

	@SerializedName("travel_mode")
	public final String travelMode;
	@SerializedName("start_location")
	public final Coordinate startLocation;
	@SerializedName("end_location")
	public final Coordinate endLocation;
	@SerializedName("duration")
	public final Duration duration;
	@SerializedName("distance")
	public final Distance distance;

	public Step(String travelMode, Coordinate startLocation,
			Coordinate endLocation, Duration duration, Distance distance) {
		if (travelMode == null)
			throw new NullPointerException("travelMode");
		if (startLocation == null)
			throw new NullPointerException("startLocation");
		if (endLocation == null)
			throw new NullPointerException("endLocation");
		if (duration == null)
			throw new NullPointerException("duration");
		if (distance == null)
			throw new NullPointerException("distance");
		this.travelMode = travelMode;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.duration = duration;
		this.distance = distance;
	}
}

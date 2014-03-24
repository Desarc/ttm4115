package no.ntnu.item.ttm4115.simulation.routeplanner;

import com.google.gson.annotations.SerializedName;

public final class Coordinate {

	@SerializedName("lat")
	public final float latitude;
	@SerializedName("lng")
	public final float longitude;

	public Coordinate(float lat, float lng) {
		this.latitude = lat;
		this.longitude = lng;
	}
}

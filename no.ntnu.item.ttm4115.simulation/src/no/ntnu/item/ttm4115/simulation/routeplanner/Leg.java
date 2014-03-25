package no.ntnu.item.ttm4115.simulation.routeplanner;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public final class Leg {
	public final List<Step> steps;
	@SerializedName("distance")
	public final Distance distance;
	@SerializedName("duration")
	public final Duration duration;
	@SerializedName("start_address")
	public final String startAddress;
	@SerializedName("end_address")
	public final String endAddress;

	public Leg(List<Step> steps, Distance distance, Duration duration,
			String startAddress, String endAddress) {
		if (steps == null)
			throw new NullPointerException("steps");
		if (distance == null)
			throw new NullPointerException("distance");
		if (duration == null)
			throw new NullPointerException("duration");
		if (startAddress == null)
			throw new NullPointerException("startAddress");
		if (endAddress == null)
			throw new NullPointerException("endAddress");
		this.steps = steps;
		this.distance = distance;
		this.duration = duration;
		this.endAddress = endAddress;
		this.startAddress = startAddress;
	}
}

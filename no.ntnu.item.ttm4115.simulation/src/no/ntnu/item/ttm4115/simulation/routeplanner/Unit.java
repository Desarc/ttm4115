package no.ntnu.item.ttm4115.simulation.routeplanner;

import com.google.gson.annotations.SerializedName;

abstract class Unit {

	@SerializedName("text")
	public final String text;
	@SerializedName("value")
	public final int value;

	public Unit(int value, String text) {
		this.text = text;
		this.value = value;
	}

}

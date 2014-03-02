package no.ntnu.item.ttm4115.semesterassignment.motionsimulator;

import com.bitreactive.library.android.maps.model.MapUpdate;
import com.bitreactive.library.android.maps.model.Marker;
import com.bitreactive.library.android.maps.model.Position;

import no.ntnu.item.ttm4115.semesterassignment.routeplanner.Leg;
import no.ntnu.item.ttm4115.semesterassignment.routeplanner.Step;
import no.ntnu.item.ttm4115.semesterassignment.routeplanner.Route;
import no.ntnu.item.arctis.runtime.Block;

public class MotionSimulator extends Block {

	public Route route;
	public int stepCount;
	public int legCount;

	public MapUpdate createMapUpdate() {
		System.out.println("Creating MapUpdate for taxi: "+route.taxiId);
		if(stepCount >= route.legs.get(legCount).steps.size()){
			legCount++;
			return null;
		}
		Leg leg = route.legs.get(legCount);
		Step step = leg.steps.get(stepCount);
		MapUpdate mapUpdate = new MapUpdate();
		Position position = new Position(step.end_location.lat*1E6, step.end_location.lng*1E6);
		mapUpdate.addMarker(Marker.createMarker(route.taxiId).title(route.taxiId).description("Busy...").position(position));
		return mapUpdate;
	
	}

	public int getDelay() {
		if(stepCount >= route.legs.get(legCount).steps.size()){
			return 0;
		}
		int delay = route.legs.get(legCount).steps.get(stepCount).duration.value;
		System.out.println("Delaying for "+ Integer.toString(delay)+" seconds");
		return delay*10;
	}

	public void setCount() {
		System.out.println("Starting Motion Simulator");
		stepCount = 0;
		legCount = 0;
	}

	public void incrementCounters(MapUpdate update) {
		stepCount++;
	}

	public void end(MapUpdate update) {
		return;
	}
}
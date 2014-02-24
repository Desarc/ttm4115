package no.ntnu.item.semesterassignment.taxidispatcher;

import java.util.ArrayDeque;
import java.util.HashMap;

import container.TaxiMessage;
import container.TaxiRequest;
import container.WaitingTaxi;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiDispatcher extends Block {
	
	final String TAXI_READY = "TAXI_READY";
	final String QUEUE_POSITION = "QUEUE_POSITION";
	final String REQUEST_WAITING = "REQUEST_WAITING";
	final String WAIT = "WAIT";
	
	private ArrayDeque<TaxiRequest> requestQueue;
	private ArrayDeque<WaitingTaxi> taxiQueue;
	private HashMap<String, WaitingTaxi> allTaxis;
	
	public container.TaxiMessage currentMessage;
	public container.TaxiRequest currentRequest;
	public container.WaitingTaxi currentTaxi;

	public TaxiDispatcher() {
		requestQueue = new ArrayDeque<TaxiRequest>();
		taxiQueue = new ArrayDeque<WaitingTaxi>();
		allTaxis = new HashMap<String, WaitingTaxi>();
	}
	
	public TaxiMessage createQueueNo() {
		return new TaxiMessage(currentRequest.getId(), TaxiMessage.DISPATCHER, TaxiMessage.queueNo, ""+getRequestQueuePosition(currentRequest.getId()));
	}
	
	private int getRequestQueuePosition(String id) {
		int i = 1;
		for (TaxiRequest tr : requestQueue) {
			if (tr.getId().equals(id)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public TaxiMessage confirmRequest() {
		currentRequest = new TaxiRequest(currentMessage.getData1(), currentMessage.getData2(), currentMessage.getData3());
		currentTaxi = allTaxis.get(currentMessage.getFrom());
		currentTaxi.setStatus(WaitingTaxi.UNAVAILABLE);
		return new TaxiMessage(currentRequest.getId(), TaxiMessage.DISPATCHER, TaxiMessage.requestConfirm, currentTaxi.getId());
	}

	public String getMessageType(TaxiMessage message) {
		System.out.println(message.getType()+" received from "+message.getFrom());
		return message.getType();
	}

	public String handleRequest() {
		currentRequest = new TaxiRequest(currentMessage.getFrom(), currentMessage.getData1(), currentMessage.getData2());
		if (requestQueue.size() == 0 && taxiQueue.size() != 0) {
			return TAXI_READY;
		}
		else {
			requestQueue.addLast(currentRequest);
			return QUEUE_POSITION;
		} 
	}

	public TaxiMessage createTourOrder() {
		currentTaxi = taxiQueue.removeFirst();
		currentTaxi.setStatus(WaitingTaxi.WAITING_CONFIRM);
		System.out.println("Forwarding taxi request from "+currentRequest.getId()+" to "+currentTaxi.getId());
		return new TaxiMessage(currentTaxi.getId(), TaxiMessage.DISPATCHER, TaxiMessage.tourOrder, currentRequest.getId(), currentRequest.getToPosition(), currentRequest.getFromPosition());
	}

	public void setOnDuty() {
		currentTaxi = new WaitingTaxi(currentMessage.getFrom(), WaitingTaxi.ON_DUTY, currentMessage.getData1());
		allTaxis.put(currentTaxi.getId(), currentTaxi);
	}

	public void setOffDuty() {
		currentTaxi = allTaxis.get(currentMessage.getFrom());
		allTaxis.remove(currentTaxi.getId());
		taxiQueue.remove(currentTaxi);
	}

	public String setAvailable() {
		currentTaxi = allTaxis.get(currentMessage.getFrom());
		currentTaxi.setStatus(WaitingTaxi.AVAILABLE);
		currentTaxi.setPosition(currentMessage.getData1());
		if (taxiQueue.size() == 0 && requestQueue.size() != 0) {
			return REQUEST_WAITING;
		}
		else {
			taxiQueue.addLast(currentTaxi);
			return WAIT;
		}
	}

	public void setUnavailable() {
		currentTaxi = allTaxis.get(currentMessage.getFrom());
		currentTaxi.setStatus(WaitingTaxi.UNAVAILABLE);
		taxiQueue.remove(currentTaxi);
	}

	public TaxiMessage taxiConfirm() {
		currentTaxi = allTaxis.get(currentMessage.getFrom());
		currentTaxi.setStatus(WaitingTaxi.UNAVAILABLE);
		System.out.println(currentTaxi.getId()+" confirmed request, forwarding confirmation to "+currentMessage.getData1());
		return new TaxiMessage(currentMessage.getData1(), TaxiMessage.DISPATCHER, TaxiMessage.requestConfirm, currentMessage.getFrom());
	}

	public String taxiDecline() {
		currentTaxi = allTaxis.get(currentMessage.getFrom());
		currentTaxi.setStatus(WaitingTaxi.UNAVAILABLE);
		currentRequest = new TaxiRequest(currentMessage.getData1(), currentMessage.getData2(), currentMessage.getData3());
		if (taxiQueue.size() != 0) {
			return TAXI_READY;
		}
		else {
			requestQueue.addFirst(currentRequest);
			return QUEUE_POSITION;
		}
	}

	public TaxiMessage assignTaxi() {
		currentRequest = requestQueue.removeFirst();
		System.out.println("Forwarding taxi request from "+currentRequest.getId()+" to "+currentTaxi.getId());
		return new TaxiMessage(currentTaxi.getId(), TaxiMessage.DISPATCHER, TaxiMessage.tourOrder, currentRequest.getId(), currentRequest.getToPosition(), currentRequest.getFromPosition());
	}

	public TaxiMessage addToMap() {
		return new TaxiMessage(TaxiMessage.SIMULATOR, TaxiMessage.DISPATCHER, TaxiMessage.addToMap, currentTaxi.getId(), currentTaxi.getPosition());		
	}

	public TaxiMessage simulate() {
		System.out.println("Order confirmed, simulating "+currentTaxi.getId()+" from "+currentMessage.getData3()+" to "+currentMessage.getData2());
		return new TaxiMessage(TaxiMessage.SIMULATOR, TaxiMessage.DISPATCHER, TaxiMessage.simulateTrip, currentTaxi.getId(), currentMessage.getData2());
	}

}

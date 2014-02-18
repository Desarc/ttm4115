package no.ntnu.item.semesterassignment.resourcequeue;

import java.util.ArrayDeque;

import container.QueueItem;
import no.ntnu.item.arctis.runtime.Block;

public class ResourceQueue extends Block {

	private ArrayDeque<QueueItem> queue;
	
	public void addItem(QueueItem item) {
		queue.addLast(item);
	}

	public int getQueueSize() {
		return queue.size();
	}

	public QueueItem getNextItem() {
		return queue.removeFirst();
	}

	public int getItemPosition(String id) {
		int i = 1;
		for (QueueItem qi : queue) {
			if (qi.getId().equals(id)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	

}

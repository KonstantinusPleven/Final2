package logicPack;

import java.util.ArrayList;
import java.util.Scanner;

import eventObjects.Event;
import eventObjects.SetEventObject;

public class ChangeEvent {

	private static final String DATE_FORMAT = "dd/MM/yyyy/hh";
	
	private Scanner scanner = new Scanner(System.in);
	private SetEventObject eventSeter = new SetEventObject();
	
	public Event findEvent(ArrayList<Event> array, String indentification) throws NumberFormatException {
		Event event = null;
		for (int i = 0; i < array.size(); i++) {
			event = array.get(i);
			if (Integer.parseInt(indentification)==event.getIdentificationNumber()) {
				return event;
			}
		}
		return null;
	}

	public Event changeType(Event event) {
		eventSeter.printTypeMenu();
		event.setType(eventSeter.setType(scanner.nextLine()));
		return event;
	}

	public Event changeMarker(Event event) {
		eventSeter.printMarkerMenu();
		event.setMarker(eventSeter.setMarker(scanner.nextLine()));
		return event;
	}

	public Event changeDescription(Event event, String description) {
		System.out.println("Enter short description");
		event.setDescription(description);
		return event;
	}

	public Event changeDate(Event event) {
		System.out.println("Enter date for your event(" + DATE_FORMAT + "):");
		event.setDate(eventSeter.setDate(scanner));
		return event;
	}
}

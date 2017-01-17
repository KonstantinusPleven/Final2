package menu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import eventObjects.Event;
import eventObjects.EventsException;
import eventObjects.SetEventObject;
import logicPack.*;

public class SubMenu {

	private static final String DATE_FORMAT = "dd/MM/yyyy/hh";

	private ChangeEvent changer = new ChangeEvent();
	private PrintEvents printer = new PrintEvents();
	private SetEventObject eventSeter = new SetEventObject();
	private FileReadWrite writer = new FileReadWrite();
	private ChecksTimeLine checker = new ChecksTimeLine();

	private Scanner scan;
	private ArrayList<Event> array = new ArrayList<Event>();

	public void createEventAddToArray() {
		do {
			try {
				scan = new Scanner(System.in);
				Event event = new Event();
				System.out.println("Enter the date for your event(" + DATE_FORMAT + "):");
				event.setDate(eventSeter.setDate(scan));
				eventSeter.printTypeMenu();
				event.setType(eventSeter.setType(scan.nextLine()));
				eventSeter.printMarkerMenu();
				event.setMarker(eventSeter.setMarker(scan.nextLine()));
				System.out.println("Enter short description");
				event.setDescription(eventSeter.setDescription(scan));
				checker.checkForAnotherEvent(array, event);
				array.add(event);
				writer.writingFile(array);
				printer.printEvent(event);
				break;
			} catch (EventsException ex) {
				System.out.println("Can't have 2 events at the same time.");
			}
		} while (true);
	}

	public void printEvents() {
		do{
			try {
				scan = new Scanner(System.in);
				System.out.println("Select option from the menu:");
				System.out.println("\t\t1.Print events for the day.");
				System.out.println("\t\t2.Print events for next 7 days.");
				System.out.println("\t\t3.Print events for next month.");
				System.out.println("\t\t4.Print all events.");
				System.out.println("\t\t5.Exit this menu.");
				int choise = Integer.parseInt(scan.nextLine());
				if (choise == 1)
					printer.printDay(array);
				if (choise == 2)
					printer.printWeek(array);
				if (choise == 3)
					printer.printMonth(array);
				if (choise == 4)
					printer.printEventTable(array);
				if (choise == 5){
					break;
				}
			} catch (NumberFormatException ex) {
				System.out.println("Select option correctly!");
			} catch (NullPointerException ex) {
				System.out.println("Select option correctly!");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}while (true);
	}

	public void changeEvent() {
		Event event = null;
		do{
			try {
				if (array.isEmpty()){
				System.out.println("There are no events yet");
				break;
				}
				else{
				scan = new Scanner(System.in);
				printer.printEventTable(array);
				System.out.println("Enter the identification number of the event:");
				event = changer.findEvent(array, scan.nextLine());
				if (event == null) {
					System.out.println("There is no event with that ID number");
					break;
				}
				}
				System.out.println("Select option from the menu:");
				System.out.println("\t\t1.Date.");
				System.out.println("\t\t2.Type.");
				System.out.println("\t\t3.Marker.");
				System.out.println("\t\t4.Description.");
				System.out.println("\t\t5.Exit.");
				int choise = Integer.parseInt(scan.nextLine());
				if (choise == 1){
					event = changer.changeDate(event);
					break;
				}
				if (choise == 2){
					event = changer.changeType(event);
					break;
				}
				if (choise == 3){
					event = changer.changeMarker(event);
					break;
				}
				if (choise == 4){
					event = changer.changeDescription(event, scan.nextLine());
					break;
				}
				if (choise == 5)
					break;
				printer.printEvent(event);
				writer.writingFile(array);
			} catch (NumberFormatException ex) {
				System.out.println("Select option correctly!");
			} catch (NullPointerException ex) {
				System.out.println("There is no such element.");
			}
		}while (true);
	}

	public void deleteEvent() {
		scan = new Scanner(System.in);
		if (array.isEmpty())
			System.out.println("There are no events yet");
		else {
			printer.printEventTable(array);
			System.out.println("Enter the identification number of the event:");
			Event event = changer.findEvent(array, scan.nextLine());
			if (array.remove(event))
				System.out.println("\t\tDone!");
			writer.writingFile(array);
		}
	}

	public void setArray(ArrayList<Event> array) {
		this.array = array;
	}

}

package menu;

import java.util.Scanner;

import logicPack.FileReadWrite;

public class Menu {
	
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new Menu().menu();
	}

	private void menu() {

		SubMenu submenu = new SubMenu();
		FileReadWrite reader = new FileReadWrite();
		System.out.println("====== WELCOME TO YOUR ORGANIZER ======");
		try {
			submenu.setArray(reader.readingFile());
		} catch (NullPointerException ex) {
			System.out.println("File is empty");
		}
		do{
			try{		
			System.out.println("Choose option from the menu:");
			System.out.println("\t\t 1.Add Event.");
			System.out.println("\t\t 2.Print menu.");
			System.out.println("\t\t 3.Change menu.");
			System.out.println("\t\t 4.Delete Event.");
			System.out.println("\t\t 5.Exit");
			int choise = Integer.parseInt(scan.nextLine());
			if(choise == 1)
				submenu.createEventAddToArray();
			if(choise == 2)
				submenu.printEvents();
			if(choise == 3)
				submenu.changeEvent();
			if(choise == 4)
				submenu.deleteEvent();
			if(choise == 5){
				System.out.println("\t\t   Goodbye!");
				break;
			}
			}catch(NullPointerException ex){
				System.out.println("Select option correctly!");
			}catch(NumberFormatException ex){
				System.out.println("Select option correctly!");
			}
		}while (true);
	}
}
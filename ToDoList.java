import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;


public class ToDoList {
	static TreeSet<task> list = new TreeSet<>(); //store all the tasks in a tree set which is sorted by the order of creation
	
	public static void main(String[] args) {
		
		welcomeUser();
		
		Scanner keyboard = new Scanner(System.in);
		int x = 0;
		createNewTask();
		System.out.println("Task added to your list");

		while(x != 3) { //loop runs the program and prompts user for new input
			x = promptUser();
			if(x==1) {
				createNewTask();
				System.out.println("Task added to your list");
				
			}
			if(x==2) {
				int y = 0;
				
				while(y != 4) {//the multiple ways to display the list run in a sub loop
					y = promptUserSorting();
					if(y==1) {
						displayList();
						
					}
					if(y==2) {
						displayListDue();
							
					}
					if(y==3) {
						displayListName();
						
					}
				}
			}
		}
	}

	public static void createNewTask() { //creates a new task
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a name for your task");
		String taskName = keyboard.nextLine();
		
		System.out.println("How long until that task is due?");
		int dueIn = getValidInt();
		
		list.add(new task(taskName, dueIn, list.size()+1)); //uses the size of the list to get the order the tasks are created in
		//works fine since removal isn't added yet, but that will cause issue, will move over to time stamps then, or I could just read the index
		
	}
	public static void welcomeUser() {
		System.out.println("Welecome to your todo list, please enter a task");
	}
	public static int promptUser() {
		System.out.println("Press 1 to create a new task, 2 to view the list, or 3 to end the program");
		return getValidInt();
	}
	public static int promptUserSorting() {
		System.out.println("Press 1 to sort by created, 2 to sort by due, or 3 to sort by name");
		return getValidInt();
	}
	private static void displayList() { //displays the list by order created
		StringBuilder sbBuilder = new StringBuilder();
		String format = "%1$-10s%2$-10s%3$-35s\n";
		String title = String.format(format,
				"Created","Due","Name");
		sbBuilder.append(title);
		for(task element : list) {
			String currentString = String.format(format,
					element.getCreated(),
					element.getDue(),
					element.getName());
			sbBuilder.append(currentString);
		}
		System.out.println(sbBuilder.toString());
	}
	private static void displayListDue() { //displays list by due time
		TreeSet<task> listByDue = new TreeSet<>(new SortByDue()); //sorts the list into a new set to display by due
		listByDue.addAll(list);
		StringBuilder sbBuilder = new StringBuilder();
		String format = "%1$-10s%2$-10s%3$-35s\n";
		String title = String.format(format,
				"Due","Created","Name");
		sbBuilder.append(title);
		for(task element : listByDue) {
			String currentString = String.format(format,
					element.getDue(),
					element.getCreated(),
					element.getName());
			sbBuilder.append(currentString);
		}
		System.out.println(sbBuilder.toString());
	}
	private static void displayListName() { //displays the list by name of task
		TreeSet<task> listByDue = new TreeSet<>(new SortByName()); //sorts list
		listByDue.addAll(list);
		StringBuilder sbBuilder = new StringBuilder();
		String format = "%1$-35s%2$-10s%3$-10s\n";
		String title = String.format(format,
				"Name","Created","Due");
		sbBuilder.append(title);
		for(task element : listByDue) {
			String currentString = String.format(format,
					element.getName(),
					element.getCreated(),
					element.getDue());
			sbBuilder.append(currentString);
		}
		System.out.println(sbBuilder.toString());
	}
	public static int getValidInt() {
		Scanner keyboard = new Scanner(System.in);
		int value;
		while (true) {
			if (keyboard.hasNextInt()) {
	            value = keyboard.nextInt();
	            break;
	        } else {
	           // System.out.println("Please enter your due date again");
	            keyboard.next();}}
		return value;
	}
	
}
class SortByDue implements Comparator<task>{
	public int compare (task a, task b) {
		return a.getDue() - b.getDue();}
}
class SortByName implements Comparator<task>{
	public int compare (task a, task b) {
		return a.getName().compareTo(b.getName());}
}
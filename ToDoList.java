import java.util.Scanner;
import java.util.TreeSet;

public class ToDoList {

	public static void main(String[] args) {
		//create the list
		TreeSet<task> list = new TreeSet<>();
		
		//using this to keep track of the order tasks are added to the list
		//make sure to iterate it by one each time a new task is added
		int createdCount = 1;
		
		
		welcomeUser();
		
		Scanner keyboard = new Scanner(System.in);
		int x = 0;
		list.add(createNewTask(++createdCount));
		while(x != 3) {
			x = promptUser();
			if(x==1) {
				list.add(createNewTask(++createdCount));
			}
			if(x==2) {
				System.out.println(formatList(list));
				//for(task element : list) {
					//System.out.println(element.toString());
					
			}
		}
	}
	
	public static task createNewTask(int created) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a name for your task");
		String taskName = keyboard.nextLine();
		
		System.out.println("How long until that task is due?");
		int dueIn = getValidInt();
		
		task temp = new task(taskName, dueIn, created);
		return temp;
	}
	public static void welcomeUser() {
		System.out.println("Welecome to your todo list, please enter a task");
	}
	public static int promptUser() {
		System.out.println("Press 1 to create a new task, 2 to view the list, or 3 to end the program");
		return getValidInt();
	}
	private static String formatList(TreeSet<task> input) {
		StringBuilder sbBuilder = new StringBuilder();
		String format = "%1$-10s%2$-35s%3$-10s\n";
		String title = String.format(format,
				"Created","Name","Due");
		sbBuilder.append(title);
		for(task element : input) {
			String currentString = String.format(format,
					element.getCreated(),
					element.getName(),
					element.getDue());
			sbBuilder.append(currentString);
		}
		return sbBuilder.toString();
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

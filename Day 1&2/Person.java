
/**************************************************************************************************************
 * Program:			To create a phone directory. 
 * Description:		Program is to create a phone directory which includes person's 3 credentials:-
 * 					1) First Name
 * 					2) Last Name
 * 					3) Phone Number
 * 					4) Id
 * 					Then we have to do various operations :-
 * 					1) Add a detail.
 * 					2) Remove the specific detail.
 * 					3) Search a specific detail by First Name.
 * 					4) Sort by First Name.
 *************************************************************************************************************/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Details {

	private String fname, lname;
	private int number;
	private static int id = 0;

	public Details(String fname, String lname, int number) {
		this.fname = fname;
		this.lname = lname;
		this.number = number;

	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public int getNumber() {
		return number;
	}

	public int getId() {
		return ++id;
	}

}

public class Person extends Details {
	public Person(String fname, String lname, int number) {
		super(fname, lname, number);

	}

	public static void main(String args[]) {
		int choice;
		List<Details> list = new ArrayList<>();
		while (true) {
			System.out.println("1) Enter the details. ");
			System.out.println("2) Remove the specific detail. ");
			System.out.println("3) Search a specific detail by First Name. ");
			System.out.println("4) Sort by First Name. ");
			System.out.println("Enter the choice to do: ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {

			// Enter the details from user.
			case 1: {
				System.out.println("ENter the details");

				Scanner sc1 = new Scanner(System.in);
				String first = sc1.next();
				String last = sc1.next();
				int num = sc1.nextInt();

				// break;

				Details d1 = new Details(first, last, num);

				list.add(d1);
				System.out.println("Record added successfully");
				break;

			}

			// Remove a specific detail.
			case 2: {
				System.out.println("Remove the details of a person");
				Scanner sc1 = new Scanner(System.in);
				int RemoveById = sc1.nextInt();
				list.remove(RemoveById);
				System.out.println("Record deleted successfully");
				break;

			}

			// Search phone number by first name.
			case 3: {
				System.out.println("Search the details of a person by name");
				Scanner sc1 = new Scanner(System.in);
				String SearchByName = sc1.next();
				Iterator itr = list.iterator();
				String isFound = null;
				int flag = 0;
				while (itr.hasNext()) {
					Details d1 = (Details) itr.next();
					isFound = d1.getFname();
					if (isFound.equalsIgnoreCase(SearchByName)) {
						// System.out.println("Record found/n");
						System.out
								.println(d1.getFname() + " " + d1.getLname() + " " + d1.getNumber() + " " + d1.getId());
					} else
						if(flag == 0)
						System.out.println("Record not found");
				}
				break;
			}

			// Display all the records.
			case 4: {
				System.out.println("Display all the details");
				Iterator itr = list.iterator();
				while (itr.hasNext()) {
					Details d1 = (Details) itr.next();
					System.out.println(d1.getFname() + " " + d1.getLname() + " " + d1.getNumber() + " " + d1.getId());
				}
			}
			
			// Sort by FirstName.
			case 5:{
				
				
			}	
			}
		}
	}

}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



//316083690  
//Full Name: Gal_OR 

public class HW2_GalOr {

	public static ArrayList<Person> insertIntoList(Scanner scn) throws BonusException { //create the employee list

		ArrayList<Person> allEmployees = new ArrayList<Person>();
		Person p = null;
		String type = (getType(scn)).toUpperCase();

		while (!type.equalsIgnoreCase("f")) {
			System.out.print("Please enter full name: ");
			String name = scn.next()+ scn.nextLine();
			
			int salary = getSalary(scn);
			
			scn = new Scanner(System.in);
			System.out.print("Please enter user name: ");
			String UserName = scn.nextLine();
			System.out.print("Please enter password: ");
			String Password = scn.nextLine();

			if (type.equalsIgnoreCase("O") || type.equalsIgnoreCase("M")) {
				scn = new Scanner(System.in);
				System.out.print("Please enter bonus: ");
				int bonus = scn.nextInt();

				switch (type) {
				case "M":
					p = new Manager(name, salary, bonus, UserName, Password);
					break;

				case "O":
					p = new Owner(name, salary, bonus, UserName, Password);
					break;
				}
			} else {

				p = new Worker(name, salary, UserName, Password);

			}
			allEmployees.add(p);

			type = getType(scn);
		}
		return allEmployees;

	}

	public static int getSalary(Scanner scn) throws InputMismatchException { //check the salary
		boolean isOK = false;
		int salary = 0;
		while (!isOK) {
			System.out.print("Please enter salary: ");
			try {
				scn = new Scanner(System.in);
				salary = scn.nextInt();

				isOK = checkSalary(salary);
			} catch (InputMismatchException e) {
				System.out.println("Invalid type for salary, integer is needed!");
				System.out.println();
				
			} catch (Exception e) {
				System.out.println("Salary must be at least 0!");
				System.out.println();
			}
		}

		return salary;
	}

	private static boolean checkSalary(int salary) throws Exception {// check if the salary is legal 
		if (salary < 0)
			throw new Exception();

		return true;
	}

	public static void printList(ArrayList<Person> allEmployees) {//print the list
		
		System.out.println("The list content:");
		System.out.println();

		for (int i = 0; i < allEmployees.size(); i++) {

			System.out.println(allEmployees.get(i).getClassName() + allEmployees.get(i).toString());

		}
		
	}

	public static String getType(Scanner scn) {// get the type of the employee
		
		
		System.out.println();
		System.out.print("[M/m], [W/w], [O/o]. [F/f] to finish: ");
		String type = scn.next().toUpperCase();
		System.out.println();
		while (!type.equalsIgnoreCase("m") && !type.equalsIgnoreCase("o") && !type.equalsIgnoreCase("w")
				&& !type.equalsIgnoreCase("f")) {
			System.out.println("Invalid type input, Please try again! \n " + "[M/m], [W/w], [O/o]. [F/f] to finish: ");
			scn = new Scanner(System.in);
			type = scn.nextLine().toUpperCase();
		}

		return type;
	}

	public static int costOfAllBonuses(ArrayList<Person> allEmployees) {// calculate the bonus of all owners 

		int ofAllBonuses = 0;
		for (int i = 0; i < allEmployees.size(); i++) {

			ofAllBonuses += allEmployees.get(i).getBonus();

		}

		return ofAllBonuses;

	}

	public static int costByType(String type, ArrayList<Person> allEmployees) { //calculate the cost of the type

		int cost = 0;

		for (int i = 0; i < allEmployees.size(); i++) {
			if ((allEmployees.get(i).getClassName()).startsWith(type)) {
				cost += allEmployees.get(i).getSalary() + allEmployees.get(i).getBonus();
						
				if (allEmployees.get(i) instanceof Owner ) {
					cost += Owner.BASE;
					
				}
			}

		}
		return cost;

	}

	public static boolean copmare(ArrayList<Person> allEmployees, int firstIndex, int secondIndex) { //compare between 

		boolean isEquals = allEmployees.get(firstIndex).equals(allEmployees.get(secondIndex));

		return isEquals;

	}

	public static void main(String[] args) {		
		
		Scanner scn = new Scanner(System.in);
		ArrayList<Person> allEmployees = null;

		try {
			allEmployees = insertIntoList(scn);

		printList(allEmployees);

		System.out.println();
		System.out.println("Cost of all bonuses = " + costOfAllBonuses(allEmployees));
		System.out.println();

		String type = "";
		do {
			System.out.println("Please type a character to get total cost by type:");
			scn = new Scanner(System.in);
			type = getType(scn);
			int cost = costByType(type, allEmployees);
			
			if (!type.equalsIgnoreCase("f"))
			System.out.println("Cost = " + cost);
			System.out.println();
			
		} while (!type.equalsIgnoreCase("f"));

		int firstIndex = 0;
		do {
			System.out.print("Please enter the first index in the list (-1 to finish): ");
			firstIndex = scn.nextInt();
			if (firstIndex != -1 && firstIndex < allEmployees.size()) {
				System.out.print("Please enter the second index in the list              : ");
				int secondIndex = scn.nextInt();
				System.out.println();
				boolean isEquals = copmare(allEmployees, firstIndex, secondIndex);
				if (isEquals)
					System.out.println("EQUALS !");
				else
					System.out.println("NOT EQUALS");
				
				System.out.println();
			}

		} while (firstIndex != -1);
		
		System.out.println();
		
		
		boolean start = logIn (scn ,allEmployees );
		ArrayList<Product> allProducts = new ArrayList<Product>() ;
		if(start) {
			System.out.println("------------------------------------------------------------------------------- \n "
					+ "Welcome to \"On-Click Hamburger\" Menu Creator \n"
					+ "-------------------------------------------------------------------------------\n" );
			
			Menu<Hamburger> myMenu = creatMenu();	
			userOption(scn,allProducts,myMenu );
		
		}
		} catch (BonusException e) {
			System.out.println();
			System.out.println(e.getMessage()+ "\n ");
			
		}catch(PriceExeption ex){
			System.out.println(ex.getMessage()+ "\n ");
		}
		
		System.out.println("Program ends now...");
		System.out.println("");
		scn.close();	
		
	}

	public static Menu<Hamburger> creatMenu() throws PriceExeption {
		
		Menu <Hamburger>myMenu = new Menu<Hamburger>();
		
		return myMenu;
		
	}
	
	private static void printOptions(ArrayList<Product> allProducts, Scanner scn, Menu<Hamburger> myMenu) throws PriceExeption { //print the options for the user
		
		System.out.println("-------------------------------------------------------------------------------\n"+"1. Create New Hamburger \n2. Delete Hamburger \n3. Add Hamburger To Menu \n4. Remove Hamburger From Menu \n"
				+ "5. Remove All Hamburgers From Menu \n6. Search Hamburger By Name And Price \n7. Print All Products \n8. Print Menu \n"
				+ "Choose your option or any other key to EXIT \n");
		System.out.println();
		
		
	}

	public static boolean logIn (Scanner scn ,ArrayList<Person> allEmployees ) { // user log in
		System.out.println("..............................................\n");
		System.out.println("*** System LogIn Option: ***");
		System.out.print("Please Enter UserName:");
		String UserName = scn.next();
		System.out.print("Please Enter Password:");
		String Password = scn.next();
		System.out.println();
		
		for (int i = 0; i < allEmployees.size() ; i++) {
			if (allEmployees.get(i).getUserName().equals(UserName)&& allEmployees.get(i).getPassword().equals(Password)) 
				return true;
		
			}
		return false;
	}
	
	private static void userOption(Scanner scn, ArrayList<Product> allProducts, Menu <Hamburger>myMenu) throws PriceExeption { //get input from user

		String option;
		int op;
		do {

			printOptions(allProducts, scn, myMenu);

			System.out.print("Your Option:");
			option = scn.next();
			if (option.length() >1 ) 
				break;
			
			op = option.charAt(0);
			System.out.println();

			switch (op) {
			case '1':
				Hamburger h = createHamburger(scn);
				myMenu.creatProduct(allProducts, h);
				System.out.println("Hunburger Created Successfully!\n");
				
				break;

			case '2':
				deleteHamburger(scn, allProducts, myMenu);

				break;

			case '3':
				addHamburger(scn, allProducts, myMenu);
				break;

			case '4':
				removeHamburger(scn, allProducts, myMenu);
				break;

			case '5':
				removeAll(scn, allProducts, myMenu);
				break;
				
			case '6':
				searchHamburger(scn, allProducts, myMenu);
				break;
				
			case '7':
				myMenu.print(allProducts);
				break;
				
			case '8':
				System.out.println("Menu [ Count: " + myMenu.getProducts().size() + " Total Price:" + myMenu.getTotalPrice() +"]\nResult:\n");
				myMenu.print(myMenu.getProducts());
				break;
			}

		} while (op > '0' && op < '9');
		
		System.out.println("Finished!");
	}

	private static void removeAll(Scanner scn, ArrayList<Product> allProducts, Menu<Hamburger> myMenu) { //remove all hamburgers from menu
		
		System.out.println("REMOVE ALL HAMBURGERS FROM MENU:");
		
		System.out.print("Are You Sure?(Y/N)");
		String ans = scn.next();
		System.out.println();
		if (ans.equalsIgnoreCase("y")) {
			myMenu.removeAll();
			System.out.println(" All Hamburgers removed Successfully! ");
		}else
			System.out.println("Operation Canceled!");
		
		
	}

	private static void deleteHamburger(Scanner scn, ArrayList<Product> allProducts, Menu<Hamburger> myMenu) throws PriceExeption {//delete hamburger from the list
		System.out.println("DELETE HAMBURGER:");
		String name= getName(scn);
		Number price = checkNum(scn);
		
		int index = myMenu.search(allProducts, name, price);
		if (index != -1) {
			Hamburger h = (Hamburger) (allProducts.get(index));
			System.out.println("Result:\n" +h.toString());
			System.out.print("Are You Sure?(Y/N)");
			String ans = scn.next();
			System.out.println();
			if (ans.equalsIgnoreCase("y")) {
				myMenu.delete(allProducts, index);
				System.out.println("Hamburger Deleted Successfully! ");
				
			}else
				System.out.println("Operation Canceled!");
		} else {
			System.out.println("Hamburger Not Found!");
		
		}
		System.out.println();
	}

	private static void searchHamburger(Scanner scn, ArrayList<Product> allProducts, Menu<Hamburger> myMenu) throws PriceExeption {// search the hamburger by name and price
		System.out.println("SEARCH HAMBURGER BY NAME AND PRICE:");
		String name= getName(scn);
		Number price = checkNum(scn);
		
		int index = myMenu.search(allProducts, name, price);
		if (index != -1) {
			Hamburger h = (Hamburger) (allProducts.get(index));
			System.out.println("Result:\n"+ h.toString());}
		else {
			System.out.println("Hamburger Not Found!");
		}
		System.out.println();
	}

	private static void removeHamburger(Scanner scn, ArrayList<Product> allProducts, Menu<Hamburger> myMenu) throws PriceExeption {//remove hamburger from menu

		System.out.println("REMOVE HAMBURGER FROM MENU:");

		String name = getName(scn);
		Number price = checkNum(scn);

		int index = myMenu.search(myMenu.getProducts(), name, price);
		if (index != -1) {
			Hamburger h = (Hamburger) (allProducts.get(index));
			System.out.println("Result:\n" + h.toString());
			System.out.print("Are You Sure?(Y/N)");
			String ans = scn.next();
			System.out.println();
			if (ans.equalsIgnoreCase("y")) {
				myMenu.remove(index);
				System.out.println("Hamburger Removed Successfully! ");
			} else
				System.out.println("Operation Canceled!");
		} else {
			System.out.println("Hamburger Not Found!");
		}
		System.out.println();
	}

	private static void addHamburger(Scanner scn, ArrayList<Product> allProducts, Menu<Hamburger> myMenu) throws PriceExeption {// add the hamburger to menu
		
		System.out.println("ADD HAMBURGER TO MENU:");
		
		String name = getName(scn);
		Number price = checkNum(scn);

		int index = myMenu.search(allProducts, name, price);
		if (index != -1) {
			Hamburger h = (Hamburger) (allProducts.get(index));
			System.out.println("Result:\n"+h.toString() );
			System.out.print("Are You Sure? (Y/N)");
			String ans = scn.next();
			System.out.println();
			if (ans.equalsIgnoreCase("y")) {
				myMenu.add(h);
				System.out.println("Hamburger Added Successfully! ");
			}else
				System.out.println("Operation Canceled!");
		} else {
			System.out.println("Hamburger Not Found!");
		}
		System.out.println();
	}

	private static Hamburger createHamburger(Scanner scn) throws PriceExeption {// create new hamburger
		System.out.println("CREATE NEW HAMBURGER: ");
		
		String name= getName(scn);
		Number price = checkNum(scn);
		if (price.doubleValue() <0) 
			 throw new PriceExeption ("Illegal Price Input Exception!");
		
		
		System.out.print("Please Enter Ingredients Info:");
		String ingredients= scn.nextLine();
		System.out.println();
		System.out.print("Please Enter Degree Of Doneness(RARE|MEDIUM|MEDIUMWELL|WELLDONE):");
		String doneness = scn.nextLine();
		System.out.println();
		Hamburger h = new Hamburger( name, price, doneness, ingredients);
		
		
		return h;
	}
	
	private static String getName(Scanner scn) {
		System.out.print("Please Enter Name :");
		String name= scn.next()+ scn.nextLine();;
		System.out.println();
		
		return name;
		
	}
	
	private static Number checkNum(Scanner scn) throws PriceExeption {
		System.out.print("Please Enter Price :");
		String input = scn.next()+ scn.nextLine();
		System.out.println();
		Number price;
		
		
		try {
			price = Integer.parseInt(input);

		} catch (NumberFormatException e) {
			try {
				price = Double.parseDouble(input);
			} catch (NumberFormatException ex) {
				price= -1; 
			}
		}
		return price;
	}
		

}


public abstract class Person {

	protected String name;
	
	
	public int getBonus() {
		return 0;
	}

	public int getSalary() {
		int salary = 0;
		return salary;
	}
	
	public int getBASE() {
		return 0;
		
	}
	
	public String toString() {
		return " " +name +",   ";
	}

	//public String getClassType() {
	//	return "P";
		
	//}
	
	public String getClassName() {
		return "Person";
		
	}
	
	@Override
 	public boolean equals (Object p) {
		return false;
		
	}


	public abstract String getUserName();
	public abstract String getPassword();

}

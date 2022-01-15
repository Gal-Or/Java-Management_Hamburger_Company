
public class Worker extends Person {

	private int salary;
	private String UserName;
	private String Password;

	public Worker(String name, int salary, String UserName,String Password ) {
		this.salary = salary;
		this.name= name;
		this.UserName = UserName;
		this.Password = Password;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public int getSalary() {
		
		return this.salary;
	}

	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return super.toString() + getSalary();

	}
	 @Override
	public String getClassName() {
		return "Worker :";
		
	}
	

	@Override
	public boolean equals (Object p) {
		
		if(p instanceof Worker && !(p instanceof Manager)) {
			
			if(this.getSalary() == ((Worker)p).getSalary() ) {
				return true;
			}
		}
		
		
		return false;
		
	}

	

}




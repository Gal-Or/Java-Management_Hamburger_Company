
public class Manager extends Worker {

	private int bonus;

	public Manager(String name, int salary, int bonus ,String UserName,String Password) {
		super(name, salary, UserName ,Password);
		this.bonus = bonus;

	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString() + " + "+ getBonus();
	}

	

	
	@Override
	public String getClassName() {
		return "Manager:";
		
	}
	
	@Override
	public boolean equals(Object p) {

		if (p instanceof Manager && !(p instanceof Owner)) {

			if (this.getSalary() + this.getBonus() == ((Manager) p).getSalary() + ((Manager) p).getBonus()) {
				return true;
			}
		}

		return false;

	}
}

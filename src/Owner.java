
public class Owner extends Manager {

	public static final int BASE = 20_000;

	public Owner(String name, int salary, int bonus, String UserName, String Password) throws BonusException {

		super(name, salary, bonus, UserName, Password);
		if (bonus > 10000)
			throw new BonusException();

	}

	@Override
	public String toString() {
		return super.toString() + " + " + BASE;
	}

	
	
	@Override
	public String getClassName() {
		return "Owner  :";
		
	}
	
	
	
	@Override
	public boolean equals(Object p) {

		if (p instanceof Owner ) {

			if (this.getSalary() + this.getBonus() == ((Manager) p).getSalary() + ((Manager) p).getBonus()) {
				return true;
			}
		}

		return false;

	}
}



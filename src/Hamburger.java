
public class Hamburger extends Product {

	public enum eDoneness { RARE , MEDIUM , MEDIUMWELL , WELLDONE };
	private eDoneness Doneness;
	private String Ingredients ;
	
	public Hamburger(String name, Number price, String doneness, String ingredients) throws PriceExeption {
		super(name, price);
		Doneness = eDoneness.valueOf(doneness.toUpperCase());
		Ingredients = ingredients;
	}
	@Override
	public String toString() {
		return "	Hamburger" + super.toString() + Ingredients ;
	}
	
	public eDoneness getDoneness() {
		return Doneness;
	}

	public void setDoneness(eDoneness doneness) {
		Doneness = doneness;
	}

}


public  abstract class Product implements FuncProduct  {

	protected String name;
	protected Number price;
	
	
	public void setPrice(Number price) throws PriceExeption {

		if (price.doubleValue() <0) {
			throw new PriceExeption("Illegal Price Input Exception!");
		}
		this.price = price;
	}

	public Product(String name, Number price) throws PriceExeption {
		super();
		this.name = name;
		setPrice(price);
	}

	@Override
	public String toString() {
		return "	" + name+ "		" + price + "		";
	}

	public int compareTo(Product p) {
		if (this.name.compareToIgnoreCase(p.name) < 0)
			return -1;
		if (this.name.compareToIgnoreCase(p.name) > 0)
			return 1;
		else {
			if (this.price.doubleValue() < p.price.doubleValue())
				return -1;
			if (this.price.doubleValue() > p.price.doubleValue())
				return 1;
			else
				return 0;

		}

	}
	
	@Override
	public Product clone() throws CloneNotSupportedException {
		
		return ( Product ) super.clone(); 
		
	}
}

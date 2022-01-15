import java.util.ArrayList;
import java.util.Collections;

public class Menu<T extends Product> implements FuncMenu<T> {

	
	private ArrayList<T> Products;
	private double totalPrice;

	public ArrayList<T> getProducts() {
		return Products;
	}

	public Menu() {
		Products = new ArrayList<T>();
		
	}

	public <E extends Number,K extends Number> double getSum(E num1, K num2) {

		return num1.doubleValue() + num2.doubleValue();

	}

	@Override
	public void creatProduct(ArrayList<Product> list, T product) {
		list.add(product);
		
	}

	@Override
	public void delete(ArrayList<Product> list, int index) {
		list.remove(index);
		
	}

	@Override
	public void add(T product) {
		this.Products.add(product);
	}

	@Override
	public void addAll(ArrayList<? extends Product> list1, ArrayList<? super Product> list2) {
		list2.addAll(list1);

	}

	@Override
	public void remove(int index) {
		this.Products.remove(index);

	}

	@Override
	public void removeAll() {
		this.Products.removeAll(Products);

	}

	@Override
	public void print(ArrayList<? extends Product> list) {
		
//		System.out.println("Menu [ Count: " + list.size() + " Total Price:" + getTotalPrice() +"]\nResult:\n");
		for (int i = 0; i < list.size(); i++) {
		
			System.out.println(list.get(i).toString());
		}
		if (list.size()==0) {
			System.out.println("    The Menu Is Empty!");
		}
		System.out.println();
	}

	@Override
	public void sort(ArrayList<? extends Product> list) {

		Collections.sort(list);

	}

	@Override
	public int search(ArrayList<? extends Product> list, String name, Number price) throws PriceExeption {
		
		sort(list);
		if (price.doubleValue() < 0)
			price = 0;

		int index = -1;
		int low = 0, high = list.size() - 1 , middle, tempAnswer;
		while (low <= high) {

			middle = (low + high) / 2;
			tempAnswer = list.get(middle).name.compareTo(name);
			
			if (tempAnswer == 0) {
				index = middle;
				if (list.get(middle).price.doubleValue() == price.doubleValue()) {
					return index;
				} else if (list.get(middle).price.doubleValue() < price.doubleValue()) {
					low = middle + 1;
				} else {
					high = middle - 1;

				}

			} else if (tempAnswer < 0) {
				low = middle + 1;

			} else {
				high = middle - 1;
			}
		}

		return index;
	}

	public  double getTotalPrice() {
		
		totalPrice=0;
		
		for (int i = 0; i < Products.size(); i++) {
			totalPrice += Products.get(i).price.doubleValue();
		}
		return totalPrice;
		
	}
	
}

import java.util.ArrayList;

public interface FuncMenu <T extends Product >{

	 void creatProduct(ArrayList<Product> list, T product);

	void delete(ArrayList<Product> list, int index);

	void add(T product);

	void addAll(ArrayList<? extends Product> list1, ArrayList<? super Product> list2);

	void remove(int index);

	void removeAll();

	void print(ArrayList<? extends Product> list);

	void sort(ArrayList<? extends Product> list);

	int search(ArrayList<? extends Product> list, String name, Number price) throws PriceExeption;

	
	
}

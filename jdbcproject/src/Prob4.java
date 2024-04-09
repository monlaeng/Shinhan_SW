import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Prob4 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Product[] prodList = {
				new Product("NT450R5E-K24S",500000,"삼성전자"),
				new Product("15UD340-LX2CK",400000,"LG전자"),
				new Product("G2-K3T32AV",600000,"HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		
		makeFile(product_hs);
		readFile();
		
	}

	
	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		//구현하시오...return값 수정하기 
		HashSet<Product> set = new HashSet<Product>();
		for(int i = 0; i <prodList.length; i++) {
			if(prodList[i].getPrice() >= price) {
				set.add(prodList[i]);
			}
		}
		System.out.println("*특정 금액 이상의 상품 결과입니다.****************");
		for(Product el : set) {
			System.out.println(el);
		}
		return set;
	}


	private static void makeFile(HashSet resultList) throws IOException  {
		//구현하시오.
		FileOutputStream fos = new FileOutputStream("src/data.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		 
		for(Object el : resultList) {
			oos.writeObject(el);
		}
		oos.close();
		
	}
	private static void readFile() throws IOException, ClassNotFoundException  {
		//구현하시오. 

		try (FileInputStream fis = new FileInputStream("src/data.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			System.out.println("*readFile결과입니다****************");
			while (ois != null) {
				System.out.println((Product) ois.readObject());

			}
		} catch (EOFException e) {

		}
		
		

	}

}


class Product implements Serializable{
	private String model_name;
	private int price;
	private String company;
	
	
	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price
				+ ", company=" + company + "]";
	}
	
	

}
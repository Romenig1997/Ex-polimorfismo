import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data");
			System.out.print("Common, used or imported (c/u/i)? ");
			char op = sc.next().charAt(0);
			
			if(op == 'i') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee:");
				double customsFee = sc.nextDouble();
				
				 ImportedProduct imported = new ImportedProduct(name, price, customsFee);
				 list.add(imported);
			}
			else if(op == 'u') {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufactured date (DD/MM/YYYY): ");
				Date manufacturedDate = sdf.parse(sc.next());
				
				 UsedProduct used = new UsedProduct(name, price, manufacturedDate);
				 list.add(used);
			}
			else if(op == 'c'){
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				
				Product product = new Product(name, price);
				list.add(product);				
			}
		
			}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product product : list) {
			System.out.println(product.priceTag());
		}
		
		
		sc.close();

	}

}

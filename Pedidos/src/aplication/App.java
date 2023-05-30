package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Cliente Data: ");
		System.out.println("Name: ");
		String name = scan.nextLine();
		System.out.println("Email: ");
		String email = scan.next();
		System.out.println("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(scan.next());
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter Order Data: ");
		System.out.println("Status: ");
		String status = scan.next();
		System.out.println("How many items to this order?: ");
		int n = scan.nextInt();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		for (int i = 0 ; i < n ; i++) {
			System.out.println("Enter Item Data: ");
			System.out.println("Product name: ");
			scan.nextLine();
			String productName = scan.nextLine();
			System.out.println("Product price: ");
			double productPrice = scan.nextDouble();
			System.out.println("Quantity: ");
			int itemQuantity = scan.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(itemQuantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		scan.close();
	}
}

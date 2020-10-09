import java.util.Scanner;

public class Cheese {

	private String name;
	private double price;
	private double amount;

	public static int numCheese = 0;

	public Cheese() { // Constructor with no parameters
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name) { // Constructor with name as paramter
		this.name = name;
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name, double price) { // Constructor with 2 parameters
		this.name = "";
		price = 0; 
		amount = 0;
		numCheese++;
	}

	public String getName() { // Accessor
		return name;
	}

	public void setName(String newName) { // Mutator 
		name = newName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		price = newPrice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(Scanner input) {
		amount = input.nextDouble();
		do {
			if (amount % 0.5 != 0) {
				System.out.println("Invalid input. Enter a value that's multiple of 0.5: ");
				amount = input.nextDouble();
			}
			if(amount < 0) {
				System.out.println("Invalid input. Enter a value >= 0: ");
				amount = input.nextDouble();
			} 
		} while (amount%0.5 != 0 || amount<0);

	}
}


import java.util.*;

public class ShopArr {

	// Instance Variables
	private Cheese[] cheese;

	// Initialize method
	private void init(int max) {

		// Create max number of Cheese pointers
		cheese = new Cheese[max]; 

		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Humboldt Fog");
			cheese[0].setPrice(25.00);

			if (max > 1) {
				cheese[1] = new Cheese();
				cheese[1] = new Cheese("Red Hawk");
				cheese[1].setPrice(40.50);

				if (max > 2) {
					cheese[2] = new Cheese();
					cheese[2] = new Cheese("Teleme");
					cheese[2].setPrice(17.25);	
					//cheese[2].setName("Wrong Name");
				}
			}
		}

		Random ranGen = new Random(100);

		for (int i = 3; i < cheese.length; i++) {
			// Fill-in Code
			cheese[i] = new Cheese();
			cheese[i].setName("Cheese Type " + (char)('A' + i));
			cheese[i].setPrice(ranGen.nextInt(1000)/100.0);
		}

	}

	public ShopArr() {
		init(10);
	}

	public ShopArr(int max) {
		// Fill-in Code
		init(max);
	}

	/*
	 * Displays the intro message informing the user of various cheeses sold and
	 * Gets the amount of each cheese the user would like to purchase. 
	 */
	private void intro(Scanner input) {

		System.out.println("We sell " + cheese.length + " kinds of Cheese (in 0.5 lb packages)");

		// Fill-in Code
		if (cheese.length > 0)	
			System.out.println(cheese[0].getName() + ": $" + cheese[0].getPrice() + " per pound");
		if (cheese.length > 1)
			System.out.println(cheese[1].getName() + ": $" + cheese[1].getPrice() + " per pound");
		if (cheese.length > 2)
			System.out.println(cheese[2].getName() + ": $" + cheese[2].getPrice() + " per pound");
		for(int i = 3; i < cheese.length; i++) {
			System.out.println(cheese[i].getName() + ": $" + cheese[i].getPrice() + " per pound");
		}

		System.out.println();

		if (cheese.length > 0) {
			System.out.print("Enter the amount of " + cheese[0].getName() + " in lb: ");
			cheese[0].setAmount(input); 
		}
		if (cheese.length > 1) {
			System.out.print("Enter the amount of " + cheese[1].getName() + " in lb: ");
			cheese[1].setAmount(input);
		}
		if (cheese.length > 2) {
			System.out.print("Enter the amount of " + cheese[2].getName() + " in lb: ");
			cheese[2].setAmount(input);
		}
		for (int i = 3; cheese.length > i; i++) {
			System.out.print("Enter the amount of " + cheese[i].getName() + " in lb: ");
			cheese[i].setAmount(input);
		}

	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	private void itemizedList(){
		double amt = 0, price = 0;

		// Fill-in Code	
		for (int i = 0; cheese.length > i; i++) {
			amt += cheese[i].getAmount();
		}
		if (amt == 0) {
			System.out.println("No items were purchased.");
		}
		else {
			if (amt != 0) {
				for (int i = 0; cheese.length > i; i++) {
					price = cheese[i].getPrice();
					if (cheese[i].getAmount() != 0) {
						System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", cheese[i].getAmount(), cheese[i].getName(), cheese[i].getPrice(), cheese[i].getPrice()*cheese[i].getAmount());	
					}
				}	
			}
		}
	}


	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	private double calcSubTotal() {
		double subTotal = 0;
		// Fill-in Code
		for (int i = 0; i < cheese.length; i++) {
			subTotal = subTotal + (cheese[i].getAmount()*cheese[i].getPrice());
		}
		return subTotal;
	}

	/*
	 * Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 * stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 * Minor changes from Lab 07 (identical logic). 
	 */
	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};

		if (cheese.length > 0) {
			double hfAmt = cheese[0].getAmount();
			if (hfAmt > 0) {
				disSpecials[0] = ((int)(hfAmt)*cheese[0].getPrice())/2;
			}

			if (cheese.length > 1) {
				double rhAmt = cheese[1].getAmount();
				if(rhAmt > 0) {
					for (double i = rhAmt; i > 1; i -= 1.5){
						disSpecials[1] += 0.5;
						disSpecials[1] = disSpecials[1] * cheese[1].getPrice();
					}

				}


			}

		}

		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total. Identical to Lab 07.
	 */
	private double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix code
		System.out.println("\nOriginal Sub Total:\t\t  $" + subTotal);
		System.out.println("Specials...");
		if(disSpecials[0] == 0 && disSpecials[1] == 0) {
			System.out.println("None\t\t\t\t -$0.0");
		}
		if(disSpecials[0] > 0) {
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + disSpecials[0]);
		}
		if(disSpecials[1] > 0) {
			System.out.println("Red Hawk (Buy 2 Get 1 Free):\t -$" + disSpecials[1]);
		}
		subTotal = (subTotal - (disSpecials[0] + disSpecials[1]));
		System.out.println("New Sub Total:\t\t\t  $" + subTotal);
		return subTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total. Identical to Lab 07.
	 */
	private void printFinalTotal(double newSubTotal) {
		// Fill-in code
		if(newSubTotal > 250) {
			System.out.println("Additional 15% Discount:\t -$" + (newSubTotal * 0.25));
			newSubTotal = newSubTotal - (newSubTotal*0.25);
		}
		else if(newSubTotal > 150) {
			System.out.println("Additional 10% Discount:\t -$" + (newSubTotal * 0.10));
			newSubTotal = newSubTotal - (newSubTotal*0.10);
		}
		else if(newSubTotal < 150) {
			System.out.println("Additional 0% Discount:\t\t -$0.00");
			newSubTotal = newSubTotal - (newSubTotal*0);
		}
		System.out.print("Final Total:\t\t\t  $" + newSubTotal);
		System.out.println();

	}

	private void printFree(){
		double amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++) 		
			if ((amt = cheese[i].getAmount()) > 0)
				System.out.println(amt + " lb of " + cheese[i].getName() + " @ $0 = $" + 0);
		System.out.println("Total Price: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();

		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	

		int free = (new Random()).nextInt(100);
		//System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}

		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
}

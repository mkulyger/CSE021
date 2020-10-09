import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/* 
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */
	public static void intro(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		Random ranGen = new Random(100);
		
		if (amounts.length > 0) {
		names[0] = "Humboldt Fog";
		prices[0] = 25.0;
		
		if (amounts.length > 1) {
		names[1] = "Red Hawk";
		prices[1] = 40.50;
		}		
		
		if (amounts.length > 2) {
		names[2] = "Teleme";
		prices[2] = 17.25;
		}	
	}
	
	System.out.println();
	System.out.println("We sell " + amounts.length + " kinds of Cheese (in 0.5 lb packages)");
	
	System.out.println(names[0] + ": $" + prices[0] + " per pound");
	if (names.length > 1)
		System.out.println(names[1] + ": $" + prices[1] + " per pound");
	if (names.length > 2)
		System.out.println(names[2] + ": $" + prices[2] + " per pound");	
	for (int i = 3; names.length > i; i++) {
		names[i] = "Cheese Type " + (char) ('A' + i);
		prices[i] = ranGen.nextInt(1000) / 100.0;
		amounts[i] = 0;
		System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}
	System.out.println();
	}
	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		// Fill-in
		
		for (int i = 0; names.length > i; i++) {
			System.out.println("Enter the amount of " + names[i] + ":");
				amounts[i] = sc.nextDouble();
		do {		
			if(amounts[i] < 0) {
			    System.out.println("Invalid input. Enter a value >= 0:");
			    amounts[i] = sc.nextDouble();
		}
			  else if(amounts[i] % 0.5 != 0) {
			     System.out.println("Invalid input. Enter a value that's multiple of 0.5:");
			     amounts[i] = sc.nextDouble();     
			   }
		} while (amounts[i] < 0 || amounts[i] % 0.5 != 0);
	}	
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		for (int i = 0; names.length > i; i++) {
			if (amounts[i] > 0) {
		System.out.println(amounts[i] + " lbs of " + names[i] + " @ $" + prices[i] + " = $" + prices[i]*amounts[i]); 
			}
		/*	if (amounts[i] == 0) {
		System.out.println("No items were purchased.");
		return;
			} */
		}
	}
	
	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		// Fix

	double subTotal	= 0;
	for (int i = 0; amounts.length > i; i++) {
		subTotal = prices[i] * amounts[i] + subTotal;
	}
	return subTotal;
	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		// Fix
		double[] disSpecials = new double[amounts.length];
		
		if (amounts.length > 0) {
		 
		if (amounts[0] > 0) {
		double HFamount = amounts[0]/0.5;
		double HFPackDis = (int)HFamount/2;
		double discount = HFPackDis*0.5; 
		disSpecials[0] = discount*prices[0];
		}
		
		double RHamount = 0;
		if (amounts[1] > 1)
		RHamount = amounts[1]/0.5;
		double RHPackDis = (int)(RHamount/3); 
		double redDiscount = RHPackDis*0.5;
		disSpecials[1] = redDiscount*prices[1]; 		
	}
		return disSpecials;
		}
		

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix
		
		System.out.println();
		System.out.println("Original Sub Total:\t\t  $" + subTotal);
		
		System.out.println("Specials...");
		if (disSpecials[0] == 0 && disSpecials[1] == 0) {
		System.out.println("None \t\t\t\t -$0.0");
		}
	
		if (disSpecials[0] > 0) {
		System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + disSpecials[0]);
		}
		if (disSpecials[1] > 0) {
		System.out.println("Red Hawk (Buy 2 Get 1 Free):\t -$" + disSpecials[1]);
		}
		
		double newSubTotal = 0;
		newSubTotal = subTotal - (disSpecials[0] + disSpecials[1]);
		System.out.println("New Sub Total:\t\t\t  $" + newSubTotal);
		
		return newSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		// Fill-in
		double AddDisc = 0;
		if (newSubTotal >= 250) {
			AddDisc = (newSubTotal * 0.25);
			System.out.println("Additional 25% Discount:\t -$" + AddDisc);
		}else if (newSubTotal >= 150) {
			AddDisc = (newSubTotal*0.10);
			System.out.println("Additional 10% Discount:\t -$" + AddDisc);
		}else 
			System.out.println("Additional 0% Discount:\t\t -$0.0");		
		
		double finTot = newSubTotal - AddDisc;
		
		System.out.println("Final Total:\t\t\t  $" + finTot);
	}
	
	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();
		System.out.println();
		
		if (MAXCHEESE == 0) {
			System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages)");
			System.out.println();
			System.out.println("Original Sub Total: \t  $0.00");
			System.out.println("Specials...\nNone\t\t\t -$0.0");
			System.out.println("New Sub total:\t\t  $0.00");
			System.out.println("Additional 0% Discount:\t -$0.0");
			System.out.println("Final Total:\t\t  $0.00");
			return;
		}
		
		
		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		sc.close();
	}
}
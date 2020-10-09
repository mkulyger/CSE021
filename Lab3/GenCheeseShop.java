import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner keyboard = new Scanner(System.in);
	Random ranGen = new Random(100);
	
	int MAXCHEESE = 10;
	double total = 0, NewOriSub = 0, AddDisc = 0,
	discount = 0, finTot = 0;
	
	//Humboldt Fog
	double HFamount = 0, HFDisc = 0, HFTot = 0, HFPackDis = 0;
	
	//Red Hawk
	double RHamount = 0, RHDisc = 0, RHTot = 0, RHPackDis = 0,
			redDiscount = 0; 
	
	String[] names = new String[MAXCHEESE];
	double[] prices = new double[MAXCHEESE];
	double[] amounts = new double[MAXCHEESE];

	System.out.print("Enter the number of Cheeses for shop setup: ");
	MAXCHEESE = keyboard.nextInt();
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
	
	
	// Special 3 Cheeses
		if (MAXCHEESE > 0) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.0;
		
		if (MAXCHEESE > 1) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
		}
		if (MAXCHEESE > 2) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}
	}

	System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages)");
	System.out.println(names[0] + ": $" + prices[0] + " per pound");

/*	if (MAXCHEESE == 0) {
		System.out.println("New Sub total:\t\t  $0.00");
		System.out.println("Additional 0%:\t\t -$0.0");
		System.out.println("Total:\t\t\t  $0.00");
	} */
	
	if (MAXCHEESE > 1)
		System.out.println(names[1] + ": $" + prices[1] + " per pound");
	if (MAXCHEESE > 2)
		System.out.println(names[2] + ": $" + prices[2] + " per pound");	

	for (int i = 3; i < MAXCHEESE; i++) {
		names[i] = "Cheese Type " + (char) ('A' + i);
		prices[i] = ranGen.nextInt(1000) / 100.0;
		amounts[i] = 0;
		System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}
		
	System.out.println();
	
	for (int i = 0; i < MAXCHEESE; i++) {
		System.out.println("Enter the amount of " + names[i] + ":");
			amounts[i] = keyboard.nextDouble();
	do {		
		if(amounts[i] < 0) {
		    System.out.println("Invalid input. Enter a value >= 0:");
		    amounts[i] = keyboard.nextDouble();
	}
		  else if(amounts[i]%0.5 != 0) {
		     System.out.println("Invalid input. Enter a value that's multiple of 0.5:");
		     amounts[i] = keyboard.nextDouble();     
		   }
	} while (amounts[i] < 0 || amounts[i] % 0.5 != 0);
		
	total = total + (amounts[i]*prices[i]);
}
	
	System.out.println();

	System.out.print("Display the itemized list? (1 for yes) ");
		int list = keyboard.nextInt();
	
		if (list == 1) {
		for (int i = 0; i < MAXCHEESE; i++) {
			if (amounts[i] > 0)
		System.out.println(amounts[i] + " lbs of " + names[i] + " @ " + prices[i] + " = $" + prices[i]*amounts[i]); 
		}
	}

		System.out.println();
		System.out.println("Original Sub Total:\t\t  $" + total);
		
		System.out.println("Specials...");
		if (amounts[0] == 0 && amounts[1] == 0) {
		System.out.println("None \t\t\t\t -$0.0");
		}
		
		if (MAXCHEESE > 0) {
	//Humboldt Fog Pricing
	if (amounts[0] > 0)	{
		HFamount = amounts[0]/0.5;
		HFPackDis = (int)HFamount/2;
		discount = HFPackDis*0.5; 
		HFDisc = discount*prices[0]; 
	System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + HFDisc);
		}
	
	//Red Hawk Pricing
	if (amounts[1] > 0) {
		RHamount = amounts[1]/0.5;
		RHPackDis = (int)(RHamount/3); 
		redDiscount = RHPackDis*0.5;
		RHDisc = redDiscount*prices[1]; 
		System.out.println("Red Hawk (Buy 2 Get 1 Free):\t -$" + RHDisc);
	}
	
		NewOriSub = (total - (HFDisc + RHDisc));
		System.out.println("New Sub Total:\t\t\t  $" + NewOriSub);
		
		if (NewOriSub >= 250) {
			AddDisc = (NewOriSub * 0.25);
			System.out.println("Additional 25% Discount:\t -$" + AddDisc);
		}else if (NewOriSub >= 150) {
			AddDisc = (NewOriSub*0.10);
			System.out.println("Additional 10% Discount:\t -$" + AddDisc);
		}else 
			System.out.println("Additional 0% Discount:\t\t -$0.0");		
		
		finTot = NewOriSub - AddDisc;
		
		System.out.println("Final Total:\t\t\t  $" + finTot);
	}
		
	
}
}
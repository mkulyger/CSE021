import java.util.Scanner;

public class Shop {

	public static String numSuffix(int i) { 
		  int rem = i % 10;   
		  switch (rem) {    
		  	case 0:    
		  	case 4:    
		  	case 5:
		  	case 6:
		  	case 7:   
		  	case 8:  
		  	case 9:
			  return (i + "th");    
		  case 1:     
			  if (i % 100 != 11)      
				  return (i + "st");     
			  else      
				  return (i + "th");    
		  case 2:    
			  if (i % 100 != 12)      
				  return (i + "nd");     
			  else      
				  return (i + "th");    
		  case 3:     
			  if (i % 100 != 13)      
				  return (i + "rd");     
			  else      
				  return (i + "th");    
		default:     
			break;   
			}   
		  return "";  
		 } 
	
	static double discount1 = 0;
	static double discount2 = 0;
	static double name = 0;
	
//I. Set Shop
public static int Setup(Scanner sc, String[] names, double[] prices, double[] DiscPack) { 		
	
	System.out.println("Please enter the number of items to setup shop: ");	
	  	int items = sc.nextInt(); //1
	  		
	System.out.println();
	
	 //2
	for (int i = 0; items > i; i++){
	 	System.out.print("Enter the name of the " + numSuffix(i + 1) + " product: ");
	  	names[i] = sc.next();
	  	
	  	System.out.print("Enter the per package price of " + names[i] + ": ");
	  	prices[i] = sc.nextDouble();
	  
	  	System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free) for " + names[i]+ ", or 0 if no Special Discount offered: ");
	  	DiscPack[i] = sc.nextDouble();
	  	System.out.println();
	  	
	  }

	System.out.println();
	
	 //3
	System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
	discount1 = sc.nextDouble();

	
	if(discount1 != 0) {
		System.out.print("Please enter the discount rate (0.1 for 10%): ");
	
	do {
		discount2 = sc.nextDouble();
	
	if (discount2 <= 0 || discount2 > 0.5) {
		System.out.println("Invalid input. Enter a value > 0 and <= 0.5: ");
		} 
	} while (discount2 <= 0 || discount2 > 0.5);	
	System.out.println();
	System.out.println();
	}
	return items;
	 
}	  
	

//II. Buy Items
public static void Buy(Scanner sc, String[] names, double[] prices, int[] amounts, int items) {
	
	for (int i = 0; items > i; i++) {
		System.out.print("Enter the number of " + names[i] + " packages to buy: ");
		amounts[i] = sc.nextInt();
		
		do {		
			if(amounts[i] < 0) {
			    System.out.println("Invalid input. Enter a value >= 0:");
			    amounts[i] = sc.nextInt();
		}
		} while (amounts[i] < 0);
	}
}


//III. List Items
public static void ListItems(String[] names, double[] prices, int[] amounts, int products) {
	for (int i = 0; products > i; i++) {
		if (amounts[i] > 0) {
			System.out.println(amounts[i] + " packages of " + names[i] + " @ $" + prices[i] + " per pkg = $" + (amounts[i]*prices[i]));
		}
	}
System.out.println();
}


//IV. Check Out
public static void Checkout(double[] prices, int[] amounts) {
	double total = 0; 
	double allDisc = 0;
	
	for(int i = 0; amounts.length > i; i++) {
		total += prices[i]*amounts[i];
	}
	
	allDisc = total*discount2;
	
	if (total >= discount1) {
		System.out.println();
		System.out.println("Original Sub Total:\t$" + total);
		
		if (total >= discount1) {
			System.out.println("Discount:\t-$" + allDisc);
		}else if (total < discount1) {
			System.out.println("No Special Discount was applied.");
		}
	
	System.out.println("New Subtotal:\t\t$" + (total - allDisc));
	}
	
	if (discount2 >= (total - allDisc)) {
		System.out.println("You did not qualify for an additional discount.");
	}
	else {
		System.out.println("Additional " + (int)(discount2 * 100) + "% Discount:   -$" + (total - allDisc)*discount2);
	}
	System.out.println("Final Sub Total:\t$" + ((total - allDisc) - (total - allDisc)*discount2));
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner sc = new Scanner(System.in);
		
	final int MAX = 100;
	int products = 0;
	int function = 0;
	int setup = 0;
	int buy = 0;
	int exit = 0; 
	int repeat = 0;
	
	String[] names = new String[MAX];
	int[] amounts = new int[MAX];
	double[] prices = new double[MAX];
	double[] DiscPack = new double[MAX];
	
	
	do {
		System.out.println("This program supports 4 functions: ");
		System.out.println("\t1. Set Up Shop");
		System.out.println("\t2. Buy");
		System.out.println("\t3. List Items");
		System.out.println("\t4. Checkout");
		System.out.print("Please choose the function you want: ");
		function = sc.nextInt(); 
		
	if (function >= 1 || function >= 4) {
		if (function == 1) {
			if (setup == 0) {
				products = Setup(sc, names, prices, DiscPack);
			}
	setup = 1; 
}
		if (function == 2) {
			if (setup == 1) {
				System.out.println();
				Buy(sc, names, prices, amounts, products);
			}
			else {
				System.out.println();
				System.out.println("Shop is not setup yet!");
				System.out.println();
			}
	buy = 1;
}
		if (function == 3) {
			if (buy == 1) {
				System.out.println();
				ListItems(names, prices, amounts, products);
				System.out.println();	
			}
		if (setup == 1 && buy == 0) {
			System.out.println();
			System.out.println("You have not bought anything");
			System.out.println();
	}
		if (setup == 0) {
			System.out.println();
			System.out.println("Shop is not setup yet!");
			System.out.println();
		}
			}
		if (function == 4) {
			if (setup == 0) {
				System.out.println();
				System.out.println("Shop is not setup yet!");
				System.out.println();
				continue;
		}
			if (buy == 0) {
				System.out.println();
				System.out.println("Try again: You have not bought anything");
				System.out.println();
				continue;
		}
			if (buy == 1) {
				Checkout(prices, amounts);
				break;
			}
		}
	
		else if (function > 4) {
			System.out.println();
			System.out.println("Error: Do not know " + function);
			System.out.println();
	}
		if (function == 4 && buy == 1) {
			exit = 1;
		}
	}
		} while (function != 4 && exit == 0);
	
	System.out.println("Thanks for coming!");
	
	System.out.println();
	
	System.out.println("Would you like to re-run (1 for yes, 0 for no)?");
	repeat = sc.nextInt();
	
	if (repeat == 1) {
		main(args);
	}
		
	else {
	
	}

}
}

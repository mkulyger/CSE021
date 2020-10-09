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
		case 2:
			if (i % 100 != 12)
				return (i + "nd");
			else
				return(i + "th");
		case 3:
			if (i % 100 != 13)
				return (i + "rd");
			else
				return(i +"th");
		default:
			break;
		}
		return "";
	}


	static double dis1 = 0;
	static double dis2 = 0;
	static double names = 0;


	//Setup Shop (I)
	public static int Setup(Scanner input, String[] names, double[]prices, double[] disPkg) {
		System.out.print("Please enter the number of items to setup shop:"); 
		int Numitems = input.nextInt();
		System.out.println();
		
		for (int i = 0; i < Numitems; i++){ 

			System.out.print("Enter name of the " + (numSuffix(i+1)) + " product: "); 
			names[i] = input.next(); 

			System.out.print("Enter per package price of " + names[i] + ": ");
			prices[i] = input.nextDouble();	
			

			System.out.println("Enter the number of packages ('x') to qualify for Special Discount ");
			System.out.print("(buy 'x' get 1 free) for " + names[i] + ", or 0 if no Special Discount offered: ");
			disPkg[i] = input.nextDouble();
			System.out.println();

		}
		//3. Discount
		System.out.print("Please enter the amount to qualify for discount (or 0 if non offered): ");
		dis1 = input.nextDouble(); 
		if (dis1 != 0) {
			System.out.print("Please enter the discount rate (0.1 for 10%): ");
			do {
				dis2 = input.nextDouble();	
				if (dis2 <= 0 || dis2 > 0.5) {
					System.out.print("Invaild input. Enter a value > 0 and <=0.5: ");
				}
			} while (dis2 <= 0 || dis2 > 0.5);
		}

		return Numitems;
		
	

	} //Buy Items (II)
	public static void Buy(Scanner input, String[] names, double[] prices, int[] amounts, int Numitems) {

		for (int i = 0; i < Numitems; i++){
			System.out.print("Enter the amount of " + names[i] + ":");
			amounts[i] = input.nextInt(); 
		}

	}// List of Items (III)
	public static void List(String [] names, double[] prices, int[] amounts, int items) {

		for(int i = 0; i < items; i++) {
			if (amounts[i] > 0) {
				System.out.println(amounts[i] + " count of " + names[i] + " @  $" + prices[i] + " = $" + (amounts[i]*prices[i]));
				
			}

		}

	}//Check Out (IV)
	

	public static void Checkout(double[] prices, int[] amounts) {
		double total = 0;

		for(int i = 0; i < amounts.length; i++) {
			total = prices[i]*amounts[i] + total;
		}

		double disc = 0;
		disc = (total*(dis2));

		if (total >= dis1){
			System.out.println();
			
			System.out.println("Original Sub Total: \t$" + total);
			
			if (total >= dis1){
			System.out.println("Discount: \t\t-$" + (disc));
			}
			else if (total < dis1){
			System.out.println("No Special Discount was applied");
			}
			
			System.out.println("New Subtotal: \t\t$" + (total - (disc)));
			
			if ((total - (disc) <= dis2))  {
				System.out.println("You did not qualify for an additional discount");
			}
			else {
				System.out.println("Additional " + (int)(dis2 * 100) + "% Discount: -$" + ((total - (disc)) * dis2));
			}
			System.out.println("Final Sub Total: \t$:" + ((total - (disc))-((total - (disc)) * dis2)));
			
			

			
		}

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int MAX = 100;
		int set = 0;
		int buy = 0;
		int items = 0;
		int func = 0;
		int leave = 0;
		int redo = 0;
		String[] names = new String[MAX];
		double[] prices = new double[MAX];
		int[] amounts = new int[MAX];
		double[] disPkg = new double[MAX];
		int[] disAmt = new int[MAX];
		do {
			System.out.println("This program supports 4 functions:");
			System.out.println("1. Setup Shop");
			System.out.println("2. Buy");
			System.out.println("3. List Items");
			System.out.println("4. Checkout");
			System.out.print("Please choose the function you want: ");
			func = input.nextInt();


			if ( 1 <= func || func >= 4){

						
				if (func == 1){
					if (set == 0){
						items = Setup (input, names, prices, disPkg);
							
						
					}
					set = 1;	
				}

				if (func == 2){
					if (set == 1){
						System.out.println();
						Buy(input, names, prices, amounts, items);
						System.out.println();


					}
					else{ 
						System.out.println();
						System.out.print("Shop is not setup yet!"); 
						System.out.println();
						System.out.println();

					}
					buy = 1;

				}

				if (func == 3){

					if (buy == 1){
						System.out.println();
						List(names, prices, amounts, items);
						System.out.println();
					}		

					if (set == 1 && buy == 0){
						System.out.println();
						System.out.println("Try again: You have not bought anything");
						System.out.println(); 


					}	
					if (set == 0){
						System.out.println();
						System.out.println("Shop is not setup yet!");
						System.out.println();
					}

				}


				if (func == 4){
					if (set == 0){
						System.out.println();
						System.out.println("Shop is not setup yet!");
						System.out.println(); 
						continue;
					}
					if (buy == 0){
						System.out.println();
						System.out.println("Try again: You have not bought anything");
						System.out.println(); 
						continue;
					}
					if (buy == 1){
						Checkout(prices, amounts);
						break;

						
					} 	

				}


				else if (func > 4){
					System.out.println();
					System.out.println("Error: Do not know " + func);	
					System.out.println();
				}	

				if (func == 4 && buy == 1) {
					leave = 1;
				}
			}



		} while (func != 4 && leave == 0);

		System.out.println("Thanks for coming!");

		System.out.println();
		System.out.print("Would you like to re-run (1 for yes, 0 for no)? ");
		redo = input.nextInt();

		if (redo == 1) {
			main(args);
		}

		else {

		}

	}
}


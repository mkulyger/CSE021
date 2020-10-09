import java.util.Scanner;

public class RemainderFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner input = new Scanner(System.in);
	
	System.out.print("Please enter the max number: ");
	int max = input.nextInt();
	
	 for (int a = 1; max < 0; a++) {
	  if (max < 0)
		System.out.print("Invalid input. Please enter a valid max number (>= 0): ");
		max = input.nextInt();
		}
	
	System.out.print("Please enter the divisor: ");
	int div = input.nextInt();
	
	for (int b = 1; div <= 0; b++) {
	 if (div <= 0) 
		System.out.print("Invalid input. Please enter a valid divisor (> 0): ");
		div = input.nextInt();
	  }
		
	System.out.print("Multiples of " + div + " between 1 and " + max + " (inclusive) are: \n");
	
	
	for (int i = 1; i <= max; i++) {
		int multiple = ((div%max)*i);	

		if (max < multiple) {
			System.out.println(multiple);
			break;
		
		} else if (max > multiple) {
			System.out.print("No number were found.");
			break;
		}
	}
	
}
}
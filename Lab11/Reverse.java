package recursion;

public class Reverse {

	/*
	 * Now, write a recursive solution to reverse without using any helper methods.
	 * That is, reverse should only call reverse (and some string manipulation methods).
	 */
	
	public String reverse(String s) {
		if(s.length()  == 1) {
			return s;
			// base case
		} else {
			String partial = reverse(s.substring(1,s.length()));
			String firstLetter = s.substring(0,1);
			return(partial + firstLetter);
			// the recursive case! 
		}
	}
	
	//////// HELPER METHODS YOU MIGHT FIND USEFUL
	
	// Returns a string containing all the characters except the first
	public static String allButFirst(String s) {
		return s.substring(1);
	}
	
	// Returns a string containing all the characters except the last
	public static String allButLast(String s) {
		return s.substring(0, s.length());
	}	

	// Use this to test your reverse method by running this class manually
	public static void main(String[] args) {
		Reverse obj = new Reverse();
		System.out.println(obj.reverse("This is Lab 11 of CSE 21"));
		System.out.println(obj.reverse("123456"));
		System.out.println(obj.reverse("I am learning recursion to solve problems in CSE!"));
	}

}

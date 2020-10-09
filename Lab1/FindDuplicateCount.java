
public class FindDuplicateCount {

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 2, 4, 3, 0, 5, 3, 2};
		
		int a, number = 0;
		int b = 1;

	for (a = 0; a < arr.length; a++){
		number = 0;
	
	for (b = a  + 1; b < arr.length; b++){
		if(arr[a] == arr[b])
			number++;
		}

		if(number == 0)
			System.out.println("There are no duplicates with value " + arr[a] + " beyond index " + a);
			
		if (number > 1)
			System.out.println("There are " + number + " more occurences of value " + arr[a] + " starting at index " + a);

		if (number == 1)
			System.out.println("There is only " + number + " more occurences of value " + arr[a] + " starting at index " + a);

			}
		
	}

}

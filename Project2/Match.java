import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Match {

	public static void main (String[] args) {

		//Array of Students of max = 100
		Student [] student = new Student[100];

		System.out.println("Give file name: ");
		Scanner input = new Scanner(System.in);
		String fileName = input.next();
		try {
			Scanner fileInput = new Scanner(new FileReader(fileName));
			int i = 0;

			while(fileInput.hasNextLine()) {

				Scanner line = new Scanner(fileInput.nextLine());
				line.useDelimiter("[\t\r]"); //delimited
				String name = line.next(); //name(String)
				String gender = line.next(); //gender(char)
				String date = line.next(); //date(String)

				Scanner birthDateReader = new Scanner(date);
				birthDateReader.useDelimiter("-"); 
				int month = birthDateReader.nextInt();
				int day = birthDateReader.nextInt();
				int year = birthDateReader.nextInt();

				int quietTime = line.nextInt();
				int music = line.nextInt();
				int reading = line.nextInt();
				int chatting = line.nextInt();

				Date birthdate = new Date(month, day, year);
				Preference pref = new Preference(quietTime, music, reading, chatting);
				Student studentAdd = new Student(name, gender.charAt(0), birthdate, pref);
				student[i++] = studentAdd;

			}				
			int max = i; 
			for(i = 0; max > i; i ++) {
				if(!student[i].getMatched()) { 
					int bestScore = 0;
					int bestMatch = 0;

					for(int j = i+1; max > j; j++) {
						if(!student[j].getMatched()) { //students who aren't matched yet
							int currentScore = student[i].compare(student[j]);
							if(currentScore > bestScore) {
								bestScore = currentScore;
								bestMatch = j;
							}
						}
					}
					if(bestScore != 0) {
						student[i].setMatched(true);
						student[bestMatch].setMatched(true);
						System.out.println(student[i].getName() + " matches with " + student[bestMatch].getName() + " with the score " + bestScore);
					}
					else
						if(!student[i].getMatched())
							System.out.println(student[i].getName() + " has no matches.");
				}
			}

			input.close();	

		}catch(NoSuchElementException e) {
			System.out.println(e);
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
}

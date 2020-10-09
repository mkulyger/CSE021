
public class Student {

	private String name;
	private char gender;
	private Date birthDate;
	private Preference pref;
	private boolean matched; 
	private int month;
	private int day;
	private int year;
	public int compatabilityScore;

	public Student() {
		name = "Mia";
		gender = 'F'; 
		matched = false;
		birthDate = new Date(month, day, year); 
	}

	//a constructor that sets the instance variables to their appropriate input
	public Student(String name, char gender, Date birthDate, Preference pref) {
		this.name = name; //parameter 1
		this.gender = gender; //parameter 2
		this.birthDate = birthDate; //parameter 3
		this.pref = pref; //parameter 4
	}

	//Mutators
	//Mutator for name
	public void setName(String name) {
		this.name = name;
	}	
	//Mutator for gender
	public void setGender(char gender) {
		this.gender = gender;
	}	
	//Mutator for birthdate
	public void setbirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	//Mutator for preference
	public void setPreference(Preference pref) {
		this.pref = pref;
	}
	//Mutator for match
	public void setMatched(boolean matched) {
		this.matched = matched;
	}

	//Accessors
	//Name Accessor
	public String getName() {
		return name;
	}
	//Gender Accessor 
	public char getGender() {
		return gender;
	}
	//Birthdate Accessor
	public Date getbirthDate() {
		return birthDate;
	}
	//Preference Accessor
	public Preference getPref() {
		return pref;
	}
	//Matched Accessor
	public boolean getMatched() {
		return matched;
	}

	//compare(Student st) method that returns 
	//compatibility score between oneself and 
	//Student input parameter, st
	public int compare(Student st) {
		if (gender != st.gender) {
			return 0; 
			//Diff. genders make score 0
			//Only match same gender students as room mates
		}

		compatabilityScore = (40 - pref.compare(st.pref)) + (60 - birthDate.compare(st.birthDate));

		//High: 100, Low: 0 //Compatibility Score Calc.
		if(compatabilityScore < 0) {
			return 0; 
		}
		else if(compatabilityScore > 100) {
			return 100; 
		}
		return compatabilityScore;  
	}
}

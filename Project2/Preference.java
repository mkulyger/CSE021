
public class Preference {

	int quietTime;
	int music;
	int reading;
	int chatting;

	public Preference() {
		quietTime = 0;
		music = 0; 
		reading = 0; 
		chatting = 0; 
	}

	//Constuctor: 4 input parameters
	//0 = hate, 10 = love (inclusive)
	public Preference(int quietTime, int music, int reading, int chatting) {
		if(quietTime >= 0 && quietTime <= 10) {
			this.quietTime = quietTime;
		}
		if(music >= 0 && music <= 10) {
			this.music = music;
		}
		if(reading >= 0 && reading <= 10) {
			this.reading = reading;
		}
		if(chatting >= 0 && chatting <= 10) {
			this.chatting = chatting;
		}
	}

	//Accessors
	public int getQuietTime() {
		return quietTime;
	}
	public int getMusic() {
		return music;
	}
	public int getReading() {
		return reading;
	}
	public int getChatting() {
		return chatting;
	}

	//Sum of Absolute Value of Diff. in 4 Parameters
	public int compare(Preference pref) {
		return(Math.abs(quietTime - pref.quietTime) + Math.abs(music - pref.music) + Math.abs(reading - pref.reading) + Math.abs(chatting - pref.chatting));
	}


}

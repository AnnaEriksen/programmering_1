package opgave2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
	private char level;
	private int weeklyWaterHours;
	private int weeklyStrengthHours;
	private ArrayList<Swimmers> swimmers = new ArrayList<>();
	
	public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
		this.level = level;
		this.weeklyWaterHours = weeklyWaterHours;
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public char getLevel() {
		return level;
	}
	
	public void setLevel(char niveau) {
		this.level = niveau;
	}
	
	public int getWeeklyStrengthHours() {
		return weeklyStrengthHours;
	}
	
	public void setWeeklyStrengthHours(int weeklyStrengthHours) {
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public int getWeeklyWaterHours() {
		return weeklyWaterHours;
	}

	public void setWeeklyWaterHours(int weeklyWaterHours) {
		this.weeklyWaterHours = weeklyWaterHours;
	}

	public void addSwimmer(Swimmers swimmer){
		if (!this.swimmers.contains(swimmer)){
			swimmers.add(swimmer);

		}
	}

	public void removeSwimmer(Swimmers swimmer){
		if (this.swimmers.contains(swimmer)){
			swimmers.remove(swimmer);

		}
	}

	public ArrayList<Swimmers> getSwimmers(){
		return new ArrayList<Swimmers>(swimmers);
	}
	
}

package opgave3Swimmer;

import java.util.ArrayList;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;
    
    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */ 

   public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
       this.name = name;
       this.yearGroup = yearGroup;
       this.lapTimes = lapTimes;
       this.club = club;
   }
    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Register the club of the swimmer
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }
    
    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double best = Double.MAX_VALUE;
        for (double time: lapTimes) {
        	if(best > time) {
        		best = time;
        	}
        }
        return best;
    }


    public int allTrainingHours () {
        if (trainingPlan != null){
            return trainingPlan.getWeeklyStrengthHours() + trainingPlan.getWeeklyWaterHours();
        }
        else {
            return 0;
        }

    }
    public void trainingPlan(TrainingPlan trainingPlan) {
        if (this.trainingPlan != trainingPlan) {
            TrainingPlan oldTrainingPlan = this.trainingPlan;
            if (oldTrainingPlan != null) {
                oldTrainingPlan.removeSwimmer(this);
            }
            this.trainingPlan = trainingPlan;
            if (trainingPlan != null) {
                trainingPlan.addSwimmer(this);
            }
        }
    }
}



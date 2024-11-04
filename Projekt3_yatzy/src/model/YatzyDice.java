package model;

import java.util.Random;

public class YatzyDice {
	// Face values of the 5 dice.
	// 1 <= values[i] <= 6.
	private int[] values = new int[5];

	// Number of times the 5 dice have been thrown.
	// 0 <= throwCount <= 3.
	private int throwCount = 0;

	// Random number generator.
	private Random random = new Random();

	public YatzyDice() {
		//
	}

	/**
	 * Returns the 5 face values of the dice.
	 */
	public int[] getValues() {
		return values;
	}

	/**
	 * Sets the 5 face values of the dice. Pre: values contains 5 face values in
	 * [1..6]. Note: This method is only meant to be used for test, and
	 * therefore has package visibility.
	 */
	void setValues(int[] values) {
		this.values = values;
	}

	/**
	 * Returns the number of times the 5 dice has been thrown.
	 */
	public int getThrowCount() {
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		throwCount = 0;
	}
	/**
	 * Rolls the 5 dice. Only roll dice that are not hold.
	 * Pre: holds contain 5 boolean values.
	 */
	public void throwDice(boolean[] holds) {
		for (int i = 0; i < values.length; i++){
			if (!holds[i]){
				values[i] = (int) (Math.random() * 6 + 1);
			}
		}
		throwCount++;
	}

	// -------------------------------------------------------------------------

	/**
	 * Return all results possible with the current face values.<br/>
	 * The order of the results is the same as on the score board.<br/>
	 * Note: This is an optional method. Comment this method out,<br/>
	 * if you don't want use it.
	 */
	public int[] getResults() {
		int[] results = new int[15];
		for (int i = 0; i <= 5; i++) {
			results[i] = this.sameValuePoints(i + 1);
		}
		results[6] = this.onePairPoints();
		results[7] = this.twoPairPoints();
		results[8] = this.threeSamePoints();
		results[9] = this.fourSamePoints();
		results[10] = this.fullHousePoints();
		results[11] = this.smallStraightPoints();
		results[12] = this.largeStraightPoints();
		results[13] = this.chancePoints();
		results[14] = this.yatzyPoints();

		return results;
	}

	// -------------------------------------------------------------------------

	// Return an int[7] containing the frequency of face values.
	// Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
	// Index 0 is not used.
	// Note: This method can be used in several of the following methods.
	private int[] frequency() {
		int[] frequency = new int[7];
		for (int i = 0; i < values.length; i++){
			int v = values[i];
			if (v >= 1 && v <= 6){
				frequency[v]++;
			}
		}
		return frequency;
	}

	/**
	 * Return same-value points for the given face value.<br/>
	 * Returns 0, if no dice has the given face value.<br/>
	 * Pre: 1 <= value <= 6;
	 */
	public int sameValuePoints(int value) {
		int points = 0;
		for (int i = 0; i < values.length; i++){
			if (values[i] == value){
				points += values[i];
			}
		}
		return points;

	}

	/**
	 * Return points for one pair (for the face value giving the highest points).<br/>
	 * Return 0, if there aren't 2 dice with the same face value.
	 */
	public int onePairPoints() {
		int[] frequency = frequency();
		int maxPairValue = 0;
		for (int v = 1; v <= 6; v++){
			if (frequency[v] >= 2){
				maxPairValue = v;
			}
		}
		int point = maxPairValue * 2;

        return point;
    }

	/**
	 * Return points for two pairs<br/>
	 * (for the 2 face values giving the highest points).<br/>
	 * Return 0, if there aren't 2 dice with the same face value<br/>
	 * and 2 other dice with the same but different face value.
	 */
	public int twoPairPoints() {
		int[] frequency = frequency();
		int pair1 = 0;
		int pair2 = 0;
		int sum = 0;

		for (int v = 1; v < frequency.length; v++){
			if (frequency[v] >= 2){
				if (pair1 == 0){
					pair1 = v;
				}
				else if (pair2 == 0){
					pair2 = v;
				}
			}
		}

		if (pair1 > 0 && pair2 > 0){
			sum = pair1 * 2 + pair2 * 2;
		}
        return sum;
    }

	/**
	 * Return points for 3 of a kind.<br/>
	 * Return 0, if there aren't 3 dice with the same face value.
	 */
	public int threeSamePoints() {
		int[] frequency = frequency(); //antal terninger for hver værdi
		int threeOfSame = 0;
		for (int v = 1; v <= 6; v++){
			if (frequency[v] >= 3){
				threeOfSame = v;
			}
		}
		int result = threeOfSame * 3;

		return result;
    }

	/**
	 * Return points for 4 of a kind.<br/>
	 * Return 0, if there aren't 4 dice with the same face value.
	 */
	public int fourSamePoints() {
		int[] frequency = frequency(); //antal terninger for hver værdi
		int fourOfSame = 0;
		for (int v = 1; v <= 6; v++){
			if (frequency[v] >= 4){
				fourOfSame = v;
			}
		}
		int result = fourOfSame * 4;

		return result;
	}

	/**
	 * Return points for full house.<br/>
	 * Return 0, if there aren't 3 dice with the same face value<br/>
	 * and 2 other dice with the same but different face value.
	 */
	public int fullHousePoints() {
		int[] frequency = frequency();
		int triple = 0;
		int doouble = 0;
		int sum = 0;

		for (int v = 1; v < frequency.length; v++){
			if (frequency[v] == 3){
				triple = v;
			}
			else if (frequency[v] == 2) {
				doouble = v;
			}
		}
		if (triple > 0 && doouble > 0){
			sum = triple * 3 + doouble * 2;
		}

        return sum;
    }

	/**
	 * Return points for small straight.<br/>
	 * Return 0, if the dice aren't showing 1,2,3,4,5.
	 */
	public int smallStraightPoints() {
		int[] frequency = frequency();
		for (int v = 1; v <= 5 ; v++) {
			if (frequency[v] != 1) {
				return 0;
			}
		}
		return 15;
	}


	/**
	 * Return points for large straight.<br/>
	 * Return 0, if the dice aren't showing 2,3,4,5,6.
	 */
	public int largeStraightPoints() {
		int[] frequency = frequency();
		for (int v = 2; v <= 6 ; v++) {
			if (frequency[v] != 1) {
				return 0;
			}
		}

		return 20;
	}

	/**
	 * Return points for chance (the sum of face values).
	 */
	public int chancePoints() {
		int sum = 0;

		for (int i = 0; i < values.length; i++){
			sum += values[i];
		}

		return sum;
	}

	/**
	 * Return points for yatzy (50 points).<br/>
	 * Return 0, if there aren't 5 dice with the same face value.
	 */
	public int yatzyPoints() {
		int[] frequency = frequency(); //antal terninger for hver værdi
		for (int v = 1; v <= 6; v++){
			if (frequency[v] == 5){ // vi skriver == da det er præcis 5.
				return 50;
			}
		}

		return 0;
	}

}

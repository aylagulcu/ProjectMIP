package MoveOperators;

import Random.GaussianRandom;
import Variables.Variables;

public class IntIncreaseDecrease extends IntegerMove{

	private int stDev;
	
	public IntIncreaseDecrease(int stDev) {
		this.stDev = stDev;
	}

	public int getNewValue(int varIndex) {
		int[] values= Variables.getIntVar(varIndex);
		int min= values[1];
		int max= values[2];
		int newValue= GaussianRandom.getInt(values[0], min, max, this.stDev);
		if (newValue > max)
			return min + (newValue % (max-min));
		else if (newValue < min)
			return max - (newValue % (max-min));
		return newValue;
	}

}

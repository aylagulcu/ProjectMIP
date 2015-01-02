package MoveOperators;

import Random.GaussianRandom;
import Variables.Variables;

public class DoubleIncreaseDecrease extends DoubleMove{

	private int stDev;
	
	public DoubleIncreaseDecrease(int stDev) {
		this.stDev = stDev;
	}

	public double getNewValue(int varIndex) {
		int[] values= Variables.getIntVar(varIndex);
		int min= values[1];
		int max= values[2];
		double newValue= GaussianRandom.getDouble(values[0], min, max, this.stDev);
		if (newValue > max)
			return min + (newValue % (max-min));
		else if (newValue < min)
			return max - (newValue % (max-min));
		return newValue;
	}

}

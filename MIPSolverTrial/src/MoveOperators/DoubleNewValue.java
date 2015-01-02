package MoveOperators;

import Random.UniformRandom;
import Variables.Variables;

public class DoubleNewValue extends DoubleMove{

	// Returns a double uniformly distributed within the range of the current variable.
	public double getNewValue(int varIndex) {
		int[] values= Variables.getIntVar(varIndex);
		int min= values[1];
		int max= values[2];
		return UniformRandom.getDouble(min, max);
	}

}

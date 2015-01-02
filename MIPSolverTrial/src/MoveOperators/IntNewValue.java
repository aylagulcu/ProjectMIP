package MoveOperators;

import Random.UniformRandom;
import Variables.Variables;

public class IntNewValue extends IntegerMove{

	// Returns an integer uniformly distributed within the range of the current variable.
	public int getNewValue(int varIndex) {
		int[] values= Variables.getIntVar(varIndex);
		int min= values[1];
		int max= values[2];
		return UniformRandom.getInt(min, max);
	}

}

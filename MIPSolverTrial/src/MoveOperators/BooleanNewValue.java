package MoveOperators;

import Random.UniformRandom;

public class BooleanNewValue extends BooleanMove{

	// Returns a boolean uniformly distributed
	public boolean getNewValue(int varIndex) {
		return UniformRandom.getBoolean();
	}

}

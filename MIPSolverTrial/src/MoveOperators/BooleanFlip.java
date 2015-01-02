package MoveOperators;

import Variables.Variables;

public class BooleanFlip extends BooleanMove{

	public boolean getNewValue(int varIndex) {
		int[] values= Variables.getIntVar(varIndex);
		int curVal= values[0];
		if (curVal== 0)
			return true;
		else
			return false;
	}

}

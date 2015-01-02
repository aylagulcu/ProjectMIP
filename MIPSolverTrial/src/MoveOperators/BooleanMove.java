package MoveOperators;

public abstract class BooleanMove implements Move{

	// For the given variable, returns a boolean value
	public abstract boolean getNewValue(int varIndex);
}

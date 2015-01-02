package MoveOperators;

public abstract class IntegerMove implements Move {
	
	// For the given variable, returns an integer value within the range.
	public abstract int getNewValue(int varIndex);
	
}

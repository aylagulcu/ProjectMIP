package Variables;

import java.util.ArrayList;
import java.util.List;

public class Variables {

	private static int numIntVars= 0;
	public static int getNumIntVars() {
		return numIntVars;
	}

	public static void setNumIntVars(int numIntVars) {
		Variables.numIntVars = numIntVars;
	}
	
	private static int numContVars= 0;
	public static int getNumContVars() {
		return numContVars;
	}

	public static void setNumContVars(int numContVars) {
		Variables.numContVars = numContVars;
	}

	private static int numBinVars= 0;
	public static int getNumBinVars() {
		return numBinVars;
	}

	public static void setNumBinVars(int numBinVars) {
		Variables.numBinVars = numBinVars;
	}

	private static List<int[]> intVars= new ArrayList<int[]>(); // int[0]:value, int[1]:LB, int[2]:UB
	
	public static int[] getIntVar(int index) {
		return intVars.get(index);
	}

	public static void setIntVar(int index, int[] values) {
		Variables.intVars.add(index, new int[]{values[0], values[1], values[2]});
	}
	
	private static List<double[]> contVars= new ArrayList<double[]>(); // int[0]:value, int[1]:LB, int[2]:UB
	public static double[] getContVar(int index) {
		return contVars.get(index);
	}

	public static void setContVar(int index, double[] values) {
		Variables.contVars.add(index, new double[]{values[0], values[1], values[2]});
	}
	
	private static List<boolean[]> binVars= new ArrayList<boolean[]>(); // int[0]:value, int[1]:LB, int[2]:UB
	public static boolean[] getBinVar(int index) {
		return binVars.get(index);
	}

	public static void setBinVar(int index, boolean[] values) {
		Variables.binVars.add(index, new boolean[]{values[0], values[1], values[2]});
	}
	
}

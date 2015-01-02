import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import Random.GaussianRandom;
import Random.UniformRandom;
import Variables.Variables;;

public class Deneme {

	public static void main(String[] args) {
		
		try {
			getVariableData("../MIPSolverTrial/src/data.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		printVariables(); 
		System.out.println("Ne yazayım???");
		
	} // end main
		
	private static void getVariableData(String filePath) throws NumberFormatException, IOException {
		File f= new File(filePath);
		String sCurrentLine;
		BufferedReader br= new BufferedReader(new FileReader(f));
		String delims = "[ \\t :]+"; // sign (+) is used to indicate that consecutive delimiters should be treated as one.
		String[] temp;
		while ((sCurrentLine = br.readLine()) != null) {
			temp= sCurrentLine.split(delims);
			if (temp[0].equals("Integer")){// case sensitive
				Variables.setNumIntVars(Integer.parseInt(temp[1]));
				int[] values= new int[3]; 
				for (int i=0; i< Variables.getNumIntVars(); i++){
					sCurrentLine = br.readLine();
					temp= sCurrentLine.split("\\t");
					values[1]= Integer.parseInt(temp[0]);
					values[2]= Integer.parseInt(temp[1]);
					values[0]= initializeIntVar(values[1], values[2]); // INITIALIZATION!
					Variables.setIntVar(i, values); // Reference is sent but values are used only.
				}
			}
			else if (temp[0].equals("Continuous")){ // case sensitive
				Variables.setNumContVars(Integer.parseInt(temp[1]));
				double[] values= new double[3];
				for (int i=0; i< Variables.getNumContVars(); i++){
					sCurrentLine = br.readLine();
					temp= sCurrentLine.split(delims);
					values[1]= Double.parseDouble(temp[0]);
					values[2]= Double.parseDouble(temp[1]);
					values[0]= initializeContVar(values[1], values[2]); // INITIALIZATION!
					Variables.setContVar(i, values);
				}
			}
			else if (temp[0].equals("Binary")){ // case sensitive
				Variables.setNumBinVars(Integer.parseInt(temp[1]));
				boolean[] values= new boolean[3];
				for (int i=0; i< Variables.getNumBinVars(); i++){
					sCurrentLine = br.readLine();
					temp= sCurrentLine.split(delims);
					values[1]= Boolean.parseBoolean(temp[0]);
					values[2]= Boolean.parseBoolean(temp[1]);
					values[0]= initialializeBinVar(); // INITIALIZATION!
					Variables.setBinVar(i, values);
				}
			}
		} // end while
		br.close();	
	}
	

	private static int initializeIntVar(int min, int max) {
		return UniformRandom.getInt(min, max);
	}

	private static double initializeContVar(double min, double max) {
		return UniformRandom.getDouble(min, max);
	}

	private static boolean initialializeBinVar() {
		return UniformRandom.getBoolean();
	}


	private static void printVariables() {
		System.out.println("Integer Variable + LB + UB");
		int[] arr= new int[3];
		for (int i=0; i< Variables.getNumIntVars(); i++){
			arr= Variables.getIntVar(i);
			System.out.print(arr[0]+"\t" + arr[1]+"\t"+ arr[2]);
			System.out.println();
		}	
		System.out.println();
		
		System.out.println("Continuous Variable + LB + UB");
		double[] arrD= new double[3];
		for (int i=0; i< Variables.getNumContVars(); i++){
			arrD= Variables.getContVar(i);
			System.out.print(arrD[0]+"\t" + arrD[1]+"\t"+ arrD[2]);
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Binary Variable");
		boolean[] arrB= new boolean[3];
		for (int i=0; i< Variables.getNumBinVars(); i++){
			arrB= Variables.getBinVar(i);
			System.out.print(arrB[0]+"\t" + arrB[1]+"\t"+ arrB[2]);
			System.out.println();
		}
		System.out.println();
		
	}

}

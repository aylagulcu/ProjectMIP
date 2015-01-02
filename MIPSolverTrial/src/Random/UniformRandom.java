package Random;
import java.util.Random;

public final class UniformRandom {
	private static Random rand;
	private static long seed;
	
    // static initializer
    static {
        //seed = System.currentTimeMillis();
        rand = new Random(123456);
    }
	
    private UniformRandom(){}
	
    // Sets the seed of the pseudo random number generator (prng).
    public static void setSeed(long s) {
        seed   = s;
        rand = new Random(seed);
    }
    
    // Returns the seed of the prng.
    public static long getSeed() {
        return seed;
    }
    
    // Returns a boolean uniformly distributed from prng.
    public static boolean getBoolean(){
		return rand.nextBoolean();			
	}
	
    // Returns a double uniformly distributed in [0,1) from prng. 
	public static double getDouble(){
		return rand.nextDouble();
	}
	
	// Returns a double uniformly distributed in [min,max) from prng.
	public static double getDouble(double min, double max){	
		double result = min + getDouble() * getRange(min, max);
		return result;
	}
	
	// Returns a double uniformly distributed in [min,Double.MAX_VALUE) from prng.
	public static double getDouble(double min){
		return getDouble(min, Double.MAX_VALUE);
	}
	
	// Returns an int uniformly distributed in [min,max] from prng.
	public static int getInt(int min, int max){
		return rand.nextInt(getRange(min, max)+1)+ min;
	}
	
	private static double getRange(double min, double max) {
		double rng= max - min;
		if (rng <=0 ) throw new IllegalArgumentException("Invalid range");
        if (rng >= Double.MAX_VALUE ) throw new IllegalArgumentException("Invalid range");
		return rng;
	}
	
	private static int getRange(int min, int max) {
		int rng= max - min;
		if (rng <=0 ) throw new IllegalArgumentException("Invalid range");
        if (rng >= Integer.MAX_VALUE ) throw new IllegalArgumentException("Invalid range");
		return rng;
	}
	
	
}

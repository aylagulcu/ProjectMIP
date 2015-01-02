package Random;
import java.util.Random;

public final class GaussianRandom {
	private static Random rand;
	private static long seed;
	
    // static initializer
    static {
        //seed = System.currentTimeMillis();
        rand = new Random(123456);
    }
	
    private GaussianRandom(){}
	
    // Sets the seed of the pseudo random number generator (prng).
    public static void setSeed(long s) {
        seed   = s;
        rand = new Random(seed);
    }
    
    // Returns the seed of the prng.
    public static long getSeed() {
        return seed;
    }
	
    // Returns a double Gaussian ("normally") distributed with mean 0.0 and standard deviation 1.0 from prng.
	public static double getDouble(){
		return rand.nextGaussian(); 
	}
	
	// Returns a double Gaussian distributed with given standard deviation from prng, mean= 0.
	public static double getDouble(double stdev){	
		return getDouble() * stdev; // Z= (X-μ)/σ
	}
	
	// Returns a double Gaussian distributed with given mean and standard deviation from prng.
	public static double getDouble(double mean, double min, double max, double stdev){	
		return mean + getDouble() * stdev * getRange(min, max); // Z= (X-μ)/σ
	}

	private static double getRange(double min, double max) {
		if (max < min) throw new IllegalArgumentException("Invalid range");
		double rng= max - min;
		if (rng <=0 ) throw new IllegalArgumentException("Invalid range");
        if (rng >= Integer.MAX_VALUE ) throw new IllegalArgumentException("Invalid range");
		return rng;
	}
	
	// Returns a rounded double Gaussian distributed with given mean and standard deviation from prng.
	public static int getInt(int mean, int min, int max, double stDev){
		return (int) Math.round(mean + getDouble() * stDev * getRange(min, max));
	}
	private static int getRange(int min, int max) {
		int rng= max - min;
		if (rng <=0 ) throw new IllegalArgumentException("Invalid range");
        if (rng >= Integer.MAX_VALUE ) throw new IllegalArgumentException("Invalid range");
		return rng;
	}
}

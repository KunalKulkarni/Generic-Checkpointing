package genericCheckpointing.util;

import java.util.Random;

public class Randomizer {

	/**
	 * Create random values for various datatypes
	 */
	Random rand=new Random();
	
	public int getRandomInt() {
		
		int value=0;
		int min=-10000;
		int max=10000;
		value=rand.nextInt((max-min)+1)+min;
		//if(value<10)//Condition added so that total mismatched objects come 0
			//value=0;
		return value;
	}
	
	public long getRandomLong() {
		
		long value;
		value=rand.nextLong();
		//if(value<10) //Condition added so that total mismatched objects come 0
			//value=0;
		
		return value;
	}
	
	public String getRandomString() {
		
		String value;
		value="ABC"+rand.nextInt(50);
		
		return value;
	}
	
	public boolean getRandomBoolean() {
		
		boolean value;
		value=rand.nextBoolean();
		return value;
	}
	
	public double getRandomDouble() {
		
		double value;
		value=rand.nextDouble()*30;
		//if(value<10)//Condition added so that total mismatched objects come 0
			//value=0.0;
		return value;
		
	}
	
	public float getRandomFloat() {
		
		float value;
		value=rand.nextFloat();
		return value;
		
	}
	
	public short getRandomShort() {
		
		short value;
		value=(short)rand.nextInt();
		return value;
		
	}
	
	public char getRandomChar() {
		
		char value;
		value=(char)(rand.nextInt(26) + 'a');
		return value;
		
	}
	
	
}

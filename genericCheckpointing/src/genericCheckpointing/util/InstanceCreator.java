package genericCheckpointing.util;

public class InstanceCreator {

	Randomizer rand = new Randomizer();
	MyAllTypesFirst myAllTypesFirst;
	MyAllTypesSecond myAllTypesSecond;
	/**
	 * Create two objects with random values
	 * @return
	 */
	public MyAllTypesFirst getAllTypesFirstInstance() {
		
		int myInt = rand.getRandomInt();
		int myOtherInt = rand.getRandomInt();
		long myLong = rand.getRandomLong();
		long myOtherLong = rand.getRandomLong();
		String myString = rand.getRandomString();
		boolean myBool = rand.getRandomBoolean();
		myAllTypesFirst=new MyAllTypesFirst(myInt, myLong, myString, myBool, myOtherInt, myOtherLong);
		return myAllTypesFirst;
	}
	
	public MyAllTypesSecond getAllTypesSecondInstance() {
		
	
		double myDoubleT = rand.getRandomDouble();
		double myOtherDoubleT = rand.getRandomDouble();
		short myShortT = rand.getRandomShort();
		float myFloatT = rand.getRandomFloat();
		char myCharT = rand.getRandomChar();
		myAllTypesSecond = new MyAllTypesSecond(myDoubleT, myFloatT, myShortT, myCharT, myOtherDoubleT);
		return myAllTypesSecond;
	}
	
}

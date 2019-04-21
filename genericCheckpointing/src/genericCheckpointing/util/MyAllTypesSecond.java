package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {

	
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	private double myOtherDoubleT;

	public MyAllTypesSecond() {
		
		myDoubleT=0;
		myFloatT=0;
		myShortT=0;
		myCharT=0;
		myOtherDoubleT=0;
	}
	
	public MyAllTypesSecond(double myDoubleT,float myFloatT,short myShortT,
			char myCharT,double myOtherDoubleT) {
		
		this.myDoubleT=myDoubleT;
		this.myFloatT=myFloatT;
		this.myShortT=myShortT;
		this.myCharT=myCharT;
		this.myOtherDoubleT=myOtherDoubleT;
	}
	
	public double getMyDoubleT() {
		return myDoubleT;
	}
	public void setMyDoubleT(double myDoubleT) {
		this.myDoubleT=myDoubleT;
	}
	
	public float getMyFloatT() {
		return myFloatT;
	}
	public void setMyFloatT(float myFloatT) {
		this.myFloatT=myFloatT;
	}
	
	public short getMyShortT() {
		return myShortT;
	}
	public void setMyShortT(short myShortT) {
		this.myShortT=myShortT;
	}
	
	public char getMyCharT() {
		return myCharT;
	}
	public void setMyCharT(char myCharT) {
		this.myCharT=myCharT;
	}
	
	public double getMyOtherDoubleT() {
		return myOtherDoubleT;
	}
	public void setMyOtherDoubleT(double myOtherDoubleT) {
		this.myOtherDoubleT=myOtherDoubleT;
	}
	
	public String toString() {
		return "Class: MyAllTypesSecond \n"+"myDoubleT: " + myDoubleT + "  myFloatT: " + myFloatT + "  myShort: " + myShortT + "  myOtherDoubleT: " + myOtherDoubleT
				+ "  myCharT: " + myCharT+"\n";
	}
	
	@Override
	public boolean equals(Object obj) {

		int flag=0;
		MyAllTypesSecond mySecond=null;
		if(this.getClass()==obj.getClass())
			mySecond=(MyAllTypesSecond)obj;
		
		if(mySecond==null)
			return false;
		if(mySecond.getMyDoubleT()!=myDoubleT)
			flag=1;
		if(mySecond.getMyOtherDoubleT()!=myOtherDoubleT)
			flag=1;
		if(mySecond.getMyFloatT()!=myFloatT)
			flag=1;
		if(mySecond.getMyShortT()!=myShortT)
			flag=1;
		if(mySecond.getMyCharT()!=myCharT)
			flag=1;
		
		if(flag==1)
			return false;
		else
			return true;
	}
	
	@Override
	public int hashCode() {
		
		int hash=37;
		hash=(int) (31* hash+ myDoubleT);
		hash=(int) (31* hash+ myOtherDoubleT);
		hash=31*hash + (int)myFloatT;
		hash=31*hash + (int)myShortT;
		hash=31* hash+myCharT;
		
		return hash;
	}

}

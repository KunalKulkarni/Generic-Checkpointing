package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {

	private int myInt;
	private long myLong;
	private String myString;
	private boolean myBool;
	private int myOtherInt;
	private long myOtherLong;

	public MyAllTypesFirst() {
		
		myInt=0;
		myLong=0;
		myString="";
		myBool=false;
		myOtherInt=0;
		myOtherLong=0;
	}

	public MyAllTypesFirst(int myInt, long myLong, String myString, boolean myBool, int myOtherInt, long myOtherLong) {

		this.myInt = myInt;
		this.myLong = myLong;
		this.myString = myString;
		this.myBool = myBool;
		this.myOtherInt = myOtherInt;
		this.myOtherLong = myOtherLong;
	}

	public int getMyInt() {
		return myInt;
	}

	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}

	public long getMyLong() {
		return myLong;
	}

	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	public boolean getMyBool() {
		return myBool;
	}

	public void setMyBool(boolean myBool) {
		this.myBool = myBool;
	}

	public int getMyOtherInt() {
		return myOtherInt;
	}

	public void setMyOtherInt(int myOtherInt) {
		this.myOtherInt = myOtherInt;
	}

	public long getMyOtherLong() {
		return myOtherLong;
	}

	public void setMyOtherLong(long myOtherLong) {
		this.myOtherLong = myOtherLong;
	}

	public String toString() {
		
		return "Class: MyAllTypesFirst\n"+"myInt: " + myInt + "  myString: " + myString + "  myLong: " + myLong + "  myOtherInt: " + myOtherInt
				+ "  myOtherLong: " + myOtherLong + "  myBool: " + myBool+"\n";
	}

	@Override
	public boolean equals(Object obj) {

		
		int flag=0;
		MyAllTypesFirst myFirst=null;
		if(this.getClass()==obj.getClass()) {
			myFirst=(MyAllTypesFirst)obj;
		}
		if(myFirst==null)
			return false;
		if(myInt!=myFirst.myInt) {
			flag=1;
		}
		if(myOtherInt!=myFirst.myOtherInt)
			flag=1;
		if(myLong!=myFirst.myLong)
			flag=1;
		if(myOtherLong!=myFirst.myOtherLong)
			flag=1;
		if(myBool!=myFirst.myBool)
			flag=1;
		if(!(myString.equals(myFirst.myString)))
			flag=1;
	
		if(flag==1)
			return false;
		else
			return true;
	}
	
	@Override
	public int hashCode() {
		
		int hash=37;
		hash=31* hash+ myString.hashCode();
		hash=31* hash+ myInt;
		hash=31*hash + (int)myLong;
		hash=31*hash + (int)myOtherLong;
		hash=31 * hash + (myBool?1:0);
		hash=31* hash+myOtherInt;
		
		return hash;
	}

}

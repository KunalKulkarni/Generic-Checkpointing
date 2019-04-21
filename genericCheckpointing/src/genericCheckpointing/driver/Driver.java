package genericCheckpointing.driver;

import java.util.ArrayList;
import java.util.Random;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.InstanceCreator;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.Randomizer;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {

	public static void main(String[] args) {

		FileProcessor fp = new FileProcessor();
		ProxyCreator pc = new ProxyCreator();
		StoreRestoreHandler storeRestoreHandler = new StoreRestoreHandler();
		
		argCheck(args);
		String mode = args[0];
		int NUM_OF_OBJECTS = Integer.parseInt(args[1]);
		String filename = args[2];
		modeCheck(mode);
		numCheck(NUM_OF_OBJECTS);
		
		InstanceCreator instCreate=new InstanceCreator();
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] { StoreI.class, RestoreI.class },
				storeRestoreHandler);
		ArrayList<SerializableObject> ser = new ArrayList<>();
		ArrayList<SerializableObject> deser = new ArrayList<>();
		MyAllTypesFirst myAllTypesFirst;
		MyAllTypesSecond myAllTypesSecond;
		/*
		 * In "serdeser" mode. Open Checkpoint file to print serialized output to.
		 * Open checkpoint file again to deserialize objects from the checkpoint file.
		 * Call writeObj to serialize,readObj to deserialize.
		 */
		if (mode.equals("serdeser")) {
			
			fp.openFileSerialize(filename);
			storeRestoreHandler.setFile(fp);
			for (int i = 0; i < NUM_OF_OBJECTS; i++) {

				myAllTypesFirst = instCreate.getAllTypesFirstInstance(); //Get FirstObject with random values
				((StoreI) cpointRef).writeObj(myAllTypesFirst, 13, "XML");
				myAllTypesSecond = instCreate.getAllTypesSecondInstance();//Get SecondObject with random values
				((StoreI) cpointRef).writeObj(myAllTypesSecond, 19, "XML");
				ser.add(myAllTypesFirst); //Add object to ArrayList
				ser.add(myAllTypesSecond); // Add object to ArrayList

			}
			fp.closeFileSerialize();
			SerializableObject myRecordRet;
			fp.openFileDeserialize(filename);
			storeRestoreHandler.setFile(fp);
			
			for (int j = 0; j < 2 * NUM_OF_OBJECTS; j++) {

				myRecordRet = ((RestoreI) cpointRef).readObj("XML");
				deser.add(myRecordRet);

			}
			fp.closeFileDeserialize();

			int cnt = 0;
			for (int i = 0; i < 2*NUM_OF_OBJECTS; i++) {

				if (!(ser.get(i).equals(deser.get(i)))) {

					cnt++;
				}
			}
			System.out.println("Total Mismatched Objects " + cnt);
		} 
		/**
		 * Deser mode to deserialize from the file specified in the cmdline arguments.
		 */
		else if (mode.equals("deser")) {

			SerializableObject myRecordRet;
			fp.openFileDeserialize(filename);
			storeRestoreHandler.setFile(fp);
			for (int j = 0; j < 2 * NUM_OF_OBJECTS; j++) {

				myRecordRet = ((RestoreI) cpointRef).readObj("XML");
				System.out.println(myRecordRet.toString());

			}
			fp.closeFileDeserialize();
		}
	}

	/**
	 * Function to validate command line arguments
	 * @param arr
	 */
	static void argCheck(String arr[]) {

		if (arr.length != 3) {

			System.err.println("Invalid Number of Arguments.Enter 3 Arguments- Mode NumOfObjects checkpointFile");
			System.exit(1);
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i].contains("${")){
				
				System.out.println("Invalid Entry.Enter 3 Arguments- Mode NumOfObjects checkpointFile");
				System.exit(1);
			}
		}
	}
	
	static void numCheck(int N) {
		
		if(N<0) {
			
			System.err.println("Enter num of objects more than 0");
			System.exit(1);
		}
	}
	
	static void modeCheck(String mode) {
		
		if(!(mode.equals("deser") || mode.equals("serdeser"))) {
			System.err.println("Enter correct mode");
			System.exit(1);
		}
	}

}

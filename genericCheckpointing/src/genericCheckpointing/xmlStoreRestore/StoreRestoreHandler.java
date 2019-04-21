package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerStrategy;
import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler {

	
	FileProcessor fp;
	public static SerializableObject serObject;
	
	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
	
		serObject=new SerializableObject();
		if(m.getName().equals("writeObj")) {
			String wireFormat=(String) args[2];
			if(wireFormat.equals("XML")) {
				serializeData((SerializableObject) args[0],new XMLSerialization(fp));
			}
			else {
				System.out.println("Wire Format Not Accepted");
				System.exit(1);
			}
		}
		
		if(m.getName().equals("readObj")) {
			String wireFormat=(String) args[0];
			if(wireFormat.equals("XML")) {
			serializeData(serObject,new XMLDeserialization(fp));
			return serObject;
			}
			else {
				System.out.println("Wire Format Not Accepted");
				System.exit(1);
			}
		}
		return null;
	}

	private void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
		// TODO Auto-generated method stub
		sStrategy.processInput(sObject);

	}
	
	public void setFile(FileProcessor fpIn) {
		
		fp=fpIn;
	}
}

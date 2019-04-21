package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerStrategy;
import genericCheckpointing.util.SerializableObject;

public class XMLDeserialization implements SerStrategy {

	FileProcessor fp;
	
	public XMLDeserialization(FileProcessor fpIn) {
		fp = fpIn;
	}

	@Override
	public void processInput(SerializableObject sObject) {

		DeserializeTypes deserializeTypes = new DeserializeTypes();
		String line = fp.readLine();
		
		if(line==null)
			System.exit(1); //If number of objects from command line are more than objects present in the XML file.
		
		if (line.contains("<DPSerialization>") && !(line.contains("/"))) {
			Class<?> cls = null;
			String classLine = fp.readLine();
			if (classLine.contains("<complexType") && !(line.contains("/"))) {
				String className = deserializeTypes.computeClassName(classLine);
				try {
					cls = Class.forName(className);
					sObject = (SerializableObject) cls.getDeclaredConstructor().newInstance();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String xmlLine = fp.readLine();
				while (xmlLine != null && !xmlLine.contains("</DPSerialization>")) {
					
					if(!xmlLine.contains("</complexType>")) {
						
					String varName = deserializeTypes.computeVarName(xmlLine);
					String DataType = deserializeTypes.computeDataType(xmlLine);
					String value = deserializeTypes.computeValue(xmlLine);

					try {

						if (DataType.equals("int")) {
							
							int val = 0;
							String methodName = "set" + Character.toUpperCase(varName.charAt(0)) + varName.substring(1);
							val = Integer.parseInt(value);
							Method meth = cls.getMethod(methodName, Integer.TYPE);
							meth.invoke(sObject, val);

						}
						if (DataType.equals("double")) {
							double val;
							String methodName = "set" + Character.toUpperCase(varName.charAt(0)) + varName.substring(1);
							val = Double.parseDouble(value);
							Method meth = cls.getMethod(methodName, Double.TYPE);
							meth.invoke(sObject, val);
						}
						if (DataType.equals("float")) {
							float val;
							String methodName = "set" + Character.toUpperCase(varName.charAt(0)) + varName.substring(1);
							val = Float.parseFloat(value);
							Method meth = cls.getMethod(methodName, Float.TYPE);
							meth.invoke(sObject, val);
						}
						if (DataType.equals("char")) {
							char val;
							String methodName = "set" + Character.toUpperCase(varName.charAt(0)) + varName.substring(1);
							val = value.charAt(0);
							Method meth = cls.getMethod(methodName, char.class);
							meth.invoke(sObject, val);

						}
						
						if (DataType.equals("long")) {
							long val;
							String methodName = "set" + Character.toUpperCase(varName.charAt(0)) + varName.substring(1);
							val = Long.parseLong(value);
							Method meth = cls.getMethod(methodName, Long.TYPE);
							meth.invoke(sObject, val);
						}
						
						if (DataType.equals("short")) {
							short val;
							String methodName = "set" + Character.toUpperCase(varName.charAt(0)) + varName.substring(1);
							val = Short.parseShort(value);
							Method meth = cls.getMethod(methodName, Short.TYPE);
							meth.invoke(sObject, val);
						}
						
						if (DataType.equals("string")) {
							String methodName = "set" + Character.toUpperCase(varName.charAt(0)) + varName.substring(1);
							Method meth = cls.getMethod(methodName, String.class);
							meth.invoke(sObject, value);
						}
						
						if (DataType.equals("boolean")) {
							
							boolean val;
							String methodName = "set" + Character.toUpperCase(varName.charAt(0)) + varName.substring(1);
							val = Boolean.valueOf(value);
							Method meth = cls.getMethod(methodName, Boolean.TYPE);
							meth.invoke(sObject, val);
						}
					
					}
					 catch (NoSuchMethodException e) {
						System.err.println("Method set"+varName+" not found");
						//e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				xmlLine = fp.readLine();

			}
		}
		
	}
		StoreRestoreHandler.serObject=sObject;
		//System.out.println(StoreRestoreHandler.serObject);
}
}

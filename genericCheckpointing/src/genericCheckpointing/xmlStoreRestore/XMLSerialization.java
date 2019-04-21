package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerStrategy;
import genericCheckpointing.util.SerializableObject;

public class XMLSerialization implements SerStrategy {

	FileProcessor fp;
	SerializeTypes serializeTypes;

	public XMLSerialization(FileProcessor fpIn) {
		fp = fpIn;
		serializeTypes = new SerializeTypes();
	}

	@Override
	public void processInput(SerializableObject sObject) {
		// TODO Auto-generated method stub
		fp.writeLine("<DPSerialization>" + "\n" + "\t");
		Class className = sObject.getClass();
		String name = className.getName();
		fp.writeLine("<complexType xsi:type=\"" + name + "\">" + "\n");
		Field fieldList[] = className.getDeclaredFields();
		for (int i = 0; i < fieldList.length; i++) {

			Field fld = fieldList[i];
			try {
				if (fld.getType() == int.class) {

					String fieldName = fld.getName();
					String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
					Method getterMethod = className.getMethod(methodName);
					Object invokeRet = getterMethod.invoke(sObject);
					String objectVal = invokeRet.toString();
					int value = Integer.parseInt(objectVal);
					String tag = serializeTypes.serializeInt(value, fieldName);
					if (value > 10) {
						fp.writeLine("\t\t" + tag);
					}
				}
				if (fld.getType() == String.class) {

					String fieldName = fld.getName();
					String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
					Method getterMethod = className.getMethod(methodName);
					Object invokeRet = getterMethod.invoke(sObject);
					String objectVal = invokeRet.toString();
					String tag = serializeTypes.serializeString(objectVal, fieldName);
					fp.writeLine("\t\t" + tag);
				}
				if (fld.getType() == boolean.class) {

					String fieldName = fld.getName();
					String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
					Method getterMethod = className.getMethod(methodName);
					Object invokeRet = getterMethod.invoke(sObject);
					String objectVal = invokeRet.toString();
					String tag = serializeTypes.serializeBoolean(objectVal, fieldName);
					fp.writeLine("\t\t" + tag);

				}
				if (fld.getType() == long.class) {

					String fieldName = fld.getName();
					String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
					Method getterMethod = className.getMethod(methodName);
					Object invokeRet = getterMethod.invoke(sObject);
					String objectVal = invokeRet.toString();
					long value = Long.parseLong(objectVal);
					String tag = serializeTypes.serializeLong(value, fieldName);
					if (value > 10) {
						fp.writeLine("\t\t" + tag);
					}
				}

				if (fld.getType() == double.class) {

					String fieldName = fld.getName();
					String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
					Method getterMethod = className.getMethod(methodName);
					Object invokeRet = getterMethod.invoke(sObject);
					String objectVal = invokeRet.toString();
					double value = Double.parseDouble(objectVal);
					String tag = serializeTypes.serializeDouble(value, fieldName);
					if (value > 10) {
						fp.writeLine("\t\t" + tag);
					}
				}

				if (fld.getType() == float.class) {

					String fieldName = fld.getName();
					String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
					Method getterMethod = className.getMethod(methodName);
					Object invokeRet = getterMethod.invoke(sObject);
					String objectVal = invokeRet.toString();
					float value = Float.parseFloat(objectVal);
					String tag = serializeTypes.serializeFloat(value, fieldName);
					fp.writeLine("\t\t" + tag);
				}

				if (fld.getType() == short.class) {

					String fieldName = fld.getName();
					String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
					Method getterMethod = className.getMethod(methodName);
					Object invokeRet = getterMethod.invoke(sObject);
					String objectVal = invokeRet.toString();
					short value = Short.parseShort(objectVal);
					String tag = serializeTypes.serializeShort(value, fieldName);
					fp.writeLine("\t\t" + tag);
				}

				if (fld.getType() == char.class) {

					String fieldName = fld.getName();
					String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
					Method getterMethod = className.getMethod(methodName);
					Object invokeRet = getterMethod.invoke(sObject);
					String objectVal = invokeRet.toString();
					String tag = serializeTypes.serializeChar(objectVal.charAt(0), fieldName);
					fp.writeLine("\t\t" + tag);
				}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				
				e.printStackTrace();
			}
		}

		fp.writeLine("\t</complexType>" + "\n");
		fp.writeLine("</DPSerialization>" + "\n");
	}
}

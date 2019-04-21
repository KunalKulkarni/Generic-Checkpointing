package genericCheckpointing.xmlStoreRestore;

public class SerializeTypes {

	
	public String serializeInt(int value,String tagName) {
	
		String xmlTag="<"+ tagName + " xsi:type=\"xsd:int\">"+ value+ "</"+ tagName+">"+"\n";
		return xmlTag;
	}
	
	public String serializeLong(long value,String tagName) {
		String xmlTag="<"+ tagName + " xsi:type=\"xsd:long\">"+ value+ "</"+ tagName+">"+"\n";
		return xmlTag;
	}
	
	public String serializeString(String value,String tagName) {
		String xmlTag="<"+ tagName + " xsi:type=\"xsd:string\">"+ value+ "</"+ tagName+">"+"\n";
		return xmlTag;
	}
	
	public String serializeBoolean(String value,String tagName) {
		String xmlTag="<"+ tagName + " xsi:type=\"xsd:boolean\">"+ value+ "</"+ tagName+">"+"\n";
		return xmlTag;
	}
	
	public String serializeDouble(double value,String tagName) {
		String xmlTag="<"+ tagName + " xsi:type=\"xsd:double\">"+ value+ "</"+ tagName+">"+"\n";
		return xmlTag;
	}
	
	public String serializeFloat(float value,String tagName) {
		String xmlTag="<"+ tagName + " xsi:type=\"xsd:float\">"+ value+ "</"+ tagName+">"+"\n";
		return xmlTag;
	}
	
	public String serializeShort(short value,String tagName) {
		String xmlTag="<"+ tagName + " xsi:type=\"xsd:short\">"+ value+ "</"+ tagName+">"+"\n";
		return xmlTag;
	}
	
	public String serializeChar(char value,String tagName) {
		String xmlTag="<"+ tagName + " xsi:type=\"xsd:char\">"+ value+ "</"+ tagName+">"+"\n";
		return xmlTag;
	}
}

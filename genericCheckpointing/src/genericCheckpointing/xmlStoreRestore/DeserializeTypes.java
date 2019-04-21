package genericCheckpointing.xmlStoreRestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeserializeTypes {

	public String computeClassName(String line) {
		
		String pattern = "\"(.*?)\">";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		String className = "";
		if (m.find())
			className = m.group(1);
		return className;
	}
		
	public String computeVarName(String line) {
		
		String pat="<(.*?) xsi";
		Pattern varPattern=Pattern.compile(pat);
		Matcher mVar=varPattern.matcher(line);
		String varName="";
		if(mVar.find())
			varName=mVar.group(1);
		
		return varName;
	}
	
	public String computeDataType(String line) {
		
		Pattern typePattern=Pattern.compile("\"xsd:(.*?)\"");
		Matcher typeM=typePattern.matcher(line);
		String DType="";
		if(typeM.find())
			DType=typeM.group(1);
		return DType;
	}
	
	public String computeValue(String line) {
		
		Pattern valPattern=Pattern.compile(">(.*?)<");
		Matcher valM=valPattern.matcher(line);
		String value="";
		if(valM.find())
			value=valM.group(1);
		return value;
	}
}


package utility;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RoBUtilities {
	
	public enum RoBRealm {
	man,god,demon
	}
	public enum RoBSkillRealm {
		man,god,demon,self
	}
	
	public static String PrintIntegerArray(int[] array){
		StringBuilder str = new StringBuilder();
		str.append("[");
		for(int num : array){
			str.append(num);
			str.append(",");
		}
		str.replace(str.length()-1, str.length()-1, "");
		str.append("]");
		
		return str.toString();
	}
}
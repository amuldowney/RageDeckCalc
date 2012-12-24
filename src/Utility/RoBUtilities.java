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
	
	public static Map<int[],Double> CreatePossibilitesTable(){
		HashMap<int[],Double> possibilities = new HashMap<int[],Double>();
		
		possibilities.put(new int[] {1},6.25);
		possibilities.put(new int[] {1,2},21.0);
		possibilities.put(new int[] {1,3},14.06);
		possibilities.put(new int[] {1,4},9.375);
		possibilities.put(new int[] {1,5},6.25);
		possibilities.put(new int[] {1,2,3},12.5);
		possibilities.put(new int[] {1,2,4},9.375);
		possibilities.put(new int[] {1,2,5},7.03);
		possibilities.put(new int[] {1,3,4},6.75);
		possibilities.put(new int[] {1,3,5},4.68);
		possibilities.put(new int[] {1,4,5},3.125);
		
		return possibilities;
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
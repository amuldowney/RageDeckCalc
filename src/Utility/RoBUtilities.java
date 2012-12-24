package utility;

import java.util.HashMap;

public class RoBUtilities {
	
	public enum RoBRealm {
	man,god,demon
	}
	public enum RoBSkillRealm {
		man,god,demon,self
	}
	
	public static HashMap<Double,int[]> CreatePossibilitesTable(){
		HashMap<Double,int[]> possibilities = new HashMap<Double,int[]>();
		
		possibilities.put(6.25, new int[] {1});
		possibilities.put(21.0, new int[] {1,2});
		possibilities.put(14.06, new int[] {1,3});
		possibilities.put(9.375, new int[] {1,4});
		possibilities.put(6.25, new int[] {1,5});
		possibilities.put(12.5, new int[] {1,2,3});
		possibilities.put(9.375, new int[] {1,2,4});
		possibilities.put(7.03, new int[] {1,2,5});
		possibilities.put(6.75, new int[] {1,3,4});
		possibilities.put(4.68, new int[] {1,3,5});
		possibilities.put(3.125, new int[] {1,4,5});
		
		return possibilities;
	}
}
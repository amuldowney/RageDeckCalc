package utility;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.Skill;

public class RoBUtilities {
	
	public enum RoBRealm {
	man,god,demon
	}
	public enum RoBSkillRealm {
		man,god,demon,self
	}
	
	public static String PrintSkillArray(List<Skill> array){
		StringBuilder str = new StringBuilder();
		str.append("[");
		for(Skill skill : array){
			int num = skill.PositionInDeck();
			str.append(num);
			str.append(",");
		}
		str.replace(str.length()-1, str.length()-1, "");
		str.append("]");
		
		return str.toString();
	}
}
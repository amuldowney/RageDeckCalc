package model;

import java.util.ArrayList;
import java.util.List;

public class SkillProcSet {
	
	public List<Skill> skills = new ArrayList<Skill>();
	
	public double ManBoost = 0.0;
	
	public double DemonBoost = 0.0;
	
	public double GodBoost = 0.0;
	
	public double ChanceToProc = 100.0;
	
	public SkillProcSet(Skill skill){
		this.skills.add(skill);
		
	}
	
	public SkillProcSet(List<Skill> skills){
		this.skills.addAll(skills);
	}
	
	
	public SkillProcSet Copy(){
		SkillProcSet ret = new SkillProcSet(this.skills);
		ret.ManBoost = this.ManBoost;
		ret.GodBoost = this.GodBoost;
		ret.DemonBoost = this.DemonBoost;
		ret.ChanceToProc = this.ChanceToProc;
		
		return ret;
		
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(Skill skill : skills){
			str.append(skill.toString());
			str.append(",");
		}
		str.append(" | Gods: "+this.GodBoost);
		str.append(" Man: "+this.ManBoost);
		str.append(" Demons: "+this.DemonBoost);
		str.append(" Chance to Proc: "+this.ChanceToProc);
		
		return str.toString();
	}

}

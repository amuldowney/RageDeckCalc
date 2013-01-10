package model;

import java.util.ArrayList;
import java.util.List;

import utility.RoBUtilities.RoBRealm;

public class SkillProcSet {
	
	public List<Skill> skills = new ArrayList<Skill>();
		
	public double ChanceToProc = 100.0;
	
	public SkillProcSet(Skill skill){
		this.skills.add(skill);
	}
	
	public SkillProcSet(List<Skill> skills){
		this.skills.addAll(skills);
	}
	
	public double GodBoost(){
		return this.GetBoost(RoBRealm.god);
	}
	
	public double DemonBoost(){
		return this.GetBoost(RoBRealm.demon);
	}
	
	public double ManBoost(){
		return this.GetBoost(RoBRealm.man);
	}
	
	public double GetBoost(RoBRealm realm){
		double ret = 1.0;
		for(Skill skill : this.skills){
			ret += skill.GetBoostFactor(realm);
		}
		return ret;
	}
	
	public SkillProcSet Copy(){
		SkillProcSet ret = new SkillProcSet(this.skills);
		ret.ChanceToProc = this.ChanceToProc;
		
		return ret;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(Skill skill : skills){
			str.append(skill.PositionInDeck());
			str.append(",");
		}
		str.append(" | G: "+this.GodBoost());
		str.append(" M: "+this.ManBoost());
		str.append(" D: "+this.DemonBoost());
		str.append(" CtP: "+this.ChanceToProc);
		
		return str.toString();
	}
	
	public String PrintShortHand(){
		StringBuilder str = new StringBuilder();
		str.append("[");
		for(Skill skill : this.skills){
			int num = skill.PositionInDeck();
			str.append(num);
			str.append(",");
		}
		str.append("]");
		str.append(Math.round(this.ChanceToProc)+"%");
		return str.toString();
	}
	
	public double GetChanceToAddNewSkillProc(){
		if(this.skills.size()+1 == 1){
			return 100;
		}else if(this.skills.size()+1 == 2){
			return 50;
		}else if(this.skills.size()+1 == 3){
			return 25;
		}else
			return 0.0;//too many cards
	}

}

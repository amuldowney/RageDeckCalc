package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import utility.RoBUtilities;

public class MinMaxConfiguration {
	
	public enum ConfigurationType{
		min,max
	}
	public ConfigurationType type;
	
	public double ATK;
	
	private List<SkillProcSet> configurations = new ArrayList<SkillProcSet>();
	
	
	public MinMaxConfiguration(ConfigurationType type){
		this.type = type;
		if(type == ConfigurationType.max){
			this.ATK = Double.MIN_VALUE;
		}
		if(type == ConfigurationType.min){
			this.ATK = Double.MAX_VALUE;
		}
	}
	
	
	public void TryToAdd(SkillProcSet skillList, double atk){
		if(type == ConfigurationType.max){
			if(atk >= this.ATK){
				this.SetConfig(skillList, atk);
			}
		}if(type == ConfigurationType.min){
			if(atk <= this.ATK){
				this.SetConfig(skillList, atk);
			}
		}
		
	}
	
	private void SetConfig(SkillProcSet sps, double atk){
		if(atk != this.ATK){
			this.configurations = new ArrayList<SkillProcSet>();
		}
		this.ATK = atk;
		this.configurations.add(sps);
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		double configsChanceToProc = 0.0;
		for(SkillProcSet config : this.configurations){
			configsChanceToProc += config.ChanceToProc;
			str.append(RoBUtilities.PrintSkillArray(config.skills));
			str.append("\n");
		}
		str.append("ATK:"+this.ATK);
		str.append("\n");
		str.append("Chance: "+Math.ceil(configsChanceToProc)+"%");
		str.append("\n");
		return str.toString();
		
	}

}

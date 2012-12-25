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
	
	private List<int[]> configurations = new ArrayList<int[]>();
	
	
	public MinMaxConfiguration(ConfigurationType type){
		this.type = type;
		if(type == ConfigurationType.max){
			this.ATK = Double.MIN_VALUE;
		}
		if(type == ConfigurationType.min){
			this.ATK = Double.MAX_VALUE;
		}
	}
	
	
	public void TryToAdd(int[] pos, double atk){
		if(type == ConfigurationType.max){
			if(atk >= this.ATK){
				this.SetConfig(pos, atk);
			}
		}if(type == ConfigurationType.min){
			if(atk <= this.ATK){
				this.SetConfig(pos, atk);
			}
		}
		
	}
	
	private void SetConfig(int[] pos, double atk){
		if(atk != this.ATK){
			this.configurations = new ArrayList<int[]>();
		}
		this.ATK = atk;
		this.configurations.add(pos);
		
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(int[] config : this.configurations){
			str.append(RoBUtilities.PrintIntegerArray(config));
			str.append("\n");
		}
		str.append("ATK:"+this.ATK);
		str.append("\n");
		return str.toString();
		
	}

}

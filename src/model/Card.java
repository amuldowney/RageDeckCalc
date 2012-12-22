package model;
import java.util.List;

import Utility.RoBUtilities.RoBRealm;


public class Card {
	
	public String name;
	
	public RoBRealm Realm;
	public double ATK;
	public double DEF;
	
	private int skillLevel;
	private double skillPercentBoost;
	private List<RoBRealm>  skillAffects;
	
	public Card(String name,int attack,int def,RoBRealm realm){
		this.name = name;
		this.ATK = attack;
		this.DEF = def;
		this.Realm = realm;
	}
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public void SetSkill(List<RoBRealm> realmsEffected,int percent,int skillLevel){
		this.skillAffects = realmsEffected;
		this.skillPercentBoost = percent/100;
		this.skillLevel=skillLevel;
	}
	
	private double SkillLevelBoost(){
		if(this.skillLevel < 10){
			return (this.skillLevel -1) / 100;
		}else {//Rank 10 skill gives 11%
			return 0.11;
		}
	}
	
	public double GetBoostFactor(RoBRealm realm){
		if(this.HasBoost(realm)){
			return this.SkillLevelBoost() + this.skillPercentBoost;
		}
		else return 0;
	}
	
	public boolean HasBoost(RoBRealm realm){
		return this.skillAffects.contains(realm);
	}
	

}

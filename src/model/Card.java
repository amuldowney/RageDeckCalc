package model;

import utility.RoBUtilities.RoBRealm;


public class Card {
	
	public String name;
	
	public RoBRealm Realm;
	public double ATK;
	
	private Skill skill;
	
	public Card(String realm,String name,int attack){
		this(RoBRealm.valueOf(realm.toLowerCase()),name,attack);
	}
	
	public Card(RoBRealm realm,String name,double attack){
		this.name = name;
		this.ATK = attack;
		this.Realm = realm;
	}
	
	public void SetSkill(Skill skill){
		this.skill = skill;
	}
	
	public void ApplySkill(Skill skillThatProcd){
		this.ATK *= skillThatProcd.GetBoostFactor(this.Realm);
	}
	
	public String toString(){
		return this.name + ":"+this.ATK;
	}

	public void SelfBoost() {
		this.ATK *= this.skill.SelfBoost();
		
	}

}
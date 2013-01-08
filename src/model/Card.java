package model;

import utility.RoBUtilities.RoBRealm;


public class Card {
	
	public String name;
	
	public RoBRealm Realm;
	public double ATK = 0;
	
	private Skill skill;
	private double boostPercent = 1;
	private int positionInDeck;
	
	public Card(String realm,String name,int attack,int cardpos){
		this(RoBRealm.valueOf(realm.toLowerCase()),name,attack,cardpos);
	}
	
	public Card(RoBRealm realm,String name,double attack,int cardpos){
		this.name = name;
		this.ATK = attack;
		this.Realm = realm;
		this.positionInDeck = cardpos;
	}
	
	public void SetSkill(Skill skill){
		this.skill = skill;
	}
	
	public void ApplySkill(Skill skillThatProcd){
		this.boostPercent += skillThatProcd.GetBoostFactor(this.Realm);
	}
	
	
	public String CardPrint(){
		return this.name + ":"+this.ATK;
	}
	
	public String toString(){
		return this.name;
	}

	public void SelfBoost() {
		this.boostPercent += this.skill.SelfBoost();
		
	}
	
	public double GetFinalAttack(){
		return this.ATK *this.boostPercent;
	}
	
	public int GetPosition(){
		return this.positionInDeck;
	}

}

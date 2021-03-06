package model;

import java.util.EnumSet;

import utility.RoBUtilities.RoBRealm;

public class Skill {
	
	private double percentBoost;
	private double skillLevel;
	private EnumSet<RoBRealm> realmsAffected;
	private int positionInDeck;
	
	public Card Card;
	
	public Boolean isSelfBoost = false;
	
	public Skill(int cardpos){
		//NegaSkill for a nonexistant skill
		this.realmsAffected = EnumSet.noneOf(RoBRealm.class);//No realms
		this.isSelfBoost = false;
		this.percentBoost = 0;
		this.skillLevel = 1;
		this.positionInDeck = cardpos;
	}

	public Skill(double percentBoost, double skillLevel,
			String realmsAffected,int cardpos) {
		this.percentBoost = percentBoost;
		this.skillLevel = skillLevel;
		this.ParseRealmAffects(realmsAffected);
		this.positionInDeck = cardpos;
	}
	
	private double SkillLevelBoost(){
		if(this.skillLevel < 10){
			return (this.skillLevel -1) / 100;
		}else {//Rank 10 skill gives 11%
			return 0.11;
		}
	}
	
	public double SkillProcChaneBoost(){
		if(this.skillLevel < 10){
			return (this.skillLevel -1);
		}else {//Rank 10 skill gives 11%
			return 11;
		}
	}
	
	protected double SelfBoost(){
		return 1+this.SkillLevelBoost() + (this.percentBoost/100);
	}
	
	public double GetBoostFactor(RoBRealm realm){
		double ret = 0.0;
		if(this.HasBoost(realm)){
			ret += (this.SkillLevelBoost() + (this.percentBoost/100));
		}
		return ret;
	}
	
	public boolean HasBoost(RoBRealm realm){
		return this.realmsAffected.contains(realm);
	}
	
	private void ParseRealmAffects(String realms){
		for(String realm : realms.split("/")){
			if(realm.compareTo("all")==0){
				this.realmsAffected = EnumSet.of(RoBRealm.man,RoBRealm.god,RoBRealm.demon);
			} else if(realm.compareTo("self")==0){
				this.realmsAffected = EnumSet.noneOf(RoBRealm.class);//No realms
				this.isSelfBoost = true;
			} else{
				this.realmsAffected = EnumSet.of(RoBRealm.valueOf(realm.toLowerCase()));
			}
		}
	}
	
	public void AttachCard(Card card){
		this.Card = card;
	}
	
	public String SkillPrint(){
		StringBuilder str = new StringBuilder();
		if(this.isSelfBoost){str.append("Self");}
		for(RoBRealm realm : this.realmsAffected){
			str.append(realm.toString());
			str.append("/");
		}
		str.append(" ");
		str.append(this.percentBoost+"%");
		str.append(" ");
		str.append("lvl:"+this.skillLevel);
		
		return str.toString();
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		if(this.Card!=null){str.append(this.Card.toString()+" ");}
		str.append(this.percentBoost);
		for(RoBRealm realm : this.realmsAffected){
			str.append(realm.toString());
			str.append("/");
		}
		return str.toString();
	}
	
	public int PositionInDeck(){
		return this.positionInDeck;
	}

}

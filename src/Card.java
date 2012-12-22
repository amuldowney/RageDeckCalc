import java.util.List;

import Utility.RoBUtilities.RoBRealm;


public class Card {
	
	public String name;
	public int ATK;
	public int DEF;
	public RoBRealm Realm;
	
	private int skillLevel;
	private int skillPercent;
	private List<RoBRealm>  skillAffects;
	
	
	public Card(String name,int attack,int def,RoBRealm realm){
		this.name = name;
		this.ATK = attack;
		this.DEF = def;
		this.Realm = realm;
	}
	
	public void SetSkill(List<RoBRealm> realmsEffected,int percent,int skillLevel){
		this.skillAffects = realmsEffected;
		this.skillPercent = percent;
		this.skillLevel=skillLevel;
	}
	

}

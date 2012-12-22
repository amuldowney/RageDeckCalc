package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utility.RoBUtilities.RoBRealm;


public class Deck {
	public int DECK_LIMIT = 5;
	
	private List<Card> cards = new ArrayList<Card>();
	private Map<Card,Double> finalValues = new HashMap<Card,Double>();
	private Map<RoBRealm,Double> finalBoosts = new HashMap<RoBRealm,Double>();
	
	public void CalculateFinalValues(){
		MapBoosts();
		for(Card card : this.cards){
			this.finalValues.put(card,card.ATK*this.finalBoosts.get(card.Realm));
		}
	}
	
	private void MapBoosts(){
		for(RoBRealm realm : RoBRealm.values()){
			this.finalBoosts.put(realm, this.OverallBoost(realm));
		}
	}
	
	public void AddCard(Card card){
		cards.add(card);
	}
	
	private double OverallBoost(RoBRealm realm){
		double boost = 1;
		for(Card card : this.cards){
			boost+=card.GetBoostFactor(realm);
		}
		return boost;
	}
	
}

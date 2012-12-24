package model;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.SizeLimitExceededException;

import utility.CardFileReader;
import utility.RoBUtilities;
import utility.RoBUtilities.RoBRealm;


public class Deck {
	public int DECK_LIMIT = 5;
	
	private List<Card> cards = new LinkedList<Card>();
	private List<Skill> skills = new LinkedList<Skill>();
	
	public Deck(CardFileReader cardFR) throws SizeLimitExceededException{
		for(String cardInfo : cardFR.CardData.values()){
			this.AddNewCard(cardInfo);
		}
	}
	
	public void AddNewCard(String cardInfo) throws SizeLimitExceededException{
		String[] splitCardInfo = cardInfo.split(",");
		RoBRealm realm = Enum.valueOf(RoBRealm.class, splitCardInfo[0]);
		String name = splitCardInfo[1];
		double ATK = Double.parseDouble(splitCardInfo[2]);
		
		Skill skill = new Skill();
		Card card = new Card(realm,name,ATK);
		if(splitCardInfo.length ==7){//Skill Information
			String realmsAffected = (splitCardInfo[3]);
			int skillPercentBoost = Integer.parseInt(splitCardInfo[5].replace("%", ""));
			int skillLevel = Integer.parseInt(splitCardInfo[6]);
			skill = new Skill(skillPercentBoost,skillLevel,realmsAffected);
			skill.AttachCard(card);
			
		}
		card.SetSkill(skill);
		skills.add(skill);
		this.AddCard(card);
	}
	
	private void AddCard(Card card) throws SizeLimitExceededException{
		if(cards.size() < DECK_LIMIT){
		cards.add(card);
		} else{
			throw new SizeLimitExceededException("Too many cards in deck: "+cards.size()+">="+DECK_LIMIT);
		}
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		Double finalValue = 0.0;
		for (Card card : cards) {
			str.append(card.name+" | "+card.ATK);
			str.append("\n");
			finalValue +=card.ATK;
		}
		str.append("Overall:"+finalValue);
		return str.toString();
	}
	
	public double GetATKForPossibility(int[] skillsThatProc){
		for(int procLocation : skillsThatProc){
			procLocation--;//Get to zero index location
			Skill skillThatProcd = this.skills.get(procLocation);
			
			if(!skillThatProcd.isSelfBoost){
				for(Card card : this.cards){
					card.ApplySkill(skillThatProcd);
				}	
			}else{
				skillThatProcd.Card.SelfBoost();
			}
		
		}
		System.out.println(RoBUtilities.PrintIntegerArray(skillsThatProc)+":"+this.ATKValue());
		return this.ATKValue();
	}
	
	public double ATKValue(){
		double ret = 0;
		for(Card card : this.cards){
			ret += card.ATK;
		}
		return ret;
	}
	
}

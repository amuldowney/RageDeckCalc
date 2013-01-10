package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.SizeLimitExceededException;

import utility.BasicLogger;
import utility.CardFileReader;

public class DeckStatistics {
	
	BasicLogger logger = BasicLogger.GetLogger();
	
	private MinMaxConfiguration maxConfigurations = new MinMaxConfiguration(MinMaxConfiguration.ConfigurationType.max);
	private MinMaxConfiguration minConfigurations = new MinMaxConfiguration(MinMaxConfiguration.ConfigurationType.min);
	
	
	
	public DeckStatistics(){
	}
	
	public void NewAverageAndSuch(CardFileReader cardFR) throws SizeLimitExceededException{
		Deck deck = new Deck(cardFR);
		
		SkillProcConfigurationWizard x = new SkillProcConfigurationWizard(deck.skills);
		
		List<SkillProcSet> set = x.GenerateTable();
		
		double ctp  = 0.0;
		for(SkillProcSet sps : set){
			System.out.println(sps.toString());
			ctp += sps.ChanceToProc;
		}
		System.out.println("Overall Chance :"+ctp);
	}
	
	public double FindAverageATK(CardFileReader cardFR) throws SizeLimitExceededException{
		double avg = 0;
		Deck deck = new Deck(cardFR);
		SkillProcConfigurationWizard x = new SkillProcConfigurationWizard(deck.skills);
		List<SkillProcSet> set = x.GenerateTable();
		for(SkillProcSet poss : set){
			deck = new Deck(cardFR);
			double percentToHappen = (poss.ChanceToProc);
			double atkforpos = deck.GetATKForProcConfiguration(poss);
			avg += Math.ceil((percentToHappen/100)*atkforpos);
			
			minConfigurations.TryToAdd(poss, atkforpos);
			maxConfigurations.TryToAdd(poss, atkforpos);
		}
		logger.log("Best Proc Configurations:\n"+maxConfigurations.toString());
		logger.log("Worst Proc Configurations:\n"+minConfigurations.toString());
		return avg;
	}
	
	private Map<int[],Double> CreateBasicPossibilitesTable(){//Assumes no duplicates
		HashMap<int[],Double> possibilities = new HashMap<int[],Double>();
		
		possibilities.put(new int[] {1},6.25);
		possibilities.put(new int[] {1,2},21.0);
		possibilities.put(new int[] {1,3},14.06);
		possibilities.put(new int[] {1,4},9.375);
		possibilities.put(new int[] {1,5},6.25);
		possibilities.put(new int[] {1,2,3},12.5);
		possibilities.put(new int[] {1,2,4},9.375);
		possibilities.put(new int[] {1,2,5},7.03);
		possibilities.put(new int[] {1,3,4},6.75);
		possibilities.put(new int[] {1,3,5},4.68);
		possibilities.put(new int[] {1,4,5},3.125);
		
		return possibilities;
	}
}

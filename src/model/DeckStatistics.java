package model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.SizeLimitExceededException;

import utility.BasicLogger;
import utility.CardFileReader;
import utility.RoBUtilities;

public class DeckStatistics {
	
	BasicLogger logger = BasicLogger.GetLogger();
	
	private MinMaxConfiguration maxConfigurations = new MinMaxConfiguration(MinMaxConfiguration.ConfigurationType.max);
	private MinMaxConfiguration minConfigurations = new MinMaxConfiguration(MinMaxConfiguration.ConfigurationType.min);
	
	
	
	public DeckStatistics(){
	}
	
	public double FindAverageATK(CardFileReader cardFR) throws SizeLimitExceededException{
		double avg = 0;
		for(Entry<int[],Double> poss : this.CreatePossibilitesTable().entrySet()){
			Deck deck = new Deck(cardFR);
			double percentToHappen = (poss.getValue()/100);
			double atkforpos = deck.GetATKForProcConfiguration(poss.getKey());
			avg += Math.ceil(percentToHappen*atkforpos);
			
			minConfigurations.TryToAdd(poss.getKey(), atkforpos);
			maxConfigurations.TryToAdd(poss.getKey(), atkforpos);
		}
		logger.log("Best Proc Configurations:\n"+maxConfigurations.toString());
		logger.log("Worst Proc Configurations:\n"+minConfigurations.toString());
		return avg;
	}
	
	private Map<int[],Double> CreatePossibilitesTable(){
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

package model;

import javax.naming.SizeLimitExceededException;

import utility.CardFileReader;

public class DeckComparison {
	
	private DeckStatistics firstDeckStats;
	
	private DeckStatistics secondDeckStats;
	
	
	
	public DeckComparison(CardFileReader first, CardFileReader second) throws SizeLimitExceededException{
		firstDeckStats = new DeckStatistics();
		double firstavgATK = firstDeckStats.FindAverageATK(first);
		
		secondDeckStats = new DeckStatistics();
		double secondavgATK = firstDeckStats.FindAverageATK(second);
		
		
		//firstDeckStats.
		
		
	}

}

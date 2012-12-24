package utility;


import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import javax.naming.SizeLimitExceededException;


import model.Deck;

public class RoBDeckCalcCL {
	
	BasicLogger logger = BasicLogger.GetLogger();
	
	public static void main(String[] args) throws IOException, SizeLimitExceededException{
		
		
		File cardFile = new File(args[0]);
		
		CardFileReader cardFR = new CardFileReader(cardFile);
		
		double avgATK = RoBDeckCalcCL.FindAverageATK(cardFR);
		
		System.out.println("average:"+avgATK);
		
	}
	
	public static double FindAverageATK(CardFileReader cardFR ) throws SizeLimitExceededException{
		double avg = 0;
		System.out.println(RoBUtilities.CreatePossibilitesTable().entrySet().size());
		for(Entry<int[],Double> poss : RoBUtilities.CreatePossibilitesTable().entrySet()){
			System.out.println("Trying:"+RoBUtilities.PrintIntegerArray(poss.getKey()));
			Deck deck = new Deck(cardFR);
			double percentToHappen = (poss.getValue()/100);
			double atkforpos = deck.GetATKForPossibility(poss.getKey());
			avg += (percentToHappen*atkforpos);
		}
		
		return avg;//hardcoded to possibilitestable size
	}

}

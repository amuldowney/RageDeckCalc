package utility;


import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import javax.naming.SizeLimitExceededException;

import utility.RoBUtilities.RoBRealm;

import model.Card;
import model.Deck;

public class RoBDeckCalcCL {
	
	BasicLogger logger = BasicLogger.GetLogger();
	
	public static void main(String[] args) throws IOException, SizeLimitExceededException{
		
		
		File cardFile = new File(args[0]);
		
		CardFileReader cardFR = new CardFileReader(cardFile);
		
		double avgATK = RoBDeckCalcCL.FindAverageATK(cardFR);
		
		System.out.println("average:"+avgATK);
		
		System.out.println(deck.toString());
	}
	
	public static double FindAverageATK(CardFileReader cardFR ){
		Deck deck = new Deck(cardFR);
		double avg = 0;
		for(Entry<Double,int[]> poss : RoBUtilities.CreatePossibilitesTable().entrySet()){
			avg += poss.getKey() * deck.GetATKForPossibility(poss.getValue());
		}
		
		return avg / 11;//hardcoded to possibilitestable size
	}

}

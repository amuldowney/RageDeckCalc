package utility;


import java.io.File;
import java.io.IOException;

import javax.naming.SizeLimitExceededException;


import model.DeckStatistics;

public class RoBDeckCalcCL {
	
	BasicLogger logger = BasicLogger.GetLogger();
	
	public static void main(String[] args) throws IOException, SizeLimitExceededException{
		
		
		File firstCardFile = new File(args[0]);
		
		//File secondCardFile = new File(args[1]);
		
		CardFileReader cardFR = new CardFileReader(firstCardFile);
		DeckStatistics deckStats = new DeckStatistics();
		deckStats.NewAverageAndSuch(cardFR);
		//double avgATK = deckStats.FindAverageATK(cardFR);
		
		//System.out.println("average:"+avgATK);
		
	}

}

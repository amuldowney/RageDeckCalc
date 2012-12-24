import java.io.File;
import java.io.IOException;

import javax.naming.SizeLimitExceededException;

import model.Deck;
import utility.CardFileReader;


public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SizeLimitExceededException 
	 */
	public static void main(String[] args) throws IOException, SizeLimitExceededException {

		File cardFile = new File(args[0]);
		
		CardFileReader cardFR = new CardFileReader(cardFile);
		Deck deck = new Deck();
		for(String cardInfo : cardFR.CardData.values()){
			deck.AddNewCard(cardInfo);
		}
		//deck.CalculateFinalValues();

	}

}
//
//#cards
//1st=man,Claymore Maid,17759,man,atk,13,5
//2nd=man,Claymore Maid,17759,man,atk,13,2
//3rd=man,Phantom Thief Lupin,15584,all,atk,8,1
//4th=man,Dragon Slayer,17633,self,atk,25,2
//5th=man,Master Samurai,17,17738
package utility;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class CardFileReader {
	
	public Map<String,String>CardData = new LinkedHashMap<String,String>();
	
	public CardFileReader(File file) throws IOException{
		this.ReadInFile(file);
	}
	
	
	public void ReadInFile(File file) throws IOException{
		BufferedReader cardReader = new BufferedReader(new FileReader(file));
		
		while(cardReader.ready()){
			String[] line = cardReader.readLine().split("=");
			if(!line[0].startsWith("#")){//Ignore comment lines
				CardData.put(line[0],line[1]);
			}
			
		}
	}
	
	public String Get(String ident){
		return this.CardData.get(ident);
	}
	

}

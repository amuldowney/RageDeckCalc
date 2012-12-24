package utility;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BasicLogger {
	private static BasicLogger logger = null;
	
	private StringBuilder log = new StringBuilder();
	private StringBuilder endOflog = new StringBuilder();
	
	private HashMap<String,Long> timingList = new HashMap<String,Long>();
	
	public static enum LoggingLevel{
		info,error
	}
	
	protected BasicLogger(){
	}
	
	public static BasicLogger GetLogger(){
		if (logger == null){
			logger = new BasicLogger();
		}
		return logger;
	}
	
	public void log(String logs){
		log.append(logs);
		log.append(" \\n");
		System.out.println(logs);
	}
	
	public void logToEnd(String log){
		endOflog.append(log);
		endOflog.append(" \\n");
	}
	
	public String toString(){
		return log.toString() + endOflog.toString();
	}
	
	public void StartTimer(String name){
		timingList.put(name,System.nanoTime());
	}
	
	public long EndTimer(String name){
		if(timingList.keySet().contains(name)){
			timingList.put(name,System.nanoTime() - timingList.remove(name));
			return timingList.remove(name);
		}
		return 0;
	}
	
	public void EndAndLogTimer(String name){
		if(timingList.keySet().contains(name)){
			timingList.put(name,System.nanoTime() - timingList.remove(name));
			this.logToEnd(name+" took "+TimeUnit.NANOSECONDS.toMinutes(timingList.get(name))+"minutes to complete");
		}
	}

}
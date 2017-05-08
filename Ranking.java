import java.util.HashMap;
import java.util.TreeMap;

public class Ranking {

	
	public int getCount(String word,TreeMap<String, Integer> frequencyData){
		
		
		if (frequencyData.containsKey(word)){
			
			return frequencyData.get(word);

		}
		else{
			
			return 0;
		}
	}
	
	public void printAllCounts(TreeMap<String, Integer> frequencyData)
	{
		System.out.println("-----------------------------------------------");
        System.out.println("    Occurrences    Word");

        for(String word : frequencyData.keySet( ))
        {
            System.out.printf("%15d    %s\n", frequencyData.get(word), word);
        }

        System.out.println("-----------------------------------------------");
	}
	
	

}
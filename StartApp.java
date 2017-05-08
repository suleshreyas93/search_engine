import java.util.*;
public class StartApp {

	//Starting point of the application
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		Ranking rank = new Ranking();
		TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>();
		
		//links to read data from
		String[] links = {"https://www.jsoup.org","http://www.whatis.techtarget.com/definition/interface","http://www.linfo.org/physical_layer.html"};
		Data d = new Data();
		
		//looping through the above 3 links and calling the function to scrape only paragraphs through them.
		//Below is the call to store the words and find the word occurences.
		for(int i = 0; i < links.length; i++)
		{
			
			d.getData(links[i],frequencyData);
		}
	
		//Printing the counts for all words.
		rank.printAllCounts(frequencyData);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the word you want to search : ");
		String word = scan.next();
		
		//Below looping is done to find through each page whether the requested word  is present or not with their respective count. 
		for(int i = 0; i < links.length; i++)
		{
			
			d.getData(links[i],word);
		}
		

	}

}

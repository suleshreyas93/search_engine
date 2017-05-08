import java.util.ArrayList;
import java.util.TreeMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * class to scrape through the input links
 */
public class Data {

	//Function will be called each time for the no. of input links.
	//Search for the word through trie.
	//Display each word count through their respective maps found in the respective pages 
	public void getData(String link,String searchWord)
	{
		int count = 0;
		try
		{
			
			Trie myTrie = new Trie();
			StopWords sw = new StopWords();
			
			//Using the jsoup to read through each webpage.
			Document document = Jsoup.connect(link).get();
			
			//Reading only the paragraph tags from the specified link.
			Elements paragraph = document.select("p");
			
			Ranking rank = new Ranking();
			TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>();
			
			//Looping through all the paragraphs
			for(Element para : paragraph)
			{
				String p = para.text();
				p = p.replaceAll("[,.!?:;()-]", "\\s");//removing all the punctuations and replacing with blank spaces.
				
				
				//for each of the above paragraph extract individual words and insert them in trie data structure.
				for(int i = 0; i < p.length(); i++)
				{
					int indexOfSpace = p.indexOf(" ");
					//System.out.println(indexOfSpace);
					String word = p.substring(0, indexOfSpace);
					//System.out.println(word);
					
					
					
					
						//System.out.println(p);
						
							
							
							
						

							myTrie.insert(word.toLowerCase());
							count = rank.getCount(word, frequencyData) + 1 ;
							frequencyData.put(word, count);
							p = p.substring(indexOfSpace+1,p.length()-1);
						
						
					
					
				
				}
			
				
				
			}
			int temp = rank.getCount(searchWord, frequencyData);
			
			System.out.println(searchWord+" found in "+ link + " "+myTrie.search(searchWord));
			System.out.println(searchWord+" occurred "+temp+" times ");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
			
	}
	
	//Function overloaded to calculate frequency of all words.
	public void getData(String link,TreeMap<String, Integer> frequencyData)
	{
		int count = 0;
		try
		{
			
			Trie myTrie = new Trie();
			StopWords sw = new StopWords();
			Document document = Jsoup.connect(link).get();
			Elements paragraph = document.select("p");
			Ranking rank = new Ranking();
			
			for(Element para : paragraph)
			{
				String p = para.text();
				p = p.replaceAll("[,.!?:;()-]", "\\s");
				
				
				
				
				for(int i = 0; i < p.length(); i++)
				{
					int indexOfSpace = p.indexOf(" ");
					
					String word = p.substring(0, indexOfSpace);
					
					
					
					
						
						
						
					
			
						myTrie.insert(word.toLowerCase());
						count = rank.getCount(word, frequencyData) + 1 ;
						frequencyData.put(word, count);
						p = p.substring(indexOfSpace+1,p.length()-1);
					
						
					
					
					
				
				}
			
				
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
			
	}

}

import java.io.File;
import java.util.Scanner;
public class StopWords {
	
	public boolean isStopWord(String word)
	{
		try
		{
			Scanner scan = new Scanner(new File("Stopwords.txt"));
	        while(scan.hasNext())
	        {
	            String str = scan.next();
	            if(word.equalsIgnoreCase(str))
	            {
	            	return true;
	            }
	        }
	        scan.close();
	        return false;
				
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return false;
		
		
	}
	
	
	

}

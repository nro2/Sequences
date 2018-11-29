import java.util.*;
import java.io.*;

class Driver
{

    public static void main(String[] args) {
	
	List<String> list = new ArrayList<String>();
	if (args.length != 1) 
	{
	    System.out.println("You didn't provide an input file name.");
	} 
	else 
	{
	    try 
	    {
		Scanner sc = new Scanner(new File(args[0]));
		while (sc.hasNextLine()) 
		{
		    String line = sc.nextLine();
		    list.add(line);
		}
	    } 
	    catch (Exception e) 
	    {
		System.out.println("Error: " + e.getMessage());
	    }

	}

	SequenceFinder sf = new SequenceFinder();
	sf.findSeq(list);
	sf.ArraySort();
	sf.printSequence(list);
	}
}

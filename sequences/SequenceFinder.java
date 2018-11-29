import java.util.*;
import java.io.*;

public class SequenceFinder
{
	private static int SIZE = 6;
	private Sequence[] seq;
	private int seqNum = 0;

	public SequenceFinder()
	{
		seq = new Sequence[SIZE];
		for(int i = 0; i < SIZE; i++)
		{
			seq[i] = new Sequence();
		}
	}	

	public void findSeq(List<String> list)
	{
		boolean inSequence = false;
		for(int i = 0; i < list.get(0).length(); i++) //traverse string 0
		{
			boolean repeat = true;
			int j = 0;
			while(repeat == true && j <= list.size())
			{
				if(j == list.size() && inSequence == false) //matched the character all the way down for first time
				{
					seq[seqNum].setStart(i);
					inSequence = true;
					repeat = false;
				}
				if(j == list.size() && inSequence == true) // matched the character all the way down and in sequence, checking next value
				{
					repeat = false;
				}
				if(j != list.size() && list.get(0).charAt(i) != list.get(j).charAt(i) && inSequence == false) //did not match and not in sequence, moving on
				{
					repeat = false;
				}
				if(j != list.size() && list.get(0).charAt(i) != list.get(j).charAt(i) && inSequence == true) //first non match after in sequence, breaking sequence,incrementing seqNum
				{
					seq[seqNum].setEnd(i);
					seqNum++;
					inSequence = false;
					repeat = false;
				}
			j++;
			}
		}
	}

	public void ArraySort()
	{
		Arrays.sort(seq, new Comparator<Sequence>()
		{
			@Override
			public int compare(Sequence s1, Sequence s2)
			{
				return (s2.getEnd() - s2.getStart()) - (s1.getEnd() - s1.getStart());
			}
		});
	}

	public void printSequence(List<String> list)
	{
		for(int i = 0; i < SIZE; i++)
		{
			System.out.println(list.get(0).substring(seq[i].getStart(), seq[i].getEnd()) + " [starting at " + seq[i].getStart() + "]");
		}
	}
}






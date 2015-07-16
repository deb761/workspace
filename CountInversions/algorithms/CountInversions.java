package algorithms;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.Scanner;

// A class to hold the sorted array and the count of inversions
public class CountInversions
{
	/* Construct the class by getting the raw data from a text file */
	CountInversions(String fpath1) throws IOException
	{
		System.out.println(fpath1);
		FileReader file1 = new FileReader(fpath1);
//		char[] line = new char[7];
//		file1.read(line);
//		System.out.println(line);
		Scanner scanner = new Scanner(file1);
		//scanner.useDelimiter("\n");
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (scanner.hasNextInt())
		{
			int next = scanner.nextInt();
			//String next = scanner.next();
			System.out.println(next);
			list.add(next);
		}
		scanner.close();
		raw = new int[list.size()];
		for (int i = 0; i< raw.length; i++) raw[i] = (int) list.get(i);

		count = 0;
		SortAndCount(raw);
	}
	private int[] raw;
	private int[] sorted;
	private long count; // number of inversions
	
	public long getCount() { return count; }
	public int[] getSorted() { return sorted; }
	public int getLength() { return raw.length; }
	
	/* Construct the class by getting the raw data from an array of integers */
	CountInversions(int[] raw)
	{
		this.raw = raw;
		count = 0;
		SortAndCount(raw);
	}
	
	CountInversions(int[] ints, int start, int end)
	{
		raw = new int[end - start + 1];
		for (int i = 0, j = start; j <= end; i++, j++) raw[i] = ints[j];
		count = 0;
		SortAndCount(raw);
	}
	
	protected void SortAndCount(int[] raw)
	{
		if (raw.length == 1)
		{
			sorted = raw;
			return;
		}
		else
		{
			int srt2 = raw.length / 2;
			int end1 = srt2 - 1;
			int end2 = raw.length - 1;
			CountInversions sub1 = new CountInversions(raw, 0, end1);
			CountInversions sub2 = new CountInversions(raw, srt2, end2);
			MergeAndCount(sub1, sub2);
		}
	}
	protected void MergeAndCount(CountInversions sub1o, CountInversions sub2o)
	{
		int[] sub1 = sub1o.getSorted();
		int[] sub2 = sub2o.getSorted();
		sorted = new int[raw.length];
		count = sub1o.getCount() + sub2o.getCount();
		
		int i = 0;
		int j = 0;
		for (int k = 0; k < sorted.length; ++k)
		{
			if (i >= sub1.length)
			{
				sorted[k] = sub2[j];
				j++;
			}
			else if (j >= sub2.length)
			{
				sorted[k] = sub1[i];
				i++;
			}
			else if (sub1[i] <= sub2[j])
			{
				sorted[k] = sub1[i];
				i++;
			}
			else
			{
				sorted[k] = sub2[j];
				j++;
				count += (sub1.length - i);
			}
		}
	}
}

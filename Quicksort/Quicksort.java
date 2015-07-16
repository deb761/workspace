import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author deb
 *
 */
public class Quicksort
{

	/* Construct the class by getting the raw data from a text file */
	Quicksort(String fpath) throws IOException
	{
		System.out.println(fpath);
		FileReader file1 = new FileReader(fpath);
		Scanner scanner = new Scanner(file1);
		//scanner.useDelimiter("\n");
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (scanner.hasNextInt())
		{
			int next = scanner.nextInt();
//			System.out.println(next);
			list.add(next);
		}
		scanner.close();
		data = new int[list.size()];
		for (int i = 0; i< data.length; i++) data[i] = (int) list.get(i);

		count = 0;
		Sort(0, data.length);
	}
	private int[] data;
	private long count; // number of inversions
	
	public long getCount() { return count; }
	public int[] getSorted() { return data; }
	public int getLength() { return data.length; }
	
	/* Construct the class by getting the raw data from an array of integers */
	Quicksort(int[] raw)
	{
		this.data = raw;
		count = 0;
		Sort(0, raw.length);
	}
	private void Sort(int start, int end)
	{
		if (start >= (end - 1)) return;
		
		int pi = SelectPivot3(start, end); // pivot index
		int pivot = data[pi]; // pivot value
		Swap(start, pi);
		int k = start + 1;
		for (int i = start + 1; i < end; i++)
		{
			if (data[i] < pivot)
			{
				Swap(i, k);
				k++;
			}
		}
		Swap(start, k - 1);
		count += (end - start - 1);
		
		Sort(start, k - 1);
		Sort(k, end);
	}
	
	private void Swap(int i, int j)
	{
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	private int SelectPivot1(int start, int end)
	{
		return start;
	}
	private int SelectPivot2(int start, int end)
	{
		return end - 1;
	}
	private int SelectPivot3(int start, int end)
	{
		int i1 = start;
		int i2 = (end + start - 1) / 2;
		int i3 = end - 1;
		ArrayList<Integer> order = new ArrayList<Integer>();
		order.add(data[i1]);
		order.add(data[i2]);
		order.add(data[i3]);
		order.sort(null);
		if (order.get(1) == data[i1]) return i1;
		if (order.get(1) == data[i2]) return i2;
		if (order.get(1) == data[i3]) return i3;
		return 0;
	}
	
}

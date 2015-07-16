import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * This class tracks the median on a stream of integers
 */

/**
 * @author deb
 *
 */
public class MedianMaintenance
{
	PriorityQueue<Integer> hmin = new PriorityQueue<Integer>(Collections.reverseOrder());
	PriorityQueue<Integer> hmax = new PriorityQueue<Integer>();
	LinkedList<Integer> medians = new LinkedList<Integer>();
	long sum = 0;
	/**
	 * 
	 */
	public MedianMaintenance(String path) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		Scanner scanner = new Scanner(br);
		while (scanner.hasNext())
		{
			int val = scanner.nextInt();
			// we will insert the first element in hmax
			if (hmin.size() == 0)
			{
				medians.add(val);
				hmin.add(val);
				sum = (long)val;
				continue;
			}
			else if (hmax.size() == 0) // second element
			{
				if (hmin.peek() < val) // we're good, put -val in hmax
				{
					hmax.add(val); // the 2nd value doesn't change the median
				}
				else
				{
					hmax.add(hmin.poll());
					hmin.add(val);
				}
			}
			else if (val < hmin.peek())
			{
				hmin.add(val);
			}
			else if (val > hmax.peek())
			{
				hmax.add(val);
			}
			else
			{
				hmin.add(val);
			}
			// we want hmin's size to be equal to or 1 more than hmax
			if (hmax.size() > hmin.size())
				hmin.add(hmax.poll());
			else if (hmin.size() - 1 > hmax.size())
				hmax.add(hmin.poll());
			
			sum += (long)hmin.peek();
		}
		scanner.close();
	}
	public long getSum()
	{
		return sum % 10000;
	}

}

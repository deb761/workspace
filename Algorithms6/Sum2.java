import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/*
 * This class hosts the algorithm to find the number of pairs of number from the input array that sum to
 * a given value, T.
 */
public class Sum2
{
	HashList A = new HashList((int) 199);
	int m;
	int middle;
	long tmin;
	long tmax;
	int sum2;
	/*
	 * Construct the SUM-2 algorithm from an input file
	 */
	public Sum2(String path, int tmin, int tmax) throws IOException
	{
		setBasics(tmin, tmax);
		HashMap<Long, Boolean> vals = new HashMap<Long, Boolean>();

		BufferedReader br = new BufferedReader(new FileReader(path));
		Scanner scanner = new Scanner(br);
		while (scanner.hasNext())
		{
			long id1 = scanner.nextLong();
			//A.put((id1 / m, id1);
			vals.put(id1, true);
		}
		scanner.close();
	
		//sum2 = findSums();
		HashMap<Long, Boolean> summap = new HashMap<Long, Boolean>();
		for (Long key : vals.keySet())
		{
			for (long b = (tmin - key); b <= (tmax - key); b++)
			{
				if (vals.containsKey(b) && (key != b))
					summap.put(key + b, true);
			}
		}
		sum2 = summap.keySet().size();
	}

	private void setBasics(int tmin, int tmax)
	{
		this.tmin = tmin;
		this.tmax = tmax;
		m = tmax - tmin;
		middle = (tmax + tmin) / 2 / m;
	}
	
	private int findSums()
	{
		HashMap<Integer, Boolean> summap = new HashMap<Integer, Boolean>();
		for (int key : A.getKeys())
		{
			//if (key > middle) break;
			Set<Integer> setb = A.get(key);
			Set<Integer> set1a = A.get(-key);
			//Set<Integer> set2a = A.get(1 - key);
			
			for (Integer b : setb)
			{
//				if (set1a != null)
//					checkKeyVals(summap, set1a, b);
//				if (set2a != null)
//					checkKeyVals(summap, set2a, b);
				for (int key2 = -key; key2 <= 1 - key; ++key2)
				{
					set1a = A.get(key2);
					if (set1a != null)
						checkKeyVals(summap, set1a, b);
				}
			}
			
		}
		return summap.keySet().size();
	}

	private void checkKeyVals(HashMap<Integer, Boolean> summap,
			 Set<Integer> set, Integer b)
	{
		for (Integer a : set)
		{
			if (a == b) continue;
			int sum = a + b;
			if ((sum >= tmin) && (sum <= tmax))
				summap.put(sum, true);
		}
	}

	public Sum2(int[] values, int tmin, int tmax)
	{
		setBasics(tmin, tmax);

		for (int val : values)
			A.put(val / m, val);

		sum2 = findSums();
	}

	public int getSum2()
	{
		return sum2;
	}
}

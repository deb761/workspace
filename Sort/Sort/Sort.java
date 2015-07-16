package Sort;

public class Sort
{
	public static void sort(String[] a)
	{
		sort(a, 0);
	}
	private static void sort(String[] a, int start)
	{
		if (start == a.length) return;
		int minDex = IndexOfSmallest(a, start);
		swap(a, start, minDex);
		sort(a, start + 1);
	}
	public static int IndexOfSmallest(String[] a, int start)
	{
		int minDex = start;
		for (int i=start+1; i<a.length; i++)
		{
			if (a[i].compareTo(a[minDex]) < 0)
				minDex = i;
		}
		return minDex;
	}
	private static void swap(String[] a, int i, int j)
	{
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void print()
	{}
	
}
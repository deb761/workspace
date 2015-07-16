package algorithms;

import java.io.IOException;

public class TestSortAndCount
{
	public static void main(String[] args) throws IOException
	{
		testSort();
	}
	public static void testSort() throws IOException
	{
		int[] input = new int[] {1, 3, 5, 2, 4, 6};
		int[] expected = new int[] {1, 2, 3, 4, 5, 6};
		
		CountInversions counted = new CountInversions(input);
		int[] result = counted.getSorted();
		long count = counted.getCount();

		String path = "IntegerArray.txt";
		System.out.println(String.format("Testing %s", path));
		CountInversions count2 = new CountInversions(path);
		
		System.out.println(String.format("The length of the array is %d, the number of inversions is %d",
				count2.getSorted().length, count2.getCount()));
	}

}

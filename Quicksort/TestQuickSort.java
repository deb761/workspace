import java.io.IOException;


/**
 * 
 */

/**
 * @author deb
 *
 */
public class TestQuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		testSort();
	}
	public static void testSort() throws IOException
	{
		int[] input = new int[] {1, 3, 5, 2, 4, 6};
		//int[] expected = new int[] {1, 2, 3, 4, 5, 6};
		
		Quicksort counted = new Quicksort(input);
		System.out.println(String.format("The length of the array is %d, the number of comparisons is %d",
				counted.getSorted().length, counted.getCount()));

		input = new int[] {3, 8, 2, 5, 1, 4, 7, 6};
		counted = new Quicksort(input);
		System.out.println(String.format("The length of the array is %d, the number of comparisons is %d",
				counted.getSorted().length, counted.getCount()));


		String path = "Quicksort.txt";
		System.out.println(String.format("Testing %s", path));
		Quicksort count2 = new Quicksort(path);
		
		System.out.println(String.format("The length of the array is %d, the number of comparisons is %d",
				count2.getSorted().length, count2.getCount()));
	}

}

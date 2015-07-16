package Sort;

public class TestSort
{

	public static void main(String[] args)
	{
		testSort();
	}
	public static void testSort()
	{
		String[] input = new String[]{"banana", "is", "our", "god"};
		String[] expected = new String[]{"banana", "god", "is", "our"};
		Sort.sort(input);
		junit.framework.Assert.assertEquals("Array lengths do not match",
				+ expected.length, input.length);
		for (int i=0; i<expected.length; i++)
		{
			junit.framework.Assert.assertEquals(expected[i], input[i]);
		}
		System.out.println("Successful test");
	}
}

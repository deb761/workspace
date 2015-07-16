import java.io.IOException;

/**
 * Test SUM-2 and Median Maintenance algorithm
 */

/**
 * @author deb
 *
 */
public class TestSum2
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
/*		Sum2 sum2 = new Sum2(new int[] {4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, -10000, 10000);
		
		System.out.println(String.format("%d", sum2.getSum2()));
		
		sum2 = new Sum2(new int[] {-10001, 1, 2, -10001}, -10000, 10000);
		System.out.println(String.format("%d", sum2.getSum2()));
		
		sum2 = new Sum2(new int[] {-10001, 1, 2, -10001, 9999}, -10000, 10000);
		System.out.println(String.format("%d", sum2.getSum2()));
		
		sum2 = new Sum2(new int[] {1, 1, 2, 3, 4, 6, 8}, -10000, 10000);
		System.out.println(String.format("%d", sum2.getSum2()));
		
		sum2 = new Sum2("test1.txt", -10000, 10000);
		System.out.println(String.format("%d", sum2.getSum2()));
		
		sum2 = new Sum2("2sum.txt", -10000, 10000);
		System.out.println(String.format("%d", sum2.getSum2()));
		*/
		MedianMaintenance mm = new MedianMaintenance("testmm1.txt");
		System.out.println(String.format("%d", mm.getSum()));
		
		mm = new MedianMaintenance("testmm2.txt");
		System.out.println(String.format("%d", mm.getSum()));
		
		mm = new MedianMaintenance("Median.txt");
		System.out.println(String.format("%d", mm.getSum()));
	}

}

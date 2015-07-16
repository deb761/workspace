import java.io.IOException;

/**
 * Test MinCut algorithm
 */

/**
 * @author deb
 *
 */
public class TestMinCut
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		MinCut mincut = new MinCut("test.txt");

		mincut = new MinCut("kargerMinCut.txt");
		System.out.println(String.format("The minimum cut is %d",
				mincut.getMinCut()));
	}

}

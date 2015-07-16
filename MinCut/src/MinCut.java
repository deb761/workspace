import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author deb
 *
 */
public class MinCut
{
	private int minCut;
	public int getMinCut()
	{
		return minCut;
	}
	/**
	 * Create the MinCut object from a file
	 */
	public MinCut(String path) throws IOException
	{
		Grid grid = new Grid(path);
		
		int n = grid.getVertices().size();
		minCut = (n * (n - 1)) / 2;
		int repeats = n * n * (int)Math.round(Math.log((double)n));
		// Now, apply the edge elimination algorithm
		for (int i = 1; i < repeats; i++)
		{
			int cut = grid.Contract();
			if (cut < minCut)
				minCut = cut;
		}
	}
}

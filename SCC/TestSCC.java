import java.io.IOException;

/**
 * Test SCC algorithm
 */

/**
 * @author deb
 *
 */
public class TestSCC
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		Grid grid = new Grid("test.txt");
		grid.findSCCs();
		for (SCC scc : grid.getSccs())
		{
			System.out.println(String.format("The SCC head is %d, and its size is %d",
				scc.getLeader().getId(), scc.size()));
		}

		grid = new Grid("SCC.txt");
		grid.findSCCs();
		for (int i = 0; i < 5 && i < grid.getSccs().size(); i++)
		{
			SCC scc = grid.getSccs().get(i);
			System.out.println(String.format("The SCC head is %d, and its size is %d",
					scc.getLeader().getId(), scc.size()));
		}
	}

}

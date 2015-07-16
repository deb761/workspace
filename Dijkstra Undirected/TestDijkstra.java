import java.io.IOException;

/**
 * Test Dijkstra algorithm
 */

/**
 * @author deb
 *
 */
public class TestDijkstra
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		test("test", 1);
		
		test("medium", 1);

		test("large", 13);

		test("largest", 28);

		Grid dijk = new Grid("dijkstraData.txt");
		dijk.findShortest(dijk.getVertices().get(1));
		
		printDistances(dijk, new int[] { 10,30,50,80,90,110,130,160,180,190 });
		int[] vertices = new int[] { 7,37,59,82,99,115,133,165,188,197 };
		printDistances(dijk, vertices);
	}
	private static void printDistances(Grid dijk, int[] vertices) {
		System.out.println("Problem results:");
		for (int idx : vertices)
		{
			System.out.print(String.format("%d,", dijk.getVertices().get(idx).getDist()));
		}
		System.out.println();
	}
	/*
	 * Run a test case
	 */
	private static void test(String name, int id) throws IOException
	{
		Grid dijk = new Grid(String.format("%s.txt", name));
		dijk.findShortest(dijk.getVertices().get(id));
		System.out.println(String.format("%s test case results:", name));
		for (Vertex v : dijk.getVertices().values())
		{
			System.out.print(String.format("%d,", v.getDist()));
		}
		System.out.println();
	}

}

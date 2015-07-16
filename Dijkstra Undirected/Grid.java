import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * A grid consisting of vertices and edges
 */

/**
 * @author deb
 *
 */
public class Grid
{
	private HashMap<Integer, Vertex> vertices = new HashMap<Integer, Vertex>();
	

	public HashMap<Integer, Vertex> getVertices()
	{
		return vertices;
	}
	/**
	 * Create the Grid object from a file.  The file is expected to be a text file
	 * with each row representing the edges connecting to a vertex.
	 * The row is in the format:
	 * v v1,w1 v2,w2 v3,w3 ... vn,wn
	 * Where:
	 * v = vertex identifier
	 * v1, v2, v3, ... vn are vertices v is directly connected to
	 * w1, w2, w3, ... wn are edge weights between v and v1, v2, v3, etc.
	 * Each number is separated by a whitespace.
	 */
	@SuppressWarnings("resource")
	public Grid(String path) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while ((line = br.readLine()) != null)
		{
			Scanner scanner = new Scanner(line).useDelimiter("[\t ,]");
			
			int id1 = scanner.nextInt(); // this is the source vertex
			// Add the vertex to the array if it is not already there
			Vertex v1 = addVertex(id1);
			
			try
			{
				while (true)
				{
					int id2 = scanner.nextInt(); // this is the other end
					int weight = scanner.nextInt(); // this is the edge weight
					// Add the vertex to the array if it is not already there
					Vertex v2 = addVertex(id2);
					// create the edge
					addEdge(v1, v2, weight);
				}
			}
			catch (Exception e) {}
			finally
			{
				scanner.close();
			}
		}
		br.close();
	}
	/**
	 * Add a vertex to the grid if it doesn't already exist.  Return the vertex.
	 */
	private Vertex addVertex(int id)
	{
		Vertex vertex = null;
		if (!vertices.containsKey(id))
		{
			vertex = new Vertex(id);
			vertices.put(id, vertex);
		}
		else
			vertex = vertices.get(id);
		
		return vertex;
	}
	/**
	 * Add the edge terminating in V1 and V2 to the grid.
	 */
	private Edge addEdge(Vertex v1, Vertex v2, int weight)
	{
		Edge edge = null;
		if (v1.hasEdgeWith(v2))
			edge = v1.getEdgeWith(v2);
		else if (v2.hasEdgeWith(v1))
			edge = v2.getEdgeWith(v1);
		else
		{
			edge = new Edge(v1, v2, weight);
			v1.addEdge(v2, edge);
			v2.addEdge(v1, edge);
		}
		return edge;
	}
	/**
	 * Find the shortest path between vertex V1 and the rest of the vertices.
	 */
	public void findShortest(Vertex s)
	{
		boolean[] a = new boolean[vertices.size() + 1];
		for (boolean val : a) val = false;
		
		PriorityQueue<Vertex> heap = new PriorityQueue<Vertex>();
		s.setDist(0);
		for (Vertex v : vertices.values()) heap.add(v);
		
		while (!heap.isEmpty())
		{
			Vertex vx = heap.remove();
			if (vx.getDist() == Vertex.MAXDIST) break;

			a[vx.getId()] = true;
			
			HashMap<Vertex, Edge> edges = vx.getEdges();
			int dist = vx.getDist();
			for (Vertex v : edges.keySet())
			{
				if (!a[v.getId()])
				{
					v.setDist(dist + edges.get(v).getWeight());
					heap.remove(v);
					heap.add(v);
				}
			}
		}
	}
}
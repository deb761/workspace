import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
	// An ArrayList of the vertices, with vertex 1 at index 0, so that
	// the length of the ArrayList is the number of vertices
	ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	// An ArrayList of the vertices.  Since vertices don't have an index
	// associated with them, we will use the whole ArrayList.
	ArrayList<Edge> edges = new ArrayList<Edge>();

	public ArrayList<Vertex> getVertices()
	{
		return vertices;
	}
	public void setVertices(ArrayList<Vertex> vertices)
	{
		this.vertices = vertices;
	}
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
	public void setEdges(ArrayList<Edge> edges)
	{
		this.edges = edges;
	}
	public int getN() { return vertices.size(); }
	public int getM() { return edges.size(); }
	/**
	 * Create the Grid object from a file
	 */
	public Grid(String path) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while ((line = br.readLine()) != null)
		{
			Scanner scanner = new Scanner(line);
			int id1 = scanner.nextInt();
			
			// Add this vertex to the array if it is not already there
			Vertex v1 = addVertex(id1);
			while (scanner.hasNextInt())
			{
				int id2 = scanner.nextInt();
				Vertex v2 = addVertex(id2);
				// add the edge
				Edge edge = addEdge(v1, v2);
				v1.getEdges().add(edge);
			}
			scanner.close();
		}
		br.close();
	}
	private Vertex addVertex(int id)
	{
		Vertex vertex = null;
		while (vertices.size() < id) vertices.add(null);
		if (vertices.get(id - 1) == null)
		{
			vertex = new Vertex(id);
			vertices.set(id - 1, vertex);
		}
		else
			vertex = vertices.get(id - 1);
		
		return vertex;
	}
	/*
	 * Add the edge terminating in V1 and V2 to the grid.
	 */
	private Edge addEdge(Vertex v1, Vertex v2)
	{
		Edge edge = null;
		if (v1.getId() < v2.getId())
		{
			edge = new Edge(v1, v2);
			edges.add(edge);
		}
		else
		{
			for (Edge e : edges)
			{
				if ((e.getV1() == v2) && (e.getV2() == v1))
				{
					edge = e;
					break;
				}
			}
		}
		return edge;
	}
	/*
	 * Use the compression algorithm to reduce to two vertices, then return the
	 * number of edges in the cut.
	 */
	public int Contract()
	{
		Grid smaller = Copy();
		int n = smaller.getN();
		while (n > 2)
		{
			smaller = new Grid(smaller);
			n = smaller.getN();
		}
		return smaller.getM();
	}
	/* 
	 * Construct a contracted grid from the original.
	 */
	Grid(Grid grid)
	{
		// select an edge to contract
	    int randomNum = rand.nextInt(grid.edges.size() - 1);
	    Edge edge = grid.edges.get(randomNum);
	    Vertex v1 = edge.getV1();
	    Vertex v2 = edge.getV2();
	    // Add the vertices that are not being merged
	    for (Vertex v : grid.vertices)
	    {
	    	if ((v != v1) && (v != v2))
	    		vertices.add(v);
	    }
	    // Add the merged vertices
	    Vertex merged = new Vertex(edge, grid.vertices.get(grid.vertices.size() - 1).getId() + 1);
	    vertices.add(merged);
	    
	    // Create the new edge list
	    for (Vertex v : vertices)
	    {
	    	for (Edge e : v.getEdges())
	    		if (!edges.contains(e))
	    			edges.add(e);
	    }
	}
    // Create a random number generator.
    static Random rand = new Random();
    
    public Grid Copy()
    {
    	Grid grid = new Grid();
    	
    	for (Vertex v : vertices)
    		grid.vertices.add(new Vertex(v.getId()));
    	for (Edge edge : edges)
    	{
    		Vertex v1 = grid.vertices.get(edge.getV1().getId() - 1);
    		Vertex v2 = grid.vertices.get(edge.getV2().getId() - 1);
    		Edge e = new Edge(v1, v2);
    		v1.getEdges().add(e);
    		v2.getEdges().add(e);
    		grid.edges.add(e);
    	}
    	return grid;
    }
    Grid() {}
}
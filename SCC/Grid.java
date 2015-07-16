import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;
import java.util.Scanner;

/**
 * A grid consisting of vertices and directed edges
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
	ArrayList<Edge> edges = new ArrayList<Edge>();
	Deque<Vertex> vstack = new ArrayDeque<Vertex>();
	ArrayList<SCC> sccs = new ArrayList<SCC>();

	public ArrayList<Vertex> getVertices()
	{
		return vertices;
	}
	public void setVertices(ArrayList<Vertex> vertices)
	{
		this.vertices = vertices;
	}
	/**
	 * Create the Grid object from a file.  The file is expected to be a text file
	 * with each row representing an edge, with the first number on the row being the
	 * tail of the edge, and the second number being the head.  The vertices are
	 * created and then tied to the two nodes they are associated with.
	 */
	public Grid(String path) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while ((line = br.readLine()) != null)
		{
			Scanner scanner = new Scanner(line);
			
			int id1 = scanner.nextInt(); // this is the tail of the vertex
			int id2 = scanner.nextInt(); // this is the head of the vertex
			scanner.close();
			
			// Add the vertices to the array if they are not already there
			Vertex v1 = addVertex(id1);
			Vertex v2 = addVertex(id2);
			// create the edge
			Edge edge = new Edge(v1, v2);
			// Make sure each vertex knows about the edge
			v1.getEdges().add(edge);
			v2.getEdges().add(edge);
			// Store a reference to the edge for easy access
			edges.add(edge);
		}
		br.close();
	}
	/*
	 * addVertex
	 * 
	 * Check to see if the vertex id is new, if so, create the vertex and add it to
	 * the vertices array.
	 */
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
	 * SCC: Strongly Connected Components
	 * Find the SCC's using Kasaraju's 2 step algorithm
	 */
	public void findSCCs()
	{
		sccs.clear();
		vstack.clear();
		// First run DFS() backwards across the grid and assign a completion order
		// to the vertices
		for (int i=vertices.size() - 1; i >= 0; i--)
		{
			Vertex s = vertices.get(i);
			if (!s.isVisited())
				DFS(s, true);
		}
		// Make sure we reset all the vertices
		for (Vertex v : vertices) v.Reset();
		
		// Now run backwards through the completion order, and forward along the
		// edges
		while (vstack.size() > 0)
		{
			Vertex v = vstack.pop();
			if (!v.isVisited())
			{
				SCC scc = DFS(v, false);
				if (scc.size() > 1) sccs.add(scc);
			}
		}
		// Sort the SCCs in order of descending size
		sccs.sort(new SccComparator());
	}
	public ArrayList<SCC> getSccs()
	{
		return sccs;
	}
	/*
	 * DFS: Depth First Search
	 * 
	 * Search from the input vertex to find all its connected vertices, going either
	 * forward or reverse along the edges.
	 */
	public SCC DFS(Vertex v, boolean reverse)
	{
		Deque<Vertex> stack = new ArrayDeque<Vertex>();
		SCC scc = new SCC(v);
		Vertex current = v;
		while (current != null)
		{
			Vertex next = current.nextVertex(reverse);
			if (next == null)
			{
				vstack.push(current); // put the current vertex in the vstack
				current = (!stack.isEmpty()) ? stack.pop() : null; // pop off the previous vertex, if any
			}
			else if (!next.isVisited())
			{
				stack.push(current);
				scc.addVertex(next); // add this to the SCC
				current = next;
			}
		}
		
		return scc;
	}
}
import java.util.ArrayList;

/* This class defines a vertex on the graph */
public class Vertex
{
	private int id;
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private boolean visited = false; // set to true when the vertex is visited
	private boolean done = false; // set to true when all edges have been followed
	private int nFollowed = 0;
	public boolean isVisited()
	{
		return visited;
	}
	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
	public void setEdges(ArrayList<Edge> edges)
	{
		this.edges = edges;
	}
	public Vertex(int id)
	{
		this.id = id;
	}
	public boolean isDone()
	{
		return done;
	}
	public void Reset()
	{
		this.done = false;
		visited = false;
		nFollowed = 0;
	}
	/*
	 * Return an edge that has not yet been followed from this vertex.
	 */
	public Vertex nextVertex(boolean reverse)
	{
		visited = true;
		Edge edge = null;
		Vertex next = null;
		while (nFollowed < edges.size())
		{
			edge = edges.get(nFollowed);
			nFollowed++;
			if (nFollowed == edges.size()) done = true;

			// Locate the next vertex depending on the direction we
			// are going
			if ((edge.getTail() == this) && !reverse)
				next = edge.getHead();
			else if ((edge.getHead() == this) && reverse)
				next = edge.getTail();
			// break out of the loop if we found a new edge
			if (next != null) break;
		}
		if (next == null) done = true;
		
		return next;
	}
}

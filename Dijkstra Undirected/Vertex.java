import java.util.Collection;
import java.util.HashMap;

/* This class defines a vertex on the graph */
public class Vertex implements Comparable<Vertex>
{
	public static int MAXDIST = 1000000; // value indicating no connection
	private int id;
	private HashMap<Vertex, Edge> edges = new HashMap<Vertex, Edge>();
	private int dist = MAXDIST; // set to not connected until a path is found.
	public int getDist()
	{
		return dist;
	}
	public void setDist(int dist)
	{
		if ((dist == MAXDIST) || (this.dist > dist))
		this.dist = dist;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public HashMap<Vertex, Edge> getEdges()
	{
		return edges;
	}
	public void addEdge(Edge edge)
	{
		Vertex v2 = (edge.getV1() == this) ? edge.getV2() : edge.getV1();
		
		if (!edges.containsKey(v2)) edges.put(v2, edge);
	}
	public void addEdge(Vertex v2, Edge edge)
	{
		edges.put(v2, edge);
	}
	public boolean hasEdgeWith(Vertex v2)
	{
		return edges.containsKey(v2);
	}
	public Edge getEdgeWith(Vertex v2)
	{
		return edges.get(v2);
	}
	public Vertex(int id)
	{
		this.id = id;
	}
	public int compareTo(Vertex v2)
	{
		if (dist < v2.dist) return -1;
		else if (dist == v2.dist) return 0;
		else return 1;
	}
}

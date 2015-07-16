import java.util.Collection;
import java.util.HashMap;
import java.util.PriorityQueue;

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
	/*
	 * Update the vertices connected to this vertex that are
	 * still in the heap.
	 */
    public void updateHeap(boolean[] a,
            PriorityQueue<Vertex> heap)
    {
        for (Vertex v : edges.keySet())
        {
            if (!a[v.getId()])
            {
                v.updateDist(a, heap, edges.get(v));
            }
        }
    }
    protected void updateDist(boolean[] a, PriorityQueue<Vertex> heap, Edge edge)
    {
        if (a[edge.getV1().getId()] ^ a[edge.getV2().getId()])
        {
            int weight = edge.getWeight();
            if (weight < dist)
            {
                dist = weight;
                heap.remove(this);
                heap.add(this);
            }
        }
    }
    public void setDist2minEdge()
    {
        dist = Vertex.MAXDIST;
        for (Edge edge : edges.values())
        {
            if (edge.getWeight() < dist) dist = edge.getWeight(); 
        }
    }
}

import java.util.ArrayList;

/* This class defines a vertex on the graph */
public class Vertex
{
	private int id;
	private ArrayList<Edge> edges = new ArrayList<Edge>();
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
	// Create a "merged" vertex from an edge
	public Vertex(Edge e, int id)
	{
		this.id = id;
		Vertex v1 = e.getV1();
		Vertex v2 = e.getV2();
		ArrayList<Edge> rough = new ArrayList<Edge>();
		
		addEdges(v1, rough);
		addEdges(v2, rough);
		
		correctEdgeVertices(v1, v2, rough);
	}
	/*
	 * Add the edges from an original vertex to the merged vertex
	 */
	private void addEdges(Vertex vertex, ArrayList<Edge> rough)
	{
		for (Edge edge : vertex.getEdges())
		{
			if (!rough.contains(edge)) rough.add(edge);
		}
	}
	private void correctEdgeVertices(Vertex v1, Vertex v2, ArrayList<Edge> rough)
	{
		for (Edge edge : rough)
		{
			Vertex ev1 = edge.getV1();
			Vertex ev2 = edge.getV2();
 			if (((ev1 == v1) && (ev2 == v2)) || ((ev1 == v2) && (ev2 == v1)))
				;// nothing else required
			else if ((ev1 == v1) || (ev1 == v2))
			{
				edge.setV1(this);
				edges.add(edge);
			}
			else if ((ev2 == v1) || (ev2 == v2))
			{
				edge.setV2(this);
				edges.add(edge);
			}
		}

	}

}



/**
 * A class defining an edge
 */

/**
 * @author deb
 *
 */
public class Edge
{
	private Vertex v1;
	private Vertex v2;
	private int weight;
	public Vertex getV1()
	{
		return v1;
	}
	public void setV1(Vertex v1)
	{
		this.v1 = v1;
	}
	public Vertex getV2()
	{
		return v2;
	}
	public void setV2(Vertex v2)
	{
		this.v2 = v2;
	}
	/**
	 * Create an edge with two vertices
	 */
	public Edge(Vertex v1, Vertex v2, int weight)
	{
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	public int getWeight()
	{
		return weight;
	}
}

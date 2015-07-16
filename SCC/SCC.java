import java.util.ArrayList;

/**
 * SCC
 * 
 * This class defines a set of vertices within a Strongly Connected Component
 */

/**
 * @author deb
 *
 */
public class SCC
{

	ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	Vertex leader;
	/**
	 * Create the SCC with the leader vertex
	 */
	public SCC(Vertex s)
	{
		leader = s;
		vertices.add(s);
	}
	/*
	 * Add a vertex to the SCC
	 */
	public void addVertex(Vertex v) { vertices.add(v); }
	/*
	 * Return the size of the SCC
	 */
	public int size() { return vertices.size(); }
	public Vertex getLeader() { return leader; }
}



/**
 * A class defining an edge
 */

/**
 * @author deb
 *
 */
public class Edge
{
	private Vertex head;
	private Vertex tail;
	private boolean followed = false;
	public boolean isTouched()
	{
		return followed;
	}
	public void setTouched(boolean touched)
	{
		this.followed = touched;
	}
	public Vertex getHead() {
		return head;
	}
	public void setHead(Vertex head) {
		this.head = head;
	}
	public Vertex getTail() {
		return tail;
	}
	public void setTail(Vertex tail) {
		this.tail = tail;
	}
	/**
	 * Create an edge with two vertices
	 */
	public Edge(Vertex head, Vertex tail)
	{
		this.head = head;
		this.tail = tail;
	}
}

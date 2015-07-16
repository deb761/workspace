/**
 * A class to hold the details for a job
 */

/**
 * @author deb
 *
 */
public class Job implements Comparable<Job>
{
    private int weight;
    private int length;
    private double scale;
    /**
	 * Construct a Job with a weight and process length.
	 */
	public Job(int w, int l)
	{
		weight = w;
		length = l;
	}
    public int getWeight()
    {
        return weight;
    }
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    public int getLength()
    {
        return length;
    }
    public void setLength(int length)
    {
        this.length = length;
    }
    public double getScale()
    {
        return scale;
    }
    public void setScale(double scale)
    {
        this.scale = scale;
    }
    public int compareTo(Job j2)
    {
        if (scale > j2.scale) return -1;
        else if (scale == j2.scale)
        {
            if (weight > j2.weight) return -1;
            else if (weight < j2.weight) return 1;
            else return 0;
        }
        else return 1;
    }

}

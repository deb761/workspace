import java.util.Comparator;

/**
 * A comparator for SCCs
 */

/**
 * @author deb
 *
 */
public class SccComparator implements Comparator<SCC>
{
	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
    public int compare(SCC c1, SCC c2)
    {
        return Integer.valueOf(c2.size()).compareTo(Integer.valueOf(c1.size()));
    }
}

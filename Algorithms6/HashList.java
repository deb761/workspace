import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 * HashList a hash table that creates a hash table that uses a linked list to
 * handle duplicates.  This first version uses an integer key and integer values.
 */

/**
 * @author deb
 *
 */
public class HashList
{
	HashMap<Integer, HashMap<Integer, Boolean>> table;
	/**
	 * Create an empty table
	 */
	public HashList()
	{
		table = new HashMap<Integer, HashMap<Integer, Boolean>>();
	}
	
	public HashList(int size)
	{
		table = new HashMap<Integer, HashMap<Integer, Boolean>>(size);
	}

	public void put(int key, int value)
	{
		if (table.get(key) == null)
			table.put(key, new HashMap<Integer, Boolean>());
		table.get(key).put(value, true);
	}
	public Set<Integer> getKeys()
	{
		return table.keySet();
	}
	public Set<Integer> get(int key)
	{
		return (table.containsKey(key)) ? table.get(key).keySet() : null;
	}
	public HashMap<Integer, Boolean> getValues(int key)
	{
		return table.get(key);
	}
}

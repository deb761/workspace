package algorithms;

public class SortedArray
{
	private Integer count;
	private Integer[] array;
	public SortedArray(Integer len)
	{
		array = new Integer[len];
		count = 0;
	}
	public SortedArray(Integer[] value)
	{
		array = value;
		count = 0;
	}
	public SortedArray(Integer[] value, int num)
	{
		array = value;
		count = num;
	}
	public Integer getCount() { return count; }
	public Integer[] getArray() { return array; }
	public int getLength() { return array.length; }
	public Integer getItem(int index) { return array[index]; }
	public void setCount(int n) { count = n; }
	public void setArray(Integer[] val) { array = val; }
	public void setArray(int index, int val) { array[index] = val; }
}

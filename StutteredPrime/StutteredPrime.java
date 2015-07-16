/**
 * 
 */

/**
 * @author deb
 *
 */
public class StutteredPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		PrintStutteredPrimes(Integer.parseInt(args[0]));
	}
	private static void PrintStutteredPrimes(int limit)
	{
		for (int i = 0; i<= limit; i++)
		{
			if (IsPrime(i))
				System.out.println(Stutter(i));
		}
	}
	
	private static boolean IsPrime(int x)
	{
		if (x <= 0)
			return false;
		else
			return !HasFactorGEk(x, 2);
	}
	private static boolean HasFactorGEk(int x, int k)
	{
		if (k >= x) return false;
		if (x % k == 0) return true;
		return HasFactorGEk(x, k + 1);
	}
	private static int Stutter(int x)
	{
		if (x < 10)
			return 11*x;
		else
		{
			int top = x / 10;
			int bottom = x % 10;
			return Stutter(top) * 100 + Stutter(bottom);
		}
	}

}

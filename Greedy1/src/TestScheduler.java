import java.io.IOException;

/**
 * Test Scheduling algorithm
 */

/**
 * @author deb
 *
 */
public class TestScheduler
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		test("test1");
		
		test("test2");

		test("test3");

		test("jobs");
		
		testMST("mst1");

        testMST("mst2");

        testMST("mst3");

        testMST("mst4");

        testMST("edges");
	}
	/*
	 * Run a test case
	 */
	private static void test(String name) throws IOException
	{
		Scheduler sched = new Scheduler(String.format("%s.txt", name));
		long diff = sched.scheduleDiff();
        long ratio = sched.scheduleRatio();
		System.out.println(String.format("%s test case results:", name));
		System.out.println(String.format("diff = %d, ratio = %d", diff, ratio));
	}
    /*
     * Run a test case
     */
    private static void testMST(String name) throws IOException
    {
        Grid grid = new Grid(String.format("%s.txt", name));
        long length = grid.findMST();
        System.out.println(String.format("%s test case result %d:", name, length));
    }

}

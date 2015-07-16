import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Put together a schedule that tries to optimize for min Sum (wi,ci)
 * by selecting the next job based on the maximum of wi - li,
 * where wi is the weight of the job, and
 *       li is the length of the job
 */

/**
 * @author deb
 *
 */
public class Scheduler
{

    private Job[] jobs;
	/**
	 * Construct a scheduler that prioritizes by wi - li
	 */
	public Scheduler(String path) throws IOException
	{
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        Scanner scanner = new Scanner(line).useDelimiter("[\t ,]");
        int length = scanner.nextInt();
        jobs = new Job[length];
        scanner.close();
        int idx = 0;
        
        while (((line = br.readLine()) != null) && (idx < jobs.length))
        {
            scanner = new Scanner(line).useDelimiter("[\t ,]");
            
            int weight = scanner.nextInt();
            length = scanner.nextInt();
            jobs[idx++] = new Job(weight, length);
            
            scanner.close();
        }
        br.close();
	}

	public long scheduleDiff()
	{
	    long sum = 0;
	    long ct = 0;
	    
	    // set the scale 
	    for (Job job : jobs)
	        job.setScale(job.getWeight() - job.getLength());
	    
	    Arrays.sort(jobs);
	    
	    // Find the sum of the weighted completion times
	    for (Job job : jobs)
	    {
	        ct += job.getLength();
	        sum += job.getWeight() * ct;
        }
	    return sum;
	}
    public long scheduleRatio()
    {
        long sum = 0;
        long ct = 0;
        
        // set the scale 
        for (Job job : jobs)
            job.setScale((double)job.getWeight() / (double)job.getLength());
        
        Arrays.sort(jobs);
        
        // Find the sum of the weighted completion times
        for (Job job : jobs)
        {
            ct += job.getLength();
            sum += job.getWeight() * ct;
        }
        return sum;
    }
}

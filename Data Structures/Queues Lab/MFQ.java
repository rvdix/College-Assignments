import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This class runs the appropriate methods to run the simulation of the CPU and reads input for the jobs to be sent.
 * @author Alvaro Vera
 * @version 1.0
 */
public class MFQ
{
    private PrintWriter pw;
    private String placeholder;
    private ObjectQueue jobsQueue = new ObjectQueue();
    private ObjectQueue queue1 = new ObjectQueue();
    private ObjectQueue queue2 = new ObjectQueue();
    private ObjectQueue queue3 = new ObjectQueue();
    private ObjectQueue queue4 = new ObjectQueue();
    private Job currentJob;
    private int numberOfJobs = 0;
    private Clock clock = new Clock();
    private CPU cpu = new CPU();
    private double timeCompletion = 0;
    private double responseTime = 0;
    private double timeWaiting = 0;
    private int firstArrival = 0;

    public MFQ(PrintWriter pw)
    {
        this.pw = pw;
    }

    /**
     * Reads in the values from the text files for the jobs, creates jobs from the values, and puts them on the queue.
     * @throws IOException
     */
    public void getJobs() throws IOException
    {
        Scanner sc = new Scanner(new File("mfq.txt"));

        while (sc.hasNextLine())
        {
            int arrivalTime;
            int PID;
            int timeNeeded;

            placeholder = sc.nextLine();
            String delim = "[ ]+";

            String[] tokens = placeholder.split(delim);

            arrivalTime = Integer.parseInt(tokens[0]);
            PID = Integer.parseInt(tokens[1]);
            timeNeeded = Integer.parseInt(tokens[2]);

            jobsQueue.insert(new Job(arrivalTime, PID, timeNeeded));
            numberOfJobs += 1;
        }
    }

    /**
     * Outputs headers for the output of the jobs for arrivals and departures.
     */
    public void outputHeader()
    {
        System.out.println("Event:         System Time:        PID:          CPU Time Needed:          Total Time:          Lowest Level Queue:");
        pw.println("Event:         System Time:        PID:          CPU Time Needed:          Total Time:          Lowest Level Queue:");


        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        pw.println("---------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * Runs the simulation for the CPU, calls methods to help keep track of values for the CPU and jobs.
     */
    public void runSimulation()
    {
        while (!jobsQueue.isEmpty() || cpu.isBusy() || !areQueuesEmpty())
        {
            clock.tickClock();

            if (isThereAJob())
            {
                currentJob = (Job)jobsQueue.remove();
                outputArrival(clock.getTime(), currentJob.getPID(), currentJob.getCpuTimeNeeded());
                queue1.insert(currentJob);
            }

            if(cpu.isBusy())
            {
                cpu.decQuantumClock();
                cpu.decJobClock();

                if(isJobFinished())
                {
                    if (firstArrival == 0)
                        {
                            firstArrival = cpu.getJob().getArrivalTime();
                        }

                    outputDeparture(clock.getTime(), cpu.getJob());
                    timeWaiting += cpu.getJob().timeOnQueue(clock.getTime());
                    timeCompletion += (clock.getTime() - cpu.getJob().getArrivalTime());
                    cpu.setBusyFlag(false);



                    if(!areQueuesEmpty())
                    {
                        jobOnQueue();
                        cpu.setCpuQuantumClock(cpu.getJob().getCurrentQueue());
                        cpu.setBusyFlag(true);
                    }
                }

                else if(!isJobFinished())
                {
                    if(!preemption())
                    {

                    }

                    else if(preemption())
                    {
                        switch(cpu.getJob().getCurrentQueue())
                        {

                            case 1: queue2.insert(cpu.getJob()); break;
                            case 2: queue3.insert(cpu.getJob()); break;
                            case 3: queue4.insert(cpu.getJob()); break;
                            case 4: queue4.insert(cpu.getJob()); break;
                        }

                        if(cpu.getJob().getCurrentQueue() != 4)
                        {
                            cpu.getJob().incCurrentQueue();
                        }
                        cpu.setBusyFlag(false);
                        jobOnQueue();
                        cpu.setCpuQuantumClock(cpu.getJob().getCurrentQueue());
                        cpu.setBusyFlag(true);

                    }

                }

            }

            else if(!cpu.isBusy() && !areQueuesEmpty())
            {
                jobOnQueue();
                cpu.setBusyFlag(true);
                cpu.setCpuQuantumClock(cpu.getJob().getCurrentQueue());
            }
        }
    }

    /**
     * Checks if there's a job on the jobs queue.
     * @return true if there is a job on the queue otherwise, false.
     */
    public boolean isThereAJob()
    {
        Job tempJob;
        if(!jobsQueue.isEmpty())
        {
            tempJob = (Job)jobsQueue.query();
            return (tempJob.getArrivalTime() == clock.getTime());
        }

        else
            return false;
    }

    /**
     * Checks if the current job on the CPU is finished
     * @return true if the job is finished
     */
    public boolean isJobFinished()
    {
        return cpu.getJob().getCpuTimeRemaining() == 0;
    }

    /**
     * Checks if there is a need to preempt the current job.
     * @return true if there is a job that takes precedence
     */
    public boolean preemption()
    {
        return (cpu.getCpuQuantumClock() == 0 || !queue1.isEmpty());
    }

    /**
     * Checks if the queues 1-4 are empty
     * @return true if all are empty
     */
    public boolean areQueuesEmpty()
    {
        return (queue1.isEmpty() && queue2.isEmpty() && queue3.isEmpty() && queue4.isEmpty());
    }

    /**
     * Sets the current job on the CPU based on precedence.
     */
    public void jobOnQueue()
    {
        if(!queue1.isEmpty())
        {
            cpu.newJob((Job) queue1.remove());
            cpu.getJob().setResponseTime(clock.getTime());
            totalResponseTime(cpu.getJob().getResponseTime());
        }
        else if(!queue2.isEmpty())
            cpu.newJob((Job)queue2.remove());

        else if(!queue3.isEmpty())
            cpu.newJob((Job)queue3.remove());

        else if(!queue4.isEmpty())
            cpu.newJob((Job)queue4.remove());

    }

    /**
     * Keeps track of the total response time for all jobs.
     * @param inResponseTime response time of a Job
     */
    public void totalResponseTime(int inResponseTime)
    {
        responseTime += inResponseTime;
    }

    /**
     * This outputs relevant information whenever a job arrives onto the CPU.
     * @param inSystemTime current system time
     * @param inPID current job PID
     * @param inCPUTimeNeeded time needed on CPU for completion
     */
    public void outputArrival(int inSystemTime, int inPID, int inCPUTimeNeeded)
    {
        int systemTime = inSystemTime;
        int pid = inPID;
        int cpuTimeNeeded = inCPUTimeNeeded;

        System.out.printf("%s", "Arrival");
        pw.printf("%s", "Arrival");

        System.out.printf("%15d", systemTime);
        pw.printf("%15d", systemTime);

        System.out.printf("%16d", pid);
        pw.printf("%16d", pid);

        System.out.printf("%26d", cpuTimeNeeded);
        pw.printf("%26d", cpuTimeNeeded);

        System.out.println('\n');
        pw.printf("\n");
    }

    /**
     * This outputs relevant information whenever a job leaves the CPU.
     * @param inSystemTime current system time
     * @param inCurrentJob current job that just finished
     */
    public void outputDeparture(int inSystemTime, Job inCurrentJob)
    {

        System.out.printf("%s", "Departure");
        pw.printf("%s", "Departure");

        System.out.printf("%13d", inSystemTime);
        pw.printf("%13d", inSystemTime);

        System.out.printf("%16d", inCurrentJob.getPID());
        pw.printf("%16d", inCurrentJob.getPID());

        System.out.printf("%48d", inSystemTime - inCurrentJob.getArrivalTime());
        pw.printf("%51d", inSystemTime - inCurrentJob.getArrivalTime());

        System.out.printf("%29d", inCurrentJob.getCurrentQueue());
        pw.printf("%29d", inCurrentJob.getCurrentQueue());

        System.out.println('\n');
        pw.printf("\n");
    }

    /**
     * This outputs stats for the entire runtime of the jobs on the CPU.
     */
    public void outStats()
    {
        DecimalFormat format = new DecimalFormat("0.#");

        System.out.println("Total number of jobs: " + numberOfJobs);
        pw.println("Total number of jobs: " + numberOfJobs);

        System.out.println("Total time of all jobs: " + format.format(timeCompletion));
        pw.println("Total time of all jobs: " + format.format(timeCompletion));

        System.out.printf("Average job response time: %.2f \n", (responseTime/numberOfJobs));
        pw.printf("Average job response time: %.2f \n", (responseTime/numberOfJobs));

        System.out.printf("Average job turnaround time: %.2f \n", (timeCompletion/numberOfJobs));
        pw.printf("Average job turnaround time: %.2f \n", (timeCompletion/numberOfJobs));

        System.out.printf("Average waiting time: %.2f \n", (timeWaiting/numberOfJobs));
        pw.printf("Average waiting time: %.2f \n", (timeWaiting/numberOfJobs));

        System.out.printf("Average throughput: %.2f", (numberOfJobs/timeCompletion));
        pw.printf("Average throughput: %.2f", (numberOfJobs/timeCompletion));
    }
}

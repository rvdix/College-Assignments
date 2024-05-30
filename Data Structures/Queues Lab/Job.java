/**
 * This class is a representation of jobs on the CPU. Keeps track of various counters and summations for the job object.
 * @author Alvaro Vera
 * @version 1.0
 */
public class Job {

    private int arrivalTime;
    private int PID;
    private int cpuTimeNeeded;
    private int cpuTimeRemaining;
    private int currentQueue;
    private int responseTime;

    /**
     * Constructor for Job class.
     * @param inArrivalTime time job arrives on the CPU
     * @param inPID the process ID number
     * @param inCPUTimeNeeded time needed on CPU for job to complete
     */
    public Job(int inArrivalTime, int inPID, int inCPUTimeNeeded)
    {
        arrivalTime = inArrivalTime;
        PID = inPID;
        cpuTimeNeeded = inCPUTimeNeeded;
        cpuTimeRemaining = cpuTimeNeeded;
        currentQueue = 1;
        responseTime = 0;

    }

    /**
     * Returns the job objects arrival time on the CPU.
     * @return arrivalTime
     */
    public int getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * Returns the ID for the job on the CPU.
     * @return PID
     */
    public int getPID()
    {
        return PID;
    }

    /**
     * Gets the CPU time needed for the job to complete its processing.
     * @return cpuTimeNeeded
     */
    public int getCpuTimeNeeded()
    {
        return cpuTimeNeeded;
    }

    /**
     * Gets the time remaining the job needs on the CPU to finish processing.
     * @return cpuTimeRemaining
     */
    public int getCpuTimeRemaining()
    {
        return cpuTimeRemaining;
    }

    /**
     * Gets the current lowest level queue that the job has been on.
     * @return currentQueue
     */
    public int getCurrentQueue()
    {
        return currentQueue;
    }

    /**
     * Decrements the remaining amount of time on the CPU the job needs to complete by 1.
     */
    public void decCpuTimeRemaining()
    {
        cpuTimeRemaining -= 1;
    }

    /**
     * Increases the lowest level queue that a job has been on by 1.
     */
    public void incCurrentQueue()
    {
        currentQueue += 1;
    }

    /**
     * Allows the user to set the jobs response time on the CPU.
     * @param time the current time on the clock
     */
    public void setResponseTime(int time)
    {
        responseTime = time - arrivalTime;
    }

    /**
     * Gets the jobs response time.
     * @return responseTime
     */
    public int getResponseTime()
    {
        return responseTime;
    }

    /**
     * Calculates the amount of time that a job has been waiting on a queue
     * @param inTime the current time of the clock
     * @return time on queue
     */
    public int timeOnQueue(int inTime)
    {
        return (inTime - arrivalTime) - cpuTimeNeeded;

    }
}


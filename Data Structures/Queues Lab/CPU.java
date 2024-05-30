/**
 * This class that represents the CPU that processes the jobs.
 * @author Alvaro Vera
 * @version 1.0
 */
public class CPU
{

    private int cpuQuantumClock;
    private boolean busyFlag = false;
    private Job job;

    /**
     * Constructor for the CPU class.
     */
    public CPU()
    {

    }
    /**
     * Checks if the CPU is busy.
     * @return busyFlag
     */
    public boolean isBusy()
    {
        return busyFlag;
    }

    /**
     * Sets the CPUs time quantum based on what the lowest level queue the current job is on.
     * @param lowestLevelQueue lowest level queue of job
     */
    public void setCpuQuantumClock(int lowestLevelQueue)
    {
        cpuQuantumClock = (int)Math.pow(2,lowestLevelQueue);
    }

    /**
     * Sets the busyFlag to true of false based on the parameter busy.
     * @param busy whether the CPU is busy or not
     */
    public void setBusyFlag(boolean busy)
    {
        busyFlag = busy;
    }

    /**
     * Returns the current job that is on the CPU.
     * @return current job
     */
    public Job getJob()
    {
        return job;
    }

    /**
     * Decrements the quantum clock on the CPU by 1.
     */
    public void decQuantumClock()
    {
        cpuQuantumClock -= 1;
    }

    /**
     * Returns the current value of time quantum left for the job on the CPU.
     * @return cpuQuantumClock
     */
    public int getCpuQuantumClock()
    {
        return cpuQuantumClock;
    }

    /**
     * Decrements the time remaining on the current job on the CPU.
     */
    public void decJobClock()
    {
        job.decCpuTimeRemaining();
    }

    /**
     * Sets the current job of the CPU to the one taken in as a parameter.
     * @param inJob current job
     */
    public void newJob(Job inJob)
    {
        this.job = inJob;
    }
}

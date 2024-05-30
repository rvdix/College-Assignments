/**
 * This class keeps track of the current time on the CPU as well as being able to tick the clock and get the current time.
 * @author Alvaro Vera
 * @version 1.0
 */
public class Clock {

    private int time;

    /**
     * Constructor for the Clock class.
     */
    public Clock()
    {
        time = 0;
    }

    /**
     * Ticks the clock by 1.
     */
    public void tickClock()
    {
        time++;
    }

    /**
     * Gets the current time from the clock.
     * @return time
     */
    public int getTime()
    {
        return time;
    }


}

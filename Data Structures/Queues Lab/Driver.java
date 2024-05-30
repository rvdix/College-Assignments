import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This driver runs the appropriate methods and classes to simulate a CPU time sharing set up.
 * @author Richard Stegman
 * @version 1.0
 */
public class Driver {

    public static void main (String args[]) throws IOException
    {
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        MFQ mfq = new MFQ(pw);
        mfq.getJobs();
        mfq.outputHeader();
        mfq.runSimulation();
        mfq.outStats();
        pw.close();
    }


}

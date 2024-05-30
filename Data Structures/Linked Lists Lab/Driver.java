import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Driver
{
    public static void main(String args[]) throws FileNotFoundException
    {

        PrintWriter pw = new PrintWriter(new File("csis.txt"));
        Payroll payroll = new Payroll(pw);

        payroll.getEmployees(); //completed
        payroll.outputEmployeesHeader(); //not complete
        payroll.outputEmployees(); //not complete
        payroll.numberOfEmployees(); //completed
        payroll.womenOnPayroll(); //completed
        payroll.seniorMaking35(); //completed
        payroll.raise(); //completed
        payroll.sort(); //completed sort of
        payroll.outputEmployees(); //completed sort of
        payroll.hireEmployees(); //compelted
        payroll.fireEmployees(); //not compelted




    }
}

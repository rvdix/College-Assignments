import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Payroll
{
    private ObjectList employees = new ObjectList();
    private PrintWriter pw;

    public Payroll(PrintWriter inPW)
    {
        pw = inPW;
    }

    public void getEmployees() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("payfile.txt"));

        while(sc.hasNextLine())
        {
            String firstName;
            String lastName;
            String gender;
            int tenure;
            String rate;
            double salary;

            String placeholder = sc.nextLine();
            String delim = "[ ]+";

            String[] tokens = placeholder.split(delim);

            firstName = tokens[0];
            lastName = tokens[1];
            gender = tokens[2];
            tenure = Integer.parseInt(tokens[3]);
            rate = tokens[4];
            salary = Double.parseDouble(tokens[5]);

            employees.addLast(new Employee(firstName, lastName, gender, tenure, rate, salary));
        }

    }

    public void outputEmployeesHeader()
    {
        System.out.print("First Name:     ");
        System.out.print("Last Name:    ");
        System.out.print("Gender:    ");
        System.out.print("Tenure:    ");
        System.out.print("Rate:    ");
        System.out.print("Salaray:    ");
    }

    public void outputEmployees()
    {
        ObjectListNode p;
        Employee temp;
        p = employees.getFirstNode();

        while(p != null)
        {
            temp = (Employee)p.getInfo();


            System.out.println();
            System.out.format(temp.getFirstName());
            System.out.format("%s", temp.getLastName());
            System.out.format("%20s", temp.getGender());

            p = p.getNext();
        }

    }

    public void numberOfEmployees()
    {
        System.out.println();
        System.out.println("Number of Employees: " + employees.size());
    }

    public void womenOnPayroll()
    {
        ObjectListNode p;
        Employee temp;
        p = employees.getFirstNode();

        System.out.println();
        System.out.println("Women on payroll:");
        while (p != null)
        {
            temp = (Employee)p.getInfo();
            if(temp.getGender().equals("F"))
            {
                System.out.println(temp.getFirstName() + " " + temp.getLastName());
            }
            p = p.getNext();
        }
    }

    public void seniorMaking35()
    {
        ObjectListNode p;
        Employee temp;
        double yearly;
        p = employees.getFirstNode();

        System.out.println();
        System.out.println("Making over 35,000 and at least 5 years with company: ");
        while (p != null)
        {
            temp = (Employee) p.getInfo();
            if (temp.getRate().equals("W"))
            {
                yearly = temp.getSalary()*52;

                if(yearly > 35000 && temp.getTenure() >= 5)
                {
                    System.out.println(temp.getFirstName() + " " + temp.getLastName());
                }
            }
            p = p.getNext();
        }

    }

    public void raise()
    {
        ObjectListNode p;
        Employee temp;
        p = employees.getFirstNode();

        System.out.println();
        System.out.println("Employees who received a raise: ");
        while (p != null)
        {
            temp = (Employee)p.getInfo();
            if(temp.getSalary() < 10.00 && temp.getRate().equals("H"))
            {
                temp.setSalary(.75);
                System.out.println(temp.getFirstName() + " " + temp.getLastName()+ " " + temp.getSalary());
            }

            else if(temp.getSalary() < 350.00 && temp.getRate().equals("W"))
            {
                temp.setSalary(50);
                System.out.println(temp.getFirstName() + " " + temp.getLastName()+ " " + temp.getSalary());
            }
            p = p.getNext();
        }
    }

    public void sort()
    {
        ObjectList copy = employees;
        ObjectList sorted = new ObjectList();
        ObjectListNode p = copy.getFirstNode();
        Employee temp;

        while(!copy.isEmpty())
        {
            temp = (Employee)p.getInfo();
            if(sorted.isEmpty())
            {
                sorted.insert(temp);
            }
            else
            {
                sorted.insert(temp);
            }
            copy.remove(temp);
            p = p.getNext();
        }
        employees.clear();
        employees = sorted;
    }

    public void hireEmployees() throws FileNotFoundException {
        Scanner hire = new Scanner(new File("hirefile.txt"));
        while(hire.hasNextLine())
        {
            String firstName;
            String lastName;
            String gender;
            int tenure;
            String rate;
            double salary;

            String placeholder = hire.nextLine();
            String delim = "[ ]+";

            String[] tokens = placeholder.split(delim);

            firstName = tokens[0];
            lastName = tokens[1];
            gender = tokens[2];
            tenure = Integer.parseInt(tokens[3]);
            rate = tokens[4];
            salary = Double.parseDouble(tokens[5]); 

            employees.insert(new Employee(firstName, lastName, gender, tenure, rate, salary));
        }


    }

    public void fireEmployees() throws FileNotFoundException {
        Scanner fire = new Scanner(new File("firefile.txt"));
        while(fire.hasNextLine())
        {
            String firstName;
            String lastName;

            String placeholder = fire.nextLine();
            String delim = "[ ]+";

            String[] tokens = placeholder.split(delim);

            firstName = tokens[0];
            lastName = tokens[1];

            //while()




        }


    }
}

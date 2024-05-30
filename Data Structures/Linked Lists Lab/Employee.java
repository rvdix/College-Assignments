public class Employee implements Comparable {
    private String firstName;
    private String lastName;
    private String gender;
    private int tenure;
    private String rate;
    private double salary;


    public Employee(String inFirstName, String inLastName, String inGender, int inTenure, String inRate, double inSalary) {
        firstName = inFirstName;
        lastName = inLastName;
        gender = inGender;
        tenure = inTenure;
        rate = inRate;
        salary = inSalary;
    }

    public int compareTo(Object o)
    {
        Employee e = (Employee) o;
        String first;
        String last;
        first = this.firstName;
        last = this.lastName;

        if((last.compareTo(e.lastName)) == 0)
        {
            return(first.compareTo(e.firstName));
        }
        return last.compareTo(e.lastName);

    }

    public double getSalary() {
        return salary;
    }

    public int getTenure() {
        return tenure;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRate() {
        return rate;
    }

    public void setSalary(double inSalary) {
        salary = this.salary + inSalary;
    }
}


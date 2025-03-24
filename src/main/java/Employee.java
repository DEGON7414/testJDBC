import java.sql.Timestamp;


public class Employee {
    private int employeeId;
    private  String name;
    private  int sex;
    private Timestamp times;

    public Employee() {
    }

    public Employee(int employeeId, String name, int sex, Timestamp times) {
        this.employeeId = employeeId;
        this.name = name;
        this.sex = sex;
        this.times = times;
    }
    public Employee( String name, int sex, Timestamp times) {
        this.name = name;
        this.sex = sex;
        this.times = times;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", times=" + times +
                '}';
    }
}

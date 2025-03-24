import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * ClassName: main
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/21 下午 01:35
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeService employeeService = new EmployeeService();
//        //新增
//        Employee emp1 = new Employee("KEVIN", 1, new Timestamp(System.currentTimeMillis()));
//        employeeService.addEmployee(emp1);
//        //根據ID查詢
//        employeeService.getEmployee(1);
//
//        //查全部
//        employeeService.getEmployees();
        //更新
        try {
            Employee employee = new Employee();
            employee.setEmployeeId(1);
            employee.setName("牢大");
            employee.setSex(1);
            employee.setTimes(new Timestamp(System.currentTimeMillis()));

            employeeService.updateEmployee(employee);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新失敗");
      }
        //刪除
//        employeeService.deleteEmployee(7);
    }
}

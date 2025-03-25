import com.mysql.cj.result.LocalDateTimeValueFactory;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeService employeeService = new EmployeeService();
//        //新增
//          Employee emp1 = new Employee("KEVIN", 1, new Timestamp(System.currentTimeMillis()));
          Employee emp1 = new Employee();
          emp1.setName("黑鬍子");
          emp1.setSex(1);
          emp1.setTimes();
//          employeeService.addEmployee(emp1);
        //根據ID查詢
//        employeeService.getEmployee(1);
//
        //查全部
//        employeeService.getAllEmployees();
        //更新
//        try {
//            Employee employee = new Employee();
//            employee.setEmployeeId(1);
//            employee.setName("老牛");
//            employee.setSex(0);
//            employee.setTimes();
////            employee.setTimes(LocalDateTime.of(2025, 3, 21, 11, 22, 12));
//            employeeService.updateEmployee(employee);

//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("更新失敗");
//      }
        //刪除
//        employeeService.deleteEmployee(14);
    }
}

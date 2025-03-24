import java.util.List;


public class EmployeeService {
   private final EmployeeDAO employeeDAO = new EmployeeDAO();

   //新增員工
   public void addEmployee(Employee emp) {
      if (emp != null && emp.getName() != null && !emp.getName().trim().isEmpty()) {
         employeeDAO.addEmployee(emp);
         System.out.println("新增成功" + emp);
      } else {
         throw new IllegalArgumentException("員工資訊不完整，無法新增");
      }
   }

   //根據ID查員工
   public Employee getEmployee(int employeeId) {
      if (employeeId > 0) {
         Employee emp = employeeDAO.getEmployee(employeeId);
         if (emp != null) {
            System.out.println("找到編號:" + employeeId + "資料為:" + emp);
         } else {
            System.out.println("未找到員工，ID：" + employeeId);
         }
         return emp;
      } else {
         throw new IllegalArgumentException("Employee id 無效");
      }
   }

      //查詢所有
      public List<Employee> getEmployees() {
         List<Employee> employees = employeeDAO.getAllEmployees();
         for (Employee emp : employees) {
            System.out.println(emp);
         }
         return employees;
      }
      //根據ID刪員工
      public void deleteEmployee(int employeeId){
         if (employeeId > 0) {
            employeeDAO.deleteEmployee(employeeId);
            System.out.println("刪除成功 編號:" + employeeId + "已滾蛋");
         } else {
            throw new IllegalArgumentException("Employee id 無效");
         }
      }
      //更新員工資訊
      public void updateEmployee (Employee emp){
         if (emp != null && emp.getEmployeeId() > 0) {
            employeeDAO.updateEmployee(emp);
         } else {
            throw new IllegalArgumentException("員工資訊不完或ID無效，更新失敗");

         }
      }
   }


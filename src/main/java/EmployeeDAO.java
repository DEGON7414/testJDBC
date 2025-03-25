import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    //private 提高安全 避免外部修改 改成常數 不用每調用一次就建立一個String
    private static final String insetSql = "insert into user(name,sex,times) values(?,?,?)";
    private static final String findByISql = "select * from user where employee_id=?";
    private static final String findAllSql = "select * from user";
    private static final String deleteSql = "delete from user where employee_id=?";
    private static final String updateSql = "UPDATE user SET name = ?, SEX=?, times=? WHERE employee_id=?";

    //增加員工
    public void addEmployee(Employee emp) {
//        private static final String insetSql = "insert into user(name,sex,times) values(?,?,?)";

        try (Connection connection = JDBCUtils.getConnection();//開啟連線 放入SQL準備連線
             PreparedStatement psmt = connection.prepareStatement(insetSql);) {
            psmt.setString(1, emp.getName()); // set 第一個問號 值為emp.getName()
            psmt.setInt(2, emp.getSex());
            psmt.setObject(3, emp.getTimes());
            int i = psmt.executeUpdate();//執行 insert 語句 將資料插入到資料庫
            if (i > 0) {
                System.out.println("資料庫更新成功，影響了" + i + "行");
            }else {
                System.out.println("新增失敗");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根據ID查員工
    public Employee getEmployee(int employeeId) {
//        private static final String findByISql = "select * from user where employee_id=?";

        try (Connection connection = JDBCUtils.getConnection();//1.開連線
             PreparedStatement psmt = connection.prepareStatement(findByISql);//準備物件並放入SQL語句
        ) { //設定 SQL語句中第一個問號的值為 傳入的employeeId
            psmt.setInt(1, employeeId);
            try (
                    //有從資料庫獲得查詢結果的才需要用到 ResultSet 來放查詢結果
                    //try 中 try     //執行SQL語句 查詢會返回結果 用resultset 接
                    ResultSet rs = psmt.executeQuery();) {
                if (rs.next()) {
                    Employee employee = new Employee();//創建一個物件來存放查詢結果
                    employee.setEmployeeId(employeeId);
                    employee.setName(rs.getString("name"));//將 rs中 "name"欄位的值 set屬性Name
                    employee.setSex(rs.getInt("sex"));
                    employee.setTimes(rs.getObject("times", LocalDateTime.class));//RS中的times欄位 轉換成LocalDateTime類別
                    return employee;//return 給呼叫此方法的 service 但service由main呼叫 最後會到main
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查全部
    public List<Employee> getAllEmployees() {
//        private static final String findAllSql = "select * from user";

        ArrayList<Employee> employees = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement psmt = connection.prepareStatement(findAllSql);
             ResultSet rs = psmt.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setSex(rs.getInt("sex"));
                employee.setTimes(rs.getObject("times", LocalDateTime.class));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    //根據ID刪除
    public void deleteEmployee(int employeeId) {
//        private static final String deleteSql = "delete from user where employee_id=?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement psmt = connection.prepareStatement(deleteSql);
        ) {
            psmt.setInt(1, employeeId);
            int i = psmt.executeUpdate();//executeUpdate 會有回傳值 返回受影響的行數
            if (i > 0) {
                System.out.println("資料庫更新成功，影響了" + i + "行");
            }else {
                System.out.println("刪除失敗");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根據ID更新資料
    public void updateEmployee(Employee emp) {
//        private static final String updateSql = "UPDATE user SET name = ?, SEX=?, times=? WHERE employee_id=?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement psmt = connection.prepareStatement(updateSql);
        ) {
            psmt.setString(1, emp.getName());
            psmt.setInt(2, emp.getSex());
            psmt.setObject(3, emp.getTimes());
            psmt.setInt(4, emp.getEmployeeId());
            int i = psmt.executeUpdate();
            if (i > 0) {
                System.out.println("資料庫更新成功，影響了" + i + "行");
            }else {
                System.out.println("更新失敗");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

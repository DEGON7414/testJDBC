import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: EmployeeDAO
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/24 下午 03:46
 * @Version 1.0
 */
public class EmployeeDAO {
    //增加員工
    public void addEmployee(Employee emp) {
        String sql = "insert into user(name,sex,times) values(?,?,?)";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql);) {
            psmt.setString(1, emp.getName());
            psmt.setInt(2, emp.getSex());
            psmt.setTimestamp(3, emp.getTimes());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根據ID查員工
    public Employee getEmployee(int employeeId) {
        String sql = "select * from user where employee_id=?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql);) {
            psmt.setInt(1, employeeId);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(employeeId);
                employee.setName(rs.getString("name"));
                employee.setSex(rs.getInt("sex"));
                employee.setTimes(rs.getTimestamp("times"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查全部
    public List<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        String sql = "select * from user";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement psmt = connection.prepareStatement(sql);
             ResultSet rs = psmt.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setSex(rs.getInt("sex"));
                employee.setTimes(rs.getTimestamp("times"));
                employees.add(employee);
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        return employees;
    }
    //根據ID刪除
    public void deleteEmployee(int employeeId) {
        String sql = "delete from user where employee_id=?";
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
           ) {
            psmt.setInt(1, employeeId);
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //根據ID更新資料
    public void updateEmployee(Employee emp) {
        String sql = "UPDATE user SET name = ?, SEX=?, times=? WHERE employee_id=?";
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
            ) {
            psmt.setString(1, emp.getName());
            psmt.setInt(2,emp.getSex());
            psmt.setTimestamp(3, emp.getTimes());
            psmt.setInt(4, emp.getEmployeeId());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

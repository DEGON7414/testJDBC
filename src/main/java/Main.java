import java.sql.SQLException;

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
        UserDao userDao = new UserDao();
        userDao.queryAllEmployeeId();
        userDao.findNameById(1);
    }
}

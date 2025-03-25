import java.sql.*;



/**
 * ClassName: JDBCUtils
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/21 上午 11:59
 * @Version 1.0
 */
public class JDBCUtils {
    private static final String URL = "jdbc:mysql://61.66.110.147:3306/mysql999?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql9@90";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER);

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        try{
            if(rs != null){
                rs.close();
            }
        if(stmt != null){
            stmt.close();
        }
        if(conn != null){
            conn.close();
        }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //
    public static void close(Connection conn, Statement stmt){
        try {
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

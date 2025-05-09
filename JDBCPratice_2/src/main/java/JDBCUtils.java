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
    //設定所需要的資訊
    private static final String URL = "jdbc:mysql://61.66.110.147:3306/sample?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql9@90";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //1.靜態區塊 類別載入時啟動 //有些新版可以省略 會自動註冊
    static {
        try {
            //2.啟動JDBC驅動 類別註冊
            Class.forName(DRIVER);

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //3.建立連線
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    //4.可選 關連線 也可不要寫 使用try with resource 關閉連線
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

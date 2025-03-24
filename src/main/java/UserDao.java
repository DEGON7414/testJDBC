import java.sql.*;

public class UserDao {
        public void queryAllEmployeeId() throws SQLException {

                String sql = "SELECT employee_id FROM user";
            try (Connection conn = JDBCUtils.getConnection();//1.建立連線
                 Statement stmt = conn.createStatement();//2.準備指令
                 ResultSet rs = stmt.executeQuery(sql)) {//3.放入SQL並執行資料庫指令
                    //.next方法檢查是否有下一行資料 有的話執行迴圈 沒的話結束
                while (rs.next()) {
                    //4.取得回傳結果
                    //.getint () 內填入資料庫欄位 代表取得該欄位的值
                    int employeeId = rs.getInt("employee_id");

                    System.out.println(employeeId);
                }
            }
        }
    //
    public void findNameById(int employee_id) throws SQLException {
        Connection conn = null;//初始化
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            conn = JDBCUtils.getConnection();//開啟連線
            String sql = "SELECT name FROM user WHERE employee_id=?";//SQL字串

            pstmt = conn.prepareStatement(sql);//準備SQL指令
            pstmt.setInt(1, employee_id);//1代表employee_id參數會回應第一個問號

            rs = pstmt.executeQuery();//執行SQL 並把結果放到ResultSet rs
            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }else {
                System.out.println("NOT FOUND");

        }
        }finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
    }
}




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OrdersDao
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/26 上午 10:54
 * @Version 1.0
 */
//注意變數常數命名規則
// 如果只有一個物件的可以先拉上去 new 然後= null
// 通常list的命名可以加list增加辨識度
// 刪除、更新、增加改成boolean 將結果回給service service再回給main
public class OrdersDao {
    private final static String getSql = "select * from orders where id = ?";
    private final static String insertSql = "INSERT INTO orders (order_number,current_exchange_rate,order_fee,total_product_price,last_modify_employee_id,created_employee_id,is_shopee_order) VALUES (?,?,?,?,?,?,?)";
    private final static String getAllSql = "select * from orders";
    private final static String updateSql = "UPDATE orders SET status = ? WHERE id = ?";
    private final static String deleteSql = "DELETE FROM orders WHERE id = ?";

    //透過 ID查訂單編號、顧客ID、訂單日期、買家船運關稅
    public Orders getOrderById(int id) {
//    String getSql = "select * from orders where id = ?";
        //前面直接new 完設 NULL 導致 他撈資料失敗
        //物件變數設置null 他會改指向null(沒有任何物件) 而非本來的物件
        Orders order = null;
        try (Connection conn = JDBCUtils.getConnection(); //1.建立連線
             PreparedStatement stmt = conn.prepareStatement(getSql);//2.準備指令(放入SQL)
             ) {
            stmt.setInt(1, id);//3.使用id 回答上面SQL的問號
            try (ResultSet rs = stmt.executeQuery()//4.執行查詢並把結果 用ResultSet rs接下
            ) {
                if (rs.next() //指 結果
                ) {
                    order = new Orders();
                    //get資料中 欄位是order_number的資料 然後 set到order物件的OrderNumber屬性。
                    order.setOrderNumber(rs.getString("order_number"));
                    order.setCustomerId(rs.getInt("customer_id"));
                    order.setOrderDate(rs.getDate("order_date"));
                    order.setBuyerShippingFee(rs.getDouble("buyer_shipping_fee"));
                    return order; //有回傳值就結束 傳回給上面的order 傳回給上面的order
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;//傳回給上面的order 傳回給service
    }

    //增加訂單 (訂單編號、匯率、稅、商品總價、最後操作員工編號、創建員工編號、是否為蝦皮訂單)
    public void insertOrder(Orders order) {
        //String insertSql = "INSERT INTO orders (order_number,current_exchange_rate,order_fee,total_product_price,last_modify_employee_id,created_employee_id,is_shopee_order) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = JDBCUtils.getConnection();//1.建立連線
             PreparedStatement preparedStatement = conn.prepareStatement(insertSql))//準備指令(放入SQL)
        {
            preparedStatement.setString(1, order.getOrderNumber());
            preparedStatement.setDouble(2, order.getCurrentExchangeRate());
            preparedStatement.setDouble(3, order.getOrderFee());
            preparedStatement.setDouble(4, order.getTotalProductPrice());
            preparedStatement.setInt(5, order.getLastModifyEmployeeId());
            preparedStatement.setInt(6, order.getCreatedEmployeeId());
            preparedStatement.setBoolean(7, order.getShopeeOrder());
            int ok = preparedStatement.executeUpdate();
            if (ok > 0) {
                System.out.println("DAO新增成功");
            } else {
                System.out.println("DAO 新增失敗");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //查詢全部訂單的id 訂單編號 產品總價 訂單日期  狀態
    public List<Orders> getAllOrders() {
        //String getAllSql = "select * from orders";
        List<Orders> ordersList = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getAllSql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Orders order = new Orders();
                order.setId(rs.getInt("id"));
                order.setOrderNumber(rs.getString("order_number"));
                order.setTotalProductPrice(rs.getDouble("total_product_price"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setStatus(rs.getString("status"));
                ordersList.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ordersList;
    }

    //根據id更新訂單狀態
    public boolean updateOrder(Orders order) {
//        String updateSql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, order.getStatus());
            preparedStatement.setInt(2, order.getId());
            int ok = preparedStatement.executeUpdate();
            if (ok > 0) {
                System.out.println("DAO 更新成功" + "更新訂單為" + order.getId() + "狀態為:" + order.getStatus());
                return true;//有回傳值就結束方法
            } else {
                System.out.println("DAO更新失敗");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    //根據id刪除
    public boolean deleteOrder(int id) {
//        String deleteSql = "DELETE FROM orders WHERE id = ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(deleteSql)) {
            preparedStatement.setInt(1, id);
            int ok = preparedStatement.executeUpdate();

            if (ok > 0) {
                System.out.println("DAO刪除成功:" + id);
                return true;
            } else {
                System.out.println("DAO刪除失敗");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}

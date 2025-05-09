import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OrderShoppesDAO
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/31 上午 10:30
 * @Version 1.0
 */
public class OrderShoppesDAO {

    private static final String GETONESQL = "SELECT * FROM orders_shopee WHERE id = ?";
    private static final String GETALLSQL = "SELECT * FROM orders_shopee ";
    private static final String INSERTORDERSQL = "INSERT INTO orders_shopee(order_id,buyer_account)VALUES(?,?)";
    private static final String UPDATESQL = "UPDATE orders_shopee SET buyer_account = ? WHERE id = ?";
    private static final String DELETESQL = "DELETE FROM orders_shopee WHERE id = ?";

    //用ID查詢單筆
    public OrderShoppesEntity getOrderById(int id) {
//       private static final String GETONESQL = "SELECT * FROM orders_shopee WHERE id = ?";

        OrderShoppesEntity order = null;
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GETONESQL);
        ) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    order = new OrderShoppesEntity();
                    order.setId(resultSet.getInt("id"));
                    order.setOrderId(resultSet.getInt("order_id"));
                    order.setBuyerAccount(resultSet.getString("buyer_account"));
                    order.setBuyerShopeeShippingFee(resultSet.getDouble("buyer_shopee_shipping_fee"));
                    return order;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    //查詢全部訂單
    public List<OrderShoppesEntity> getAllOrderShoppes() {
//        String GETALLSQL = "SELECT * FROM orders_shopee ";
        ArrayList<OrderShoppesEntity> ordersList = new ArrayList<>();
        try (
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GETALLSQL);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                OrderShoppesEntity order = new OrderShoppesEntity();
                order.setId(resultSet.getInt("id"));
                order.setOrderId(resultSet.getInt("order_id"));
                order.setBuyerAccount(resultSet.getString("buyer_account"));
                order.setBuyerShopeeShippingFee(resultSet.getDouble("buyer_shopee_shipping_fee"));
                ordersList.add(order);
                return ordersList;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ordersList;

    }

    // 新增
    public boolean insertOrder(OrderShoppesEntity order) {
//        String INSERTORDERSQL = "INSERT INTO orders_shopee(order_id,buyer_account) VALUES(?,?)";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERTORDERSQL)
        ) {
            preparedStatement.setInt(1, order.getOrderId());
            preparedStatement.setString(2, order.getBuyerAccount());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    //更新 買家帳號
    public boolean updateOrder(OrderShoppesEntity order) {
//        String UPDATESQL = "UPDATE orders_shopee SET buyer_account = ? WHERE id = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATESQL)) {
            preparedStatement.setString(1, order.getBuyerAccount());
            preparedStatement.setInt(2, order.getId());
            int resulut = preparedStatement.executeUpdate();
            if (resulut > 0) {
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    //刪除
    public boolean deleteOrderById(int id) {
//        String DELETESQL = "DELETE FROM orders_shopee WHERE id = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETESQL)) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;

    }


}

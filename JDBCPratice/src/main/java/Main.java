import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: Main
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/26 上午 11:09
 * @Version 1.0
 */
//在這裡做顯示 判斷有無成功
public class Main {
    public static void main(String[] args) {
        OrdersService ordersService = new OrdersService();
        //查訂單
//        ordersService.getOrderById(385144);
        //查全部

//        List<Orders> ordersList = ordersService.getAllOrders();
//        for (Orders order : ordersList) {
//            System.out.println(order.getOrderNumber());
//        }
//        //新增
//        Orders orders = new Orders();
//        orders.setOrderNumber("B2");
//        orders.setCurrentExchangeRate(1.0);
//        orders.setOrderFee(1000.0);
//        orders.setTotalProductPrice(500.0);
//        orders.setShopeeOrder(Boolean.TRUE);
//        orders.setLastModifyEmployeeId(38);
//        orders.setCreatedEmployeeId(2);
//        ordersService.insertOrder(orders);
        //刪除
//        boolean b = ordersService.deleteOrder(385157);
//        System.out.println(b);

        //更新
        Orders orders = new Orders();
        orders.setId(385154);
        orders.setStatus("已出貨");
        boolean b = ordersService.updateOrder(orders);
        System.out.println(b);

    }
}
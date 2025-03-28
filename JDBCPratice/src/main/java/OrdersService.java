import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OrdersService
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/26 上午 11:10
 * @Version 1.0
 */
//顯示有無成功 應當在main中做判斷
// 這裡依樣是傳布林值
public class OrdersService {
    private final OrdersDao ordersDao = new OrdersDao();

    //查詢
    public Orders getOrderById(int id) {
        Orders orders = ordersDao.getOrderById(id); //1.先執行然後將結果存到orders 物件
        if (orders != null) //2.判斷是不是空的
        {
            System.out.println(orders);
        } else {
            System.out.println("找不到此ID");
        }
        return orders; //回給main
    }

    //查全部
    public List<Orders> getAllOrders() {
        List<Orders> orders = ordersDao.getAllOrders();//1.查全部訂單
//        for (Orders order : Orders) {
//            System.out.println(order);
//        }
        return orders; // 回給main
    }

    //新增
    public void insertOrder(Orders order) {
        if (order != null) {
            ordersDao.insertOrder(order);
        } else {
            System.out.println("訂單為空");
        }
    }

    //更新
    public boolean updateOrder(Orders order) {
        if (order != null) {
            boolean b = ordersDao.updateOrder(order);
            if (b)//()沒設東西 預設 就是代表 true
            {
//            System.out.println("service 更新成功");
                return true;
            }
        } else {
            System.out.println("service 更新失敗");
        }
        return false;
    }

    //刪除
    public boolean deleteOrder(int id) {
        Orders order = ordersDao.getOrderById(id);
        if ( order!= null) {
            boolean b = ordersDao.deleteOrder(id);
            if (b) {
                return true;
            }
        } else {
//            System.out.println("service 刪除未成功");
        }
        return false;
    }
}

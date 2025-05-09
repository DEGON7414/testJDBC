import javax.lang.model.element.VariableElement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class OrderShoppesService {
    OrderShoppesDAO orderDAO = new OrderShoppesDAO();

    //查詢單筆
    public OrderShoppesEntity getOrderById(int id) {
        OrderShoppesEntity orderById = orderDAO.getOrderById(id);
        if (orderById != null) {
            return orderById;
        } else {
            return null;
        }
    }

    //查詢全部
    public List<OrderShoppesEntity> getAllOrderShoppesOrder() {
        List<OrderShoppesEntity> ordersList = orderDAO.getAllOrderShoppes();
        if (ordersList != null) {
            return ordersList;
        } else {
            return null;
        }
    }

    //新增
    public boolean insertOrder(OrderShoppesEntity order) {
        if (order != null) {
            boolean b = orderDAO.insertOrder(order);
            return b;
        }
        return false;
    }

    //更新
    public boolean updateOrder(OrderShoppesEntity order) {
        if (order != null) {
            boolean b = orderDAO.updateOrder(order);
            return b;
        }
        return false;
    }

    //刪除
    public boolean deleteOrder(int id) {
        if (orderDAO.getOrderById(id) != null) {
            boolean b = orderDAO.deleteOrderById(id);
            return b;
        }

        return false;
    }


}

import java.util.List;

/**
 * ClassName: Main
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/31 上午 11:12
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        OrderShoppesService orderService = new OrderShoppesService();
        //查詢單
//        orderService.getOrderById(376609);

        //查詢全部
//        List<OrderShoppesEntity> allOrderList = orderService.getAllOrderShoppesOrder();
//        for (OrderShoppesEntity order : allOrderList) {
//            System.out.println(order);
//        }
        //新增
//        OrderShoppesEntity order = new OrderShoppesEntity();
//        order.setOrderId(114514);
//        order.setBuyerAccount("卡哇幫嘎");
//        boolean b = orderService.insertOrder(order);
//        System.out.println("新增成果"+b);
        //刪除
//        boolean b = orderService.deleteOrder(376612);
//        System.out.println("刪除結果"+b);
        //更新
//        OrderShoppesEntity order = new OrderShoppesEntity();
//        order.setId(376614);
//        order.setBuyerAccount("林家菇");
//        boolean b = orderService.updateOrder(order);
//        System.out.println("更新結果:"+b+"\n"+order);

    }

}

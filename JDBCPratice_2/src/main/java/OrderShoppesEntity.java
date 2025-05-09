/**
 * ClassName: orders_shoppes_Entity
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/31 上午 10:27
 * @Version 1.0
 */
public class OrderShoppesEntity {
    private int id;
    private int orderId;
    private String buyerAccount;
    private double buyerShopeeShippingFee;
    private double buyerShopeeCoin;
    private double buyerPaymentSellerCoupon;
    private double sellerHandlingCharge;
    private double sellerActivityServiceCharge;
    private double sellerPaymentServiceCharge;
    private double shopeeProvideShippingFee;
    private double shopeeProvideDiscountFee;
    private double generalPaymentSellerCoupon;

    public OrderShoppesEntity() {
    }

    @Override
    public String toString() {
        return "orders{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", buyerAccount='" + buyerAccount + '\'' +
                ", buyerShopeeShippingFee=" + buyerShopeeShippingFee +
                ", buyerShopeeCoin=" + buyerShopeeCoin +
                ", buyerPaymentSellerCoupon=" + buyerPaymentSellerCoupon +
                ", sellerHandlingCharge=" + sellerHandlingCharge +
                ", sellerActivityServiceCharge=" + sellerActivityServiceCharge +
                ", sellerPaymentServiceCharge=" + sellerPaymentServiceCharge +
                ", shopeeProvideShippingFee=" + shopeeProvideShippingFee +
                ", shopeeProvideDiscountFee=" + shopeeProvideDiscountFee +
                ", generalPaymentSellerCoupon=" + generalPaymentSellerCoupon +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGeneralPaymentSellerCoupon() {
        return generalPaymentSellerCoupon;
    }

    public void setGeneralPaymentSellerCoupon(double generalPaymentSellerCoupon) {
        this.generalPaymentSellerCoupon = generalPaymentSellerCoupon;
    }

    public double getShopeeProvideDiscountFee() {
        return shopeeProvideDiscountFee;
    }

    public void setShopeeProvideDiscountFee(double shopeeProvideDiscountFee) {
        this.shopeeProvideDiscountFee = shopeeProvideDiscountFee;
    }

    public double getShopeeProvideShippingFee() {
        return shopeeProvideShippingFee;
    }

    public void setShopeeProvideShippingFee(double shopeeProvideShippingFee) {
        this.shopeeProvideShippingFee = shopeeProvideShippingFee;
    }

    public double getSellerPaymentServiceCharge() {
        return sellerPaymentServiceCharge;
    }

    public void setSellerPaymentServiceCharge(double sellerPaymentServiceCharge) {
        this.sellerPaymentServiceCharge = sellerPaymentServiceCharge;
    }

    public double getSellerActivityServiceCharge() {
        return sellerActivityServiceCharge;
    }

    public void setSellerActivityServiceCharge(double sellerActivityServiceCharge) {
        this.sellerActivityServiceCharge = sellerActivityServiceCharge;
    }

    public double getSellerHandlingCharge() {
        return sellerHandlingCharge;
    }

    public void setSellerHandlingCharge(double sellerHandlingCharge) {
        this.sellerHandlingCharge = sellerHandlingCharge;
    }

    public double getBuyerPaymentSellerCoupon() {
        return buyerPaymentSellerCoupon;
    }

    public void setBuyerPaymentSellerCoupon(double buyerPaymentSellerCoupon) {
        this.buyerPaymentSellerCoupon = buyerPaymentSellerCoupon;
    }

    public double getBuyerShopeeCoin() {
        return buyerShopeeCoin;
    }

    public void setBuyerShopeeCoin(double buyerShopeeCoin) {
        this.buyerShopeeCoin = buyerShopeeCoin;
    }

    public double getBuyerShopeeShippingFee() {
        return buyerShopeeShippingFee;
    }

    public void setBuyerShopeeShippingFee(double buyerShopeeShippingFee) {
        this.buyerShopeeShippingFee = buyerShopeeShippingFee;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}

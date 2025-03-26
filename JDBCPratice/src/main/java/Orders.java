import java.util.Date;

/**
 * ClassName: OrdersEntity
 * Description:
 *
 * @Author 許記源
 * @Create 2025/3/26 上午 10:43
 * @Version 1.0
 */
//類型不要用 包裝類的 能用基本用基本
public class Orders {
    private Integer id;
    private String orderNumber;
    private Integer customerId;
    private Integer currencyId = 3;
    private Double currentExchangeRate;
    private Date orderDate;
    private Double orderFee;
    private Double totalProductPrice;
    private Date paymentDate;
    private String paymentType;
    private Double paymentFee;
    private String paymentNote;
    private String shippingType;
    private Double buyerShippingFee;
    private Double sellerShippingFee = 0.0;
    private String recipientName;
    private String recipientPhone;
    private String shippingAddress;
    private String shippingStoreNumber;
    private Boolean isValid = true;
    private Boolean isOutstandingPayment = false;
    private String status = "待出貨";
    private String sellerNote;
    private Boolean isShipped = false;
    private Date lastModifyDate;
    private Integer lastModifyEmployeeId;
    private Integer createdEmployeeId;
    private Date createdDate;
    private Boolean isShopeeOrder;
    private Boolean isReturnOrder = false;
    private Double refundAmount = 0.0d;
    private Integer shopId = 2;

    public Orders() {
    }



    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getCurrentExchangeRate() {
        return currentExchangeRate;
    }

    public void setCurrentExchangeRate(Double currentExchangeRate) {
        this.currentExchangeRate = currentExchangeRate;
    }

    public java.sql.Date getOrderDate() {
        return (java.sql.Date) orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(Double orderFee) {
        this.orderFee = orderFee;
    }

    public Double getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(Double totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(Double paymentFee) {
        this.paymentFee = paymentFee;
    }

    public String getPaymentNote() {
        return paymentNote;
    }

    public void setPaymentNote(String paymentNote) {
        this.paymentNote = paymentNote;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public Double getBuyerShippingFee() {
        return buyerShippingFee;
    }

    public void setBuyerShippingFee(Double buyerShippingFee) {
        this.buyerShippingFee = buyerShippingFee;
    }

    public Double getSellerShippingFee() {
        return sellerShippingFee;
    }

    public void setSellerShippingFee(Double sellerShippingFee) {
        this.sellerShippingFee = sellerShippingFee;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingStoreNumber() {
        return shippingStoreNumber;
    }

    public void setShippingStoreNumber(String shippingStoreNumber) {
        this.shippingStoreNumber = shippingStoreNumber;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Boolean getOutstandingPayment() {
        return isOutstandingPayment;
    }

    public void setOutstandingPayment(Boolean outstandingPayment) {
        isOutstandingPayment = outstandingPayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public void setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
    }

    public Boolean getShipped() {
        return isShipped;
    }

    public void setShipped(Boolean shipped) {
        isShipped = shipped;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public Integer getLastModifyEmployeeId() {
        return lastModifyEmployeeId;
    }

    public void setLastModifyEmployeeId(Integer lastModifyEmployeeId) {
        this.lastModifyEmployeeId = lastModifyEmployeeId;
    }

    public Integer getCreatedEmployeeId() {
        return createdEmployeeId;
    }

    public void setCreatedEmployeeId(Integer createdEmployeeId) {
        this.createdEmployeeId = createdEmployeeId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getShopeeOrder() {
        return isShopeeOrder;
    }

    public void setShopeeOrder(Boolean shopeeOrder) {
        isShopeeOrder = shopeeOrder;
    }

    public Boolean getReturnOrder() {
        return isReturnOrder;
    }

    public void setReturnOrder(Boolean returnOrder) {
        isReturnOrder = returnOrder;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    @Override
    public String toString() {
        return "OrdersEntity{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", customerId=" + customerId +
                ", currencyId=" + currencyId +
                ", currentExchangeRate=" + currentExchangeRate +
                ", orderDate=" + orderDate +
                ", orderFee=" + orderFee +
                ", totalProductPrice=" + totalProductPrice +
                ", paymentDate=" + paymentDate +
                ", paymentType='" + paymentType + '\'' +
                ", paymentFee=" + paymentFee +
                ", paymentNote='" + paymentNote + '\'' +
                ", shippingType='" + shippingType + '\'' +
                ", buyerShippingFee=" + buyerShippingFee +
                ", sellerShippingFee=" + sellerShippingFee +
                ", recipientName='" + recipientName + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", shippingStoreNumber='" + shippingStoreNumber + '\'' +
                ", isValid=" + isValid +
                ", isOutstandingPayment=" + isOutstandingPayment +
                ", status='" + status + '\'' +
                ", sellerNote='" + sellerNote + '\'' +
                ", isShipped=" + isShipped +
                ", lastModifyDate=" + lastModifyDate +
                ", lastModifyEmployeeId=" + lastModifyEmployeeId +
                ", createdEmployeeId=" + createdEmployeeId +
                ", createdDate=" + createdDate +
                ", isShopeeOrder=" + isShopeeOrder +
                ", isReturnOrder=" + isReturnOrder +
                ", refundAmount=" + refundAmount +
                ", shopId=" + shopId +
                '}';
    }
}

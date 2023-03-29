package space.pandaer.entity;

import java.math.BigDecimal;

/**
 * 订单信息
 */
public class OrderInfo {
    private Integer count;
    private BigDecimal totalPrice;
    private String orderNum;

    public OrderInfo() {
    }

    public OrderInfo(Integer count, BigDecimal totalPrice, String orderNum) {
        this.count = count;
        this.totalPrice = totalPrice;
        this.orderNum = orderNum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}

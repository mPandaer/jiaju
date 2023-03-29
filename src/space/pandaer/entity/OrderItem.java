package space.pandaer.entity;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id; //当前订单项的ID
    private String name; //家居名
    private BigDecimal price; //单价
    private Integer count; //购买数量
//    private BigDecimal totalPrice; //购买总价 --修改为一个get方法
    private Integer orderId;//当前订单项属于的那个订单的id
    private Integer householdId;//当前订单项对应的家居信息的ID

    public OrderItem() {
    }

    public OrderItem(Integer id, String name, BigDecimal price,
                     Integer count, Integer orderId, Integer householdId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.orderId = orderId;
        this.householdId = householdId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return this.price.multiply(new BigDecimal(this.count));
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    //方便测试

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + getTotalPrice() +
                ", orderId=" + orderId +
                ", householdId=" + householdId +
                '}';
    }
}

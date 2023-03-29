package space.pandaer.entity;


import java.math.BigDecimal;
import java.util.List;

//订单
public class Order {
    private Integer id; //当前订单的ID
    private String orderNum; //订单号 -- 准备用UUID来生成
    private String date;//日期，准备用LocalDate类
    private BigDecimal price; //当前订单总价
    private Integer state = 0; //当前订单状态, 0表示未发货
    private Integer userId; //表示这个订单属于哪个用户

    public Order() {
    }

    public Order(Integer id, String orderNum, String date, BigDecimal price, Integer state, Integer userId) {
        this.id = id;
        this.orderNum = orderNum;
        this.date = date;
        this.price = price;
        this.state = state;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    //为了方便测试

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", userId=" + userId +
                '}';
    }
}

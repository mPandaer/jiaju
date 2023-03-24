package space.pandaer.entity;

import java.math.BigDecimal;

/**
 * 家居类
 */
public class HouseHold {
    private Integer id;
    private String name;
    private String manu; //制造商
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String imgPath = "assets/images/product-image/default.jpg";

    public HouseHold(String name, String manu, BigDecimal price, Integer sales, Integer stock) {
        this.name = name;
        this.manu = manu;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
    }

    public HouseHold(Integer id, String name, String manu, BigDecimal price, Integer sales, Integer stock) {
        this.id = id;
        this.name = name;
        this.manu = manu;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
    }

    public HouseHold(Integer id, String name, String manu, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.manu = manu;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.imgPath = imgPath;
    }

    public HouseHold() {
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

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }


    @Override
    public String toString() {
        return "HouseHold{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manu='" + manu + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}

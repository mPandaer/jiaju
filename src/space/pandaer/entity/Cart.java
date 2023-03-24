package space.pandaer.entity;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    //静态内部类
    public static class CartItem {
        private Integer id;
        private String name;
        private String imgPath;
        private BigDecimal price;
        private Integer count;

        public CartItem() {
        }

        public CartItem(Integer id, String name, String imgPath, BigDecimal price, Integer count) {
            this.id = id;
            this.name = name;
            this.imgPath = imgPath;
            this.price = price;
            this.count = count;
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

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getTotalPrice() {
            return this.getPrice().multiply(new BigDecimal(this.getCount()));
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    //通过CartItem id作为key
    private Map<Integer,CartItem> items = new HashMap<>();

    public int getTotalCount(){
        int ans = 0;
        if (items == null) return 0;
        for (CartItem item : items.values()) {
            ans += item.getCount();
        }
        return ans;
    }

    public void clear() {
        items.clear();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal ans = new BigDecimal(0);
        if (items == null) return new BigDecimal(0);
        for (CartItem item : items.values()) {
            ans = ans.add(item.getTotalPrice());
        }
        return ans;
    }

    public boolean addItem(CartItem cartItem) {
        if (cartItem == null) return false;
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        }else {
            item.setCount(item.getCount() + 1);
        }
        return true;
    }

    public boolean deleteById(Integer id) {
        if (id == null) return false;
        return items.remove(id) != null;
    }

    public Collection<CartItem> getItems(){
        return items.values();
    }

    public boolean update(Integer id,Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem == null) return false;
        cartItem.setCount(count);
        return true;
    }


}

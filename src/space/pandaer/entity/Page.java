package space.pandaer.entity;

import java.util.List;

//分页模型 -- 保存分页信息
public class Page<T> {
    private Integer pageNo;
    private Integer pageSize;
    private Long pageSum; //总个数
    private Integer pageCount; //总页数
    private List<T> items;
    private String url;

    public Page(Integer pageNo, Integer pageSize, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.items = items;
    }

    public Page(Integer pageNo, Integer pageSize, Long pageSum, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageSum = pageSum;
        this.items = items;
    }

    public Page(Integer pageNo, Integer pageSize, Long pageSum, Integer pageCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageSum = pageSum;
        this.pageCount = pageCount;
        this.items = items;
    }

    public Page() {
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Long getPageSum() {
        return pageSum;
    }

    public void setPageSum(Long pageSum) {
        this.pageSum = pageSum;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", items=" + items +
                '}';
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}

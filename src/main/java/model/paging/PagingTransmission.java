package model.paging;

/**
 * 分页输入参数
 * @author zhipeng
 * @Date: Created in  2018-01-15 
 * @name PagingTransmission.java
 * @info TODO
 */
public class PagingTransmission {

    private int		size;
    private int		page;
    private String	order;
    private String	ascOrDesc;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getAscOrDesc() {
        return ascOrDesc;
    }

    public void setAscOrDesc(String ascOrDesc) {
        this.ascOrDesc = ascOrDesc;
    }
}

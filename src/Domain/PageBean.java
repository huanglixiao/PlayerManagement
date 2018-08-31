package Domain;

import java.util.List;

public class PageBean<Object> {

    private int pageCode;

    private int totalRecords;

    private int pageRecords;

    private List<Object> beanList;

    private String url;

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageRecords() {
        return pageRecords;
    }

    public void setPageRecords(int pageRecords) {
        this.pageRecords = pageRecords;
    }

    public List<Object> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<Object> beanList) {
        this.beanList = beanList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotalPages(){
        int totalPages = totalRecords / pageRecords;
        return totalRecords % pageRecords == 0 ? totalPages : totalPages + 1;
    }
}

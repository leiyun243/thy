package com.ad.thy.util;

public class PageUtil {

    private int pageNo;
    private int pageSize;
    private int totalCount;
    private int totalPage;

    public PageUtil() {
        this.pageNo = 1;
        this.pageSize = 10;
    }

    public int getPageNo() {
        if(pageNo <= 0){
            pageNo = 1;
        }
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        if(pageSize <= 0){
            pageSize = 10;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPage = (totalCount - 1) / pageSize + 1;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                '}';
    }
}

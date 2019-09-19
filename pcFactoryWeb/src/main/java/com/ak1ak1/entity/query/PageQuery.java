package com.ak1ak1.entity.query;

import java.io.Serializable;

public class PageQuery implements Serializable{
  
	private static final long serialVersionUID = 7477913565654472067L;
	private int page;
    private int limit;

    public PageQuery() {
    	super();
    }

    public PageQuery(int page, int limit) {
		this.page = page;
		this.limit = limit;
    }

    public int getPage() {
    	return page > 0 ? page : 1;
    }

    public void setPage(int page) {
    	this.page = page;
    }

    public int getLimit() {
    	return limit > 0 ? limit : 0;
    }

    public void setLimit(int limit) {
    	this.limit = limit;
    }

    public int getmStartRow() {
		if (this.getPage() <= 0) {
		    return 0;
		}
		
		return (this.getPage() - 1) * limit;
    }

}

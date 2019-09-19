package com.ak1ak1.entity.query;

import java.io.Serializable;
import java.util.List;

public class QueryResult<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6094354408000798951L;
	private int mPages;// 总页数
	private int mRecords;// 总记录数
	private List<T> mItems;
	
	public QueryResult() {
		super();
	}

	public QueryResult(int mPages, int mRecords, List<T> mItems) {
		super();
		this.mPages = mPages;
		this.mRecords = mRecords;
		this.mItems = mItems;
	}
	
	public QueryResult(List<T> mItems,int mRecords,int mPageSize) {
		super();
		this.mRecords = mRecords;
		this.mItems = mItems;
		this.mPages = (mRecords - 1) / mPageSize + 1;
	}

	public int getmPages() {
		return mPages;
	}

	public void setmPages(int mPages) {
		this.mPages = mPages;
	}

	public void setmPages(int mRecords, int mpageSize) {
		this.mPages = (mRecords - 1) / mpageSize + 1;
	}

	public int getmRecords() {
		return mRecords;
	}

	public void setmRecords(int mRecords) {
		this.mRecords = mRecords;
	}

	public List<T> getmItems() {
		return mItems;
	}

	public void setmItems(List<T> mItems) {
		this.mItems = mItems;
	}

}

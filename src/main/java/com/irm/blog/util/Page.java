package com.irm.blog.util;

import java.util.List;

public class Page<T> {

	private Integer pageIndex = 1;

	private Integer totalCount = 0;

	private Integer pageSize = 3;

	private Integer totalPageCount;

	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		if(pageIndex != null && pageIndex > 0){
			this.pageIndex = pageIndex;
		}
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		if(totalCount > 0){
			this.totalCount = totalCount;

			this.setTotalPageCountByRs();
		}else{
			this.totalCount = 0;
			this.setTotalPageCountByRs();
		}
	}
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize > 0){
			this.pageSize = pageSize;
		}
	}

	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	public void setTotalPageCountByRs(){
		if(this.totalCount % this.pageSize == 0){
			this.totalPageCount = this.totalCount / this.pageSize;
		}else if(this.totalCount % this.pageSize > 0){
			this.totalPageCount = this.totalCount / this.pageSize + 1;
		}else{
			this.totalPageCount = 1;
		}
	}
	
}
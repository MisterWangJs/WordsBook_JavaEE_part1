package util;

import java.util.List;

public class PageBeanMoHu<T> {
	private int pageIndex;
	private int pageSize;
	private int count;
	private int pageCount;
	private int start;
	private int end;
	private List<T> list = null;
	
	public void init() {
	
		if(count % pageSize == 0)
			pageCount = count / pageSize;
		else
			pageCount = count / pageSize + 1;

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		if (pageIndex < 1) {
			pageIndex = 1;
		}

		this.start = (pageIndex - 1) * pageSize ;
		this.end = pageIndex * pageSize;
	}
	
	public PageBeanMoHu(int pageIndex, int count, int pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.count = count;
		this.pageSize = pageSize;
	}

	public PageBeanMoHu(int pageIndex, int count, int pageSize, List<T> list) {
		super();
		this.pageIndex = pageIndex;
		this.count = count;
		this.pageSize = pageSize;
		this.list = list;
	}

	public PageBeanMoHu() {
		super();
	}

	@Override
	public String toString() {
		return "PageBeanMoHu [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", count=" + count + ", pageCount="
				+ pageCount + ", start=" + start + ", end=" + end + ", list=" + list + "]";
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}

package com.ycz.pojo;

import java.util.List;

/**
 * 此类用封装分页查询结果
 * @author Administrator
 *
 */
public class Page<T> {
	
	private List<T> datas;//查询到的结果集
	private int page;//页码
	private int maxPage;//最大页码
	private int totalSize;//总记录条数
	private List<Lend> lends;//未归还的书籍ID结果集
	
    public List<Lend> getLends() {
        return lends;
    }
    
    public void setLends(List<Lend> lends) {
        this.lends = lends;
    }
    public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

}

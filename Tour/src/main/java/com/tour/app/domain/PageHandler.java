package com.tour.app.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PageHandler {
	private int totalCnt; //총 게시물 갯수
	private int pageSize; //한페이지의 크기(한페이지에 몇 개의 목록이 있는지)
	private int naviSize=5; //페이지 네비게이션의 크기
	private int totalPage; //전체 페이지의 갯수(마지막 페이지숫자)
	private int page; //현재 페이지 번호
	private int beginPage; //네이게이션의 첫번째 페이지
	private int endPage; //네이게이션의 마지막 페이지
	private boolean showPrev; //이전페이지를 보여줄건지. 첫번째페이지에는 없어야함.
	private boolean showNext; //다음페이지를 보여줄건지. 마지막페이지에는 없어야함.

	public PageHandler(int totalCnt, int page) {
		this(totalCnt, page, 10);
	}
	
	public PageHandler(int totalCnt, int page, int pageSize) {
		this.totalCnt = totalCnt;
		this.page=page;
		this.pageSize=pageSize;
		
		totalPage = (int)Math.ceil(totalCnt/(double)pageSize);
		beginPage = (page/naviSize)*naviSize+1;
		endPage = Math.min(beginPage+naviSize-1, totalPage);
		showPrev = beginPage != 1;
		showNext = endPage != totalPage;
	}
	
	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isShowPrev() {
		return showPrev;
	}

	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	void print() {
		System.out.println("page="+page);
		System.out.print(showPrev ? "<  " : "");
		for(int i=beginPage;i<=endPage;i++) {
			System.out.print(i+" ");
		}
		System.out.println(showNext ? " >" : "");
	}

	@Override
	public String toString() {
		return "PageHandler [totalCnt=" + totalCnt + ", pageSize=" + pageSize + ", naviSize=" + naviSize
				+ ", totalPage=" + totalPage + ", page=" + page + ", beginPage=" + beginPage + ", endPage=" + endPage
				+ ", showPrev=" + showPrev + ", showNext=" + showNext + "]";
	}
	
		
}

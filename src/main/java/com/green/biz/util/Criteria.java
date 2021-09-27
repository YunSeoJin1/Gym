package com.green.biz.util;

public class Criteria {
	// 특정 페이지 조회를 위한 클래스
	private int pageNum; // 현재 페이지 번호
	private int rowsPerPage; // 페이지당 보여줄 게시글의 개수
	
	public Criteria() {
		// 기본 생성자 : 최초 게시판에 진입시 필요한 기본값
		this(1, 5);
	}

	public Criteria(int pageNum, int rowsPerPage) {
		this.pageNum = pageNum;
		this.rowsPerPage = rowsPerPage;
	}

	// 현재 페이지 번호 page : getter, setter
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if(pageNum <= 0) {
			this.pageNum = 1;

		} else {
			this.pageNum = pageNum;
		}    
	}


	// 페이지당 보여줄 게시글의 개수 perPageNum : getter, setter
	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		if(rowsPerPage <= 0 || rowsPerPage > 5) {
			this.rowsPerPage = 5;    
		} else {
			this.rowsPerPage = rowsPerPage;
		}
	}

	public int getPageStart() {
		// 특정 페이지의 범위를 정하는 구간, 현재 페이지의 게시글 시작 번호
		// 0 ~ 10 , 10 ~ 20 이런식으로
		return (pageNum-1) * rowsPerPage + 1;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", rowsPerPage=" + rowsPerPage + "]";
	}
}

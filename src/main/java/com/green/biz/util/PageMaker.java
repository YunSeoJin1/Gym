package com.green.biz.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private Criteria cri;
	private int totalCount; // 게시판 전체 데이터 개수
	private int cntPageNum = 5; // 게시판 화면에서 한번에 보여질 페이지 번호의 개수
	private int startPage; // 화면의 시작 번호
	private int endPage;  // 화면의 끝 번호
	private boolean prev; // 페이징 이전 버튼 활성화 여부
	private boolean next; // 페이징 다음 버튼 활성화 여부
	private int realEndPage;

	private void fieldInit() {
		// endPage = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 개수) * 화면에 보여질 페이지 번호의 개수
		endPage = (int)(Math.ceil(cri.getPageNum()/(double)cntPageNum) * cntPageNum);

		// startPage = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 개수) + 1
		startPage = (endPage - cntPageNum) + 1;
		
		// 마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의개수
		realEndPage = (int)(Math.ceil(totalCount / (double)cri.getRowsPerPage()));
		if(endPage > realEndPage) {
			endPage = realEndPage;
		}
		// 이전 버튼 생성 여부 = 시작 페이지 번호가 1과 같으면 false, 아니면 true
		prev = startPage == 1 ? false : true;    
		// 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 개수가 총 게시글의 수보다
		// 크거나 같으면 false, 아니면 true
		next = endPage * cri.getRowsPerPage() >= totalCount ? false : true;
	}
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		fieldInit();
	}
	public String makeQuery(int page) {
		UriComponents uriComp = UriComponentsBuilder.newInstance()
								.queryParam("pageNum", page)
								.queryParam("rowsPerPage", cri.getRowsPerPage())
								.build();
		
		return uriComp.toString();
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	public int getCntPageNum() {
		return cntPageNum;
	}

	public void setCntPageNum(int cntPageNum) {
		this.cntPageNum = cntPageNum;
	}
	
	
	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}
	@Override
	public String toString() {
		return "PageMaker [cri=" + cri + ", totalCount=" + totalCount + ", cntPageNum=" + cntPageNum + ", startPage="
				+ startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", realEndPage="
				+ realEndPage + "]";
	}

}

















package com.green.biz.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
   private Criteria cri;    // 현재 페이지번호, 페이지당 항목 수
   private int totalCount;   // 전체 게시글의 수
   private int startPage;   // 시작 페이지 번호
   private int endPage;   // 끝 페이지 번호
   private boolean prev;   // 이전 페이지 버튼 유무
   private boolean next;   // 다음 페이지 버튼 유무
   private int cntPageNum = 10;   // 화면 하단에 보이는 페이지 버튼의 수
   private int realEndPage;      // 전체 항목수에 따라서 실제 끝 페이지 번호 저장
   
   // 전체 게시글의 값에 따라 멤버 변수 설정을 초기화
   public void setTotalCount(int totalCount) {
      this.totalCount = totalCount;
      
      fieldInit();
      
   }
   
   public void fieldInit() {
      // 끝 페이지 계산
      endPage =(int)Math.ceil(cri.getPageNum() / (double)cntPageNum *cntPageNum);
   
      startPage = (endPage - cntPageNum) + 1;
      
      realEndPage = (int)Math.ceil(totalCount/ (double)cri.getRowsPerPage());
      
      if(endPage> realEndPage) {
         endPage = realEndPage;
      }
      
      prev = startPage==1 ? false : true;   // 시작 페이지가 1페이지 일경우 '이전'버튼이 필요 없음
      next = endPage * cri.getRowsPerPage() >= totalCount ? false : true;
      
      
   }
   /*
    * 화면에서 페이지 번호 클릭 할 때, 페이지 번호와 페이지당 항목 수를 이용해서 QueryString을 만들어주는 메소드
    * 출력 예 : ?pageNum=3&rowsPerPage=10
    */
   public String makeQuery(int page) {
      UriComponents uriComp = UriComponentsBuilder.newInstance()
                        .queryParam("pageNum", page)
                        .queryParam("rowsPerPage", cri.getRowsPerPage())
                        .build();
      
      return uriComp.toString();
   }
   
   
   
   
   // 멤버 변수 Getter, Setter
   
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

   public int getTotalCount() {
      return totalCount;
   }

   @Override
   public String toString() {
      return "PageMaker [cri=" + cri + ", totalCount=" + totalCount + ", startPage=" + startPage + ", endPage="
            + endPage + ", prev=" + prev + ", next=" + next + ", cntPageNum=" + cntPageNum + ", realEndPage="
            + realEndPage + "]";
   }
   
   
}


















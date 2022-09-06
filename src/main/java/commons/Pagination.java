package commons;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
	private int page; // 현재 페이지 번호
	private int total; // 전체 게시글 개수
	private int lastPage; // 마지막 페이지 번호
	private boolean isFirstCnt; // 첫번째 구간 여부
	private boolean isLastCnt; // 마지막 구간 여부
	private int pageCnt; // 구간별 페이지 개수
	private int prev; // 이전 페이지의 마지막 페이지
	private int next; // 다음 페이지의 첫번째 페이지
	private List<Integer> pages; // 구간별 페이지 번호
	private int limit;

	public Pagination(int page, int total, int pageCnt, int limit) {
		if (total < 1) {
			return;
		}
		
		this.total = total;
		this.limit = limit;
		this.pageCnt = pageCnt < 1 ? 10 : pageCnt;
		this.lastPage = (int) Math.ceil(total / (double) this.limit);
		page = page < 1 ? 1 : page;
		if (page > this.lastPage)
			page = this.lastPage;
		this.page = page;
		pages = new ArrayList<>();
		
		/** 페이지 구간 구하기 S */
		int cnt = (int) Math.ceil(this.page / (double) this.pageCnt) - 1;
		int lastCnt = (int) Math.ceil(this.lastPage / (double) this.pageCnt) - 1;
		
		if (cnt == 0)
			this.isFirstCnt = true;
		if (cnt == lastCnt)
			this.isLastCnt = true;
		
		/** 페이지 구간 구하기 E */
		
		/** 구간별 페이지 번호 S */
		int start = cnt * this.pageCnt + 1;
		for (int i = start; i < start + this.pageCnt; i++) {
			pages.add(i);

			
			 if(i == this.lastPage) { break; }
			 
		}
		/** 구간별 페이지 번호 E */

		/** 전 구간 마지막 페이지 S */
		if (!this.isFirstCnt) {
			prev = cnt * this.pageCnt;
		}
		/** 전 구간 마지막 페이지 E */

		/** 다음 구간 시작 페이지 S */
		if (!this.isLastCnt) {
			next = (cnt + 1) * this.pageCnt + 1;
		}
		/** 다음 구간 시작 페이지 E */

	}

	public Pagination(int page, int total) {
		this(page, total, 10, 20);
	}

	public int getPage() {
		return page;
	}

	public int getTotal() {
		return total;
	}

	public int getLastPage() {
		return lastPage;
	}

	public boolean isFirstCnt() {
		return isFirstCnt;
	}

	public boolean isLastCnt() {
		return isLastCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getPrev() {
		return prev;
	}

	public int getNext() {
		return next;
	}

	public List<Integer> getPages() {
		return pages;
	}

	@Override
	public String toString() {
		return "Pagination [page=" + page + ", total=" + total + ", lastPage=" + lastPage + ", isFirstCnt=" + isFirstCnt
				+ ", isLastCnt=" + isLastCnt + ", pageCnt=" + pageCnt + ", prev=" + prev + ", next=" + next + ", pages="
				+ pages + "]";
	}

}

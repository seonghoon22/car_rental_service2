package com.web.domain;
import javax.persistence.*;

@Entity
@Table(name="tb_reply")
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="idx")
	private int idx;
	
	@Column(name="boardIdx", nullable=false)
	private int boardIdx;
	
	@Column(name="reply_idx", nullable=false)
	private int replyIdx;
	
	@Column(name="contents")
	private String contents;
	

	public Reply() {
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int board_idx) {
		this.boardIdx = board_idx;
	}
	public int getReplyIdx() {
		return replyIdx;
	}
	public void setReplyIdx(int replyIdx) {
		this.replyIdx = replyIdx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public Reply(int idx, int boardIdx, int replyIdx, String contents) {
		super();
		this.idx = idx;
		this.boardIdx = boardIdx;
		this.replyIdx = replyIdx;
		this.contents = contents;
	}
	
}

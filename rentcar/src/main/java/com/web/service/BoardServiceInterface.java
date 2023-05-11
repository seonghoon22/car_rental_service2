package com.web.service;
import java.util.List;
import 	com.web.domain.*;

public interface BoardServiceInterface {
	public void addBoard(Board b);
	public List<Board> getBoard();
	public Board getBoardOne(int idx);
	public void addReply(Reply r);
	public List<Reply> getReply(int boardIdx);
	public void deleteBoard(int idx);
	}

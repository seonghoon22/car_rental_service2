package com.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.repository.*;
import com.web.domain.*;


@Service
public class BoardServiceImpl implements BoardServiceInterface{
	
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private ReplyRepository replyRepository;
	
	
	@Override
	public List<Board> getBoard(){
		List<Board> boardAll = boardRepository.findAll();
		return boardAll;
	};
	@Override
	public void addBoard(Board b) {
		 boardRepository.save(b);
	}
	@Override
	public Board getBoardOne(int idx) {
		Board board = boardRepository.findOne(idx);
		return board;
	}
	@Override
	public void addReply(Reply r) {
		replyRepository.save(r);
		
	}
	@Override
	public List<Reply> getReply(int boardIdx) {
		List<Reply> replyList = replyRepository.findByBoardIdx(boardIdx);
		return replyList;
	}
	
	@Override
	public void deleteBoard(int idx) {
		boardRepository.deleteBoardByIdx(idx);
	}
	
}

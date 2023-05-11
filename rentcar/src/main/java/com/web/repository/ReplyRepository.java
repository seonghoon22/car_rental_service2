package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{
	List<Reply> findByBoardIdx(int boardIdx);
}

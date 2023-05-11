package com.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{
	 void deleteBoardByIdx(int Idx);
}

package com.study.erum.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.erum.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

	private final SqlSessionTemplate sql;
	
	public int save(BoardDTO boardDTO) {
		return sql.insert("Board.save", boardDTO);
	}
	
	public List<BoardDTO> findAll(){
		return sql.selectList("Board.findAll");
	}

	public BoardDTO findById(Long id) {
		return sql.selectOne("Board.findById", id);
	}

	public void updateHits(Long id) {
		sql.update("Board.updateHits", id);
	}

	public void delete(Long id) {
		sql.delete("Board.delete", id);
	}

	public void update(BoardDTO boardDTO) {
		sql.update("Board.update", boardDTO);
		
	}
	
	
	
	
	

}

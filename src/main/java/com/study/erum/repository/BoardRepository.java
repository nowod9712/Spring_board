package com.study.erum.repository;

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

}

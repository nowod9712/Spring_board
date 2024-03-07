package com.study.erum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.erum.dto.BoardDTO;
import com.study.erum.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public int save(BoardDTO boardDTO) {
		return boardRepository.save(boardDTO);
	}
	
	public List<BoardDTO> findAll(){
		return boardRepository.findAll();
	}

	public BoardDTO findById(Long id) {
		return boardRepository.findById(id);
	}

	public void updateHits(Long id) {
		boardRepository.updateHits(id);
	}
	
	
}

package com.study.erum.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public void delete(Long id) {
		boardRepository.delete(id);
	}

	public void update(BoardDTO boardDTO) {
		boardRepository.update(boardDTO);
	}

	public List<BoardDTO> pageList(int page) {
		//pageList: 메소드명으로 페이지별로 게시글 목록을 반환.
		//int page: 페이지 번호를 나타내는 매개변수.
		int pageLimit = 3;
		/*
        	1페이지당 보여지는 글 갯수 3
	            1page => 0
	            2page => 3
	            3page => 6
		 */
		int pagingStart = (page -1) * pageLimit;
		//조회할 페이지의 시작 위치를 계산
		Map<String, Integer> pagingParams = new HashMap<String, Integer>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		//페이지 시작 위치와 페이지 리미트를 페이징 파라미터 맵에 저장
		List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
		
		return pagingList;
	}
	
	
}

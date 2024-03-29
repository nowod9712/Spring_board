package com.study.erum.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.erum.dto.BoardDTO;
import com.study.erum.dto.PageDTO;
import com.study.erum.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
    
	@GetMapping("/save")
    public String saveForm(){
        return "save";
    }
	
	//게시글 저장
	@PostMapping("/save")
	public String save(@ModelAttribute BoardDTO boardDTO) {
		int saveResult = boardService.save(boardDTO);
		if(saveResult > 0) {
			return "redirect:/board/paging";
		}else {
			return "save";
		}
	}
	
	//게시글 목록
	@GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        //findALL()메소드를 호출해 모든 게시글을 가져온뒤 boardDTOList에 저장.
        model.addAttribute("boardList", boardDTOList);
        //"boardList"라는 이름으로 boardDTOList를 모델에 추가합니다.     
        return "list";
        //"list"라는 jsp파일로 전달
	}
	
	//해당 게시글 상세정보
	@GetMapping	
	public String findById(@RequestParam("id") Long id,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Model model) {
		boardService.updateHits(id);
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		model.addAttribute("page", page);
		
		return "detail";
	}
	
	//게시글 삭제
	@GetMapping("/delete")	
	public String delete(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/";
	}
	
	//게시글 수정
	@GetMapping("/update")	
	public String updateForm(@RequestParam("id") Long id, Model model) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board",boardDTO);
		return "update";
		// return "redirect:/board?id="+boardDTO.getId():// 조회수 증가
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
		boardService.update(boardDTO);
		BoardDTO dto = boardService.findById(boardDTO.getId());
		model.addAttribute("board", dto);
		return "detail";
	}
	
	// /board/paging?page=2
	// 처음 페이지 요청은 1페이지를 보여줌.
	@GetMapping("/paging")
	public String paging(Model model,
						@RequestParam(value = "page", required = false, defaultValue = "1")
						int page) {
		System.out.println("page = " + page);
		// 해당 페이지에서 보여줄 글 목록
		List<BoardDTO> pagingList = boardService.pageList(page);
		System.out.println("pageList = " + pagingList);
		PageDTO pageDTO = boardService.pagingParam(page);
		model.addAttribute("boardList", pagingList);
		model.addAttribute("paging", pageDTO);
		
		return "paging";
	}
	
	
		
	
	
	
	
	
	
	
	
	
}
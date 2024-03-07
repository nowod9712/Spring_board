package com.study.erum.controller;
import lombok.RequiredArgsConstructor;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.erum.dto.BoardDTO;
import com.study.erum.service.BoardService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
    
	@GetMapping("/save")
    public String saveForm(){
        return "save";
    }
	
	@PostMapping("/save")
	public String save(@ModelAttribute BoardDTO boardDTO) {
		int saveResult = boardService.save(boardDTO);
		if(saveResult > 0) {
			return "redirect:/board/";
		}else {
			return "save";
		}
	}
	
	@GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        //findALL()메소드를 호출해 모든 게시글을 가져온뒤 boardDTOList에 저장.
        model.addAttribute("boardList", boardDTOList);
        //"boardList"라는 이름으로 boardDTOList를 모델에 추가합니다.     
        return "list";
        //"list"라는 jsp파일로 전달
	}
	
	@GetMapping	
	public String findById(@RequestParam("id") Long id, Model model) {
		boardService.updateHits(id);
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board",boardDTO);
		return "detail";
	}
	
	@GetMapping("/delete")	
	public String delete(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/";
	}
	
	
	
	
	
	
	
	
	
}
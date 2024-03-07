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
        model.addAttribute("boardList", boardDTOList);
        return "list";
	}
	
	@GetMapping	
	public String findById(@RequestParam("id") Long id, Model model) {
		boardService.updateHits(id);
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board",boardDTO);
		return "detail";
	}
	
	
	
	
	
	
	
	
	
}
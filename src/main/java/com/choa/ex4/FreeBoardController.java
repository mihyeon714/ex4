package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.choa.board.BoardDTO;
import com.choa.freeBoard.FreeBoardDTO;
import com.choa.freeBoard.FreeBoardServiceImpl;

@Controller
@RequestMapping(value="/freeBoard/**")
public class FreeBoardController {
	
	@Inject
	private FreeBoardServiceImpl freeBoardService ;
	
	
	@RequestMapping(value="freeBoardList")
	public String freeBoardList(@RequestParam(defaultValue="1")Integer curPage,Model model) throws Exception{
		List<BoardDTO> ar = freeBoardService.boardList(curPage);
		System.out.println("freeBoardService="+freeBoardService);
		model.addAttribute("list", ar);
		model.addAttribute("board", "freeBoard");
		return "board/boardList";
	}

	@RequestMapping(value="freeBoardView")
	public void freeBoardView() throws Exception{}
	
	@RequestMapping(value="freeBoardWrite",method=RequestMethod.GET)
	public void freeBoardWrite() throws Exception{}
	
	@RequestMapping(value="freeBoardWrite",method=RequestMethod.POST)
	public void freeBoardWrite2() throws Exception{}
	
	@RequestMapping(value="freeBoardUpdate",method=RequestMethod.GET)
	public void freeBoardUpdate() throws Exception{}
	
	@RequestMapping(value="freeBoardUpdate",method=RequestMethod.POST)
	public void freeBoardUpdate2() throws Exception{}
	
	@RequestMapping(value="freeBoardDelete")
	public void freeBoardDelete() throws Exception{}
	
}

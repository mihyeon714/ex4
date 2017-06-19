package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.freeBoard.FreeBoardDTO;
import com.choa.freeBoard.FreeBoardServiceImpl;
import com.choa.notice.NoticeDTO;

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
	public String freeBoardView(Integer num, Model model) throws Exception{
		if(num == null){
			num = 1;
		}
		FreeBoardDTO freeBoardDTO = (FreeBoardDTO)freeBoardService.boardView(num);
		model.addAttribute("dto", freeBoardDTO);
		model.addAttribute("board", "freeBoard");
		return "board/boardView";
	}
	
	@RequestMapping(value="freeBoardWrite",method=RequestMethod.GET)
	public String freeBoardWrite(Model model) throws Exception{
		model.addAttribute("board", "freeBoard");
		model.addAttribute("path", "Write");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="freeBoardWrite",method=RequestMethod.POST)
	public String freeBoardWrite2(BoardDTO freeBoardDTO, RedirectAttributes rd) throws Exception{
		int result = freeBoardService.boardWrite(freeBoardDTO);
		String message = "Write FAIL";
		if(result > 0){
			message = "Write SUCCESS";
		}

		rd.addFlashAttribute("message", message);
		return "redirect:/freeBoard/freeBoardList?curPage=1"; //여기는 서버단이기 때문에 /ex1 이 아니라 / 로 쳐주면 된다
	
	}
	
	@RequestMapping(value="freeBoardUpdate",method=RequestMethod.GET)
	public String freeBoardUpdate(Integer num, Model model) throws Exception{
		BoardDTO freeBoardDTO = freeBoardService.boardView(num); //DTO 하나를 받아오는것
		model.addAttribute("dto", freeBoardDTO);
		model.addAttribute("board", "freeBoard");
		model.addAttribute("path", "Update");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="freeBoardUpdate",method=RequestMethod.POST)
	public String freeBoardUpdate2(FreeBoardDTO freeBoardDTO, RedirectAttributes rd) throws Exception{
		int result = freeBoardService.boardUpdate(freeBoardDTO);
		String message = "Update FAIL";
		if(result > 0){
			message = "Update SUCCESS";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:/freeBoard/freeBoardList?curPage=1";
	}
	
	@RequestMapping(value="freeBoardDelete")
	public String freeBoardDelete(Integer num, RedirectAttributes rd) throws Exception{
		if(num == null){}
		int result = freeBoardService.boardDelete(num);
		String message = "Delete FAIL";
		if(result > 0){
			message = "Delete SUCCESS";
		}
		
		rd.addFlashAttribute("message", message);
		return "redirect:/freeBoard/freeBoardList?curPage=1";
	}
	
}

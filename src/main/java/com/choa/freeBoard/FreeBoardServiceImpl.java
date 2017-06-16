package com.choa.freeBoard;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.PageMaker;

@Service
public class FreeBoardServiceImpl implements BoardService{
	
	@Inject
	private FreeBoardDAOImpl freeBoardDAO;
	

	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		//int totalCount = freeBoardDAO.boardCount();
		PageMaker pageMaker = new PageMaker(curPage);
		pageMaker.getMakePage(30);

		return freeBoardDAO.boardList(pageMaker.getRowMaker("", ""));
	}


	@Override
	public BoardDTO boardView(int num) throws Exception {
		return freeBoardDAO.boardView(num);
	}


	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return freeBoardDAO.boardWrite(boardDTO);
	}


	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return freeBoardDAO.boardUpdate(boardDTO);
	}


	@Override
	public int boardDelete(int num) throws Exception {
		return freeBoardDAO.boardDelete(num);
	}


}

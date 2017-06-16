package com.choa.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.PageMaker;

//NoticeService noticeService = new NoticeService();
@Service
public class NoticeServiceImpl  implements BoardService{

	//@Inject
	@Autowired //타입으로 찾지만
	@Qualifier("notice")  //이름이 이거인 친구를 찾아요
	private NoticeDAOImpl noticeDAO;

	public void test(){
		System.out.println("noticeDAO= "+noticeDAO);
	}


	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		//curPage, Paging처리 해야함
		int totalCount = noticeDAO.boardCount();
		PageMaker pageMaker = new PageMaker(curPage);
		pageMaker.getMakePage(totalCount);

		return noticeDAO.boardList(pageMaker.getRowMaker("", ""));
	}


	@Override
	public BoardDTO boardView(int num) throws Exception {
		return noticeDAO.boardView(num);
	}


	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}


	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}


	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAO.boardDelete(num);
	}





}

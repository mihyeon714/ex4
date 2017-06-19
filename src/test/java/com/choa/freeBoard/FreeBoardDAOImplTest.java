package com.choa.freeBoard;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbstractTest;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

public class FreeBoardDAOImplTest extends MyAbstractTest {
	
	@Inject
	private FreeBoardDAOImpl dao; 
	//FreeBoardDAOImpl 에서 객체 생성하는 annotation이나 xml필요
	//지금은 @Repository 가 붙어있어서 객체가 생성됨

	@Test
	public void connectionTest() throws Exception {
		
		/*
		assertNotNull(dao);
		System.out.println("dao=" + dao);
		*/
		
		/*
		//view
		BoardDTO boardDTO = dao.boardView(4);
		assertNotNull(boardDTO);
		System.out.println("viewTest title= "+boardDTO.getTitle());
		*/
		
		/*
		//write
		FreeBoardDTO freeBoardDTO = new FreeBoardDTO();
		freeBoardDTO.setWriter("글쟁이");
		freeBoardDTO.setTitle("오늘의 시");
		freeBoardDTO.setContents("바람이 분다 그리고 날아간다");
		int result = dao.boardWrite(freeBoardDTO);
		assertEquals(1, result);
		System.out.println("writeResult="+result);
		*/
		
		/*
		//delete
		int  result = dao.boardDelete(1);
		assertEquals(1, result);
		System.out.println("deleteResult="+result);
		*/
		
		/*
		//update
		FreeBoardDTO freeBoardDTO = new FreeBoardDTO();
		freeBoardDTO.setWriter("글쟁이2");
		freeBoardDTO.setTitle("내일의 시");
		freeBoardDTO.setContents("바람이 분다 그리고 날아간다 그리고 다시 돌아온다");
		freeBoardDTO.setNum(3);
		int  result = dao.boardUpdate(freeBoardDTO);
		assertEquals(1, result);
		System.out.println("updateResult="+result);
		*/
		
		/*
		//list
		PageMaker pageMaker = new PageMaker(1);
		RowMaker rowMaker = pageMaker.getRowMaker("", "");
		List<BoardDTO> ar = dao.boardList(rowMaker);
		assertNotEquals(-1, ar.size()); //갯수가 -1이 아니면 됨
		System.out.println("ar 1 contents= "+ar.get(0).getContents());
		*/
		
		
		
	}

}

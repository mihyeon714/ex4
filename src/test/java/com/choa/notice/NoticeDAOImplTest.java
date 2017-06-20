package com.choa.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.w3c.dom.ls.LSInput;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyAbstractTest;
import com.choa.util.ListInfo;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

public class NoticeDAOImplTest extends MyAbstractTest{
	/*
	@Inject
	private SqlSession sqlSession; //xml에 설정해둠 
	
	//연결이 되는가 test 
	@Test
	public void connectionTest(){
		assertNotNull(sqlSession);
	}
	*/
	
	@Inject
	private NoticeDAOImpl dao;
	
	//DAO 테스트
	@Test
	public void connectionTest() throws Exception{
		
		
		/*
		BoardDTO boardDTO = dao.boardView(324);
		assertNotNull(boardDTO);
		System.out.println("title= "+boardDTO.getTitle());
		*/
		
		/*
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("hoho!");
		noticeDTO.setWriter("myeon");
		noticeDTO.setContents("hi everyone");
		*/
		
		//int result = dao.boardWrite(noticeDTO);
		//int result = dao.boardDelete(324);
		//noticeDTO.setNum(321);
		//int result = dao.boardUpdate(noticeDTO);
		
		
		//assertEquals(1, result);
		//System.out.println("result= "+result);
		
	/*
		PageMaker pageMaker = new PageMaker(1);
		RowMaker rowMaker = pageMaker.getRowMaker("writer", "hi");
		List<BoardDTO> ar =dao.boardList(rowMaker,"","");
		assertNotEquals(0, ar.size()); 
		for(int i=0;i<ar.size();i++){
			
			System.out.println("ar"+i+ "title= "+ar.get(i).getTitle());
		}*/
		
		/*
		int totalCount = dao.boardCount();
		assertNotEquals(-1, totalCount); 
		System.out.println("totlaCount = "+totalCount);
		*/
		
		
		ListInfo listInfo = new ListInfo();
		listInfo.setFind("HANI");
		listInfo.setSearch("writer");
		int count = dao.boardCount(listInfo);
		
		System.out.println("count= "+count);
		assertNotEquals(0, count);
		
		
	}
	

}

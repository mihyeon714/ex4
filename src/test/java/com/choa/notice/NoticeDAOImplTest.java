package com.choa.notice;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.choa.ex4.MyAbstractTest;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

public class NoticeDAOImplTest extends MyAbstractTest{

	@Inject
	private NoticeDAOImpl noticeDAO;
	
	@Test
	public void test() throws Exception {
		
		PageMaker pageMaker = new PageMaker(1);
		RowMaker rowMaker = pageMaker.getRowMaker("", "");
		
		List<NoticeDTO> ar = noticeDAO.noticeList(rowMaker);
		assertEquals(0, ar.size()); //이게 성공이면 하나도 안가져온것
		/*
		NoticeDTO noticeDTO = noticeDAO.noticeView(225);
		System.out.println("noticeDTO.title= "+noticeDTO.getTitle());
		Assert.assertNotNull(noticeDTO);
		*/
	}
	

	@Test
	public void test2() throws Exception{
		int result = noticeDAO.noticeDelete(225);
		assertEquals(1, result);
	}

}

package com.choa.freeBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.RowMaker;


@Repository
public class FreeBoardDAOImpl implements BoardDAO{
	
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "FreeBoardMapper."; //FreeBoardMapper.xml 의 id

	
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker, String search, String find) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"list", rowMaker); //Mapper에서는 그냥 제네릭으로 알려주고 여기서 list임을 알려줌
		/*
		Connection con = null;//dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		String sql = "select * from "
				+ "(select rownum R,F.* from "
				+ "(select * from freeboard order by ref desc, step asc) F)"
				+ " where R between ? and ?";

		st = con.prepareStatement(sql);
		st.setInt(1,rowMaker.getStartRow());
		st.setInt(2, rowMaker.getLastRow());
		rs = st.executeQuery();
		
		while(rs.next()){
			FreeBoardDTO freeBoardDTO = new FreeBoardDTO();
			freeBoardDTO.setNum(rs.getInt("num"));
			freeBoardDTO.setWriter(rs.getString("writer"));
			freeBoardDTO.setTitle(rs.getString("title"));
			freeBoardDTO.setContents(rs.getString("contents"));
			freeBoardDTO.setReg_date(rs.getDate("reg_date"));
			freeBoardDTO.setHit(rs.getInt("hit"));
			freeBoardDTO.setRef(rs.getInt("ref"));
			freeBoardDTO.setStep(rs.getInt("step"));
			freeBoardDTO.setDepth(rs.getInt("depth"));
			ar.add(freeBoardDTO);
		}
		
		DBConnect.disConnect(rs, st, con);
		
		return ar;
		*/
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"view", num);
		
		/*
		Connection con = null;//dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		FreeBoardDTO freeBoardDTO = null;
		String sql = "select * from freeboard where num=?";
		

		st = con.prepareStatement(sql);
		st.setInt(1, num);
		rs = st.executeQuery();
		
		if(rs.next()){
			freeBoardDTO = new FreeBoardDTO();
			freeBoardDTO.setNum(rs.getInt("num"));
			freeBoardDTO.setWriter(rs.getString("writer"));
			freeBoardDTO.setTitle(rs.getString("title"));
			freeBoardDTO.setContents(rs.getString("contents"));
			freeBoardDTO.setReg_date(rs.getDate("reg_date"));
			freeBoardDTO.setHit(rs.getInt("hit"));
			freeBoardDTO.setRef(rs.getInt("ref"));
			freeBoardDTO.setStep(rs.getInt("step"));
			freeBoardDTO.setDepth(rs.getInt("depth"));
		}
		
		//close 필수
		DBConnect.disConnect(rs, st, con);

		return freeBoardDTO;
		*/
		
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"write", boardDTO);
		/*Connection con = null;//dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;
		String sql = "insert into freeboard values(freeboard_seq.nextval,?,?,?,sysdate,0,freeboard_seq.currval,0,0)";
		
		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getWriter());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());
		result = st.executeUpdate();
		
		DBConnect.disConnect(st, con);
		
		return result;*/
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", boardDTO);
		/*
		Connection con = null;//dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;
		String sql = "update freeboard set title=?,contents=? where num=?";
		
		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNum());
		result = st.executeUpdate();
		
		DBConnect.disConnect(st, con);
		
		return result;
		*/
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", num);
		/*
		Connection con = null;//dataSource.getConnection();
		PreparedStatement st = null;
		int result = 0;
		String sql = "delete freeboard where num=?";
		
		st = con.prepareStatement(sql);
		st.setInt(1,num);
		result = st.executeUpdate();
		
		DBConnect.disConnect(st, con);

		return result;
		*/
	}

	@Override
	public int boardCount() throws Exception {
		Connection con = null;//dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "select nvl(count(num),0) from freeboard";
		//맨처음은 null이온다 그것을 0으로 처리해주자
		
		st = con.prepareStatement(sql);
		
		rs = st.executeQuery();
		rs.next();
		
		int result = rs.getInt(1);
		
		DBConnect.disConnect(rs, st, con);
		
		return result;
	}

	@Override
	public void boardHit(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}
	



}

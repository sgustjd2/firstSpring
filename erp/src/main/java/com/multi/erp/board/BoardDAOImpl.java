package com.multi.erp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	//MyBatis의 핵심클래스를 이용해서 sql문을 실행
	
	SqlSession sqlSessionTemplate;
	
	public BoardDAOImpl() {
		
	}
	
	@Autowired
	public BoardDAOImpl(SqlSession sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	@Override
	public int insert(BoardDTO board) {
		// TODO Auto-generated method stub
		// SqlSession의 insert메소드는isnert SQL명령문을 실행하기 위해 제공되는 메소드
		// insert (statement,파라미터 객체)
		// statement가 매퍼에 정의한 sql문을 구분하는 id명 - 네임스페이스명.id명
		return sqlSessionTemplate.insert("com.multi.erp.board.insert",board);
	}

	@Override
	public List<BoardDTO> boardList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("com.multi.erp.board.selectall");
	}

	@Override
	public BoardDTO read(String board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> search(String data) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("com.multi.erp.board.search",data);
	}

	@Override
	public List<BoardDTO> search(String tag, String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}

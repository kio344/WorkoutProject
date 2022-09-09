package models.admin.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class BoardConfigDao {

	private static BoardConfigDao instance = new BoardConfigDao();

	private BoardConfigDao() {
	}

	/**
	 * 게시판 설정 추가
	 * 
	 * @param boardConfig
	 * @return
	 */
	public boolean register(BoardConfigDto boardConfig) {
		SqlSession sqlSession = Connection.getSession();

		int affectedRows = sqlSession.insert("BoardConfigMap.register", boardConfig);

		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}
	
	/**
	 * 게시판 목록 불러오기
	 * @return
	 */
	public List<BoardConfigDto> gets() {
		SqlSession sqlSession = Connection.getSession();

		List<BoardConfigDto> boards = sqlSession.selectList("BoardConfigMap.list");

		
		sqlSession.close();
		return boards;
	}
	
	/**
	 * 게시판 설정 수정
	 * @param boardConfig
	 * @return
	 */
	public boolean update(BoardConfigDto boardConfig) {
		SqlSession sqlSession = Connection.getSession();
		
		int affectedRows = sqlSession.update("BoardConfigMap.update", boardConfig);
		
		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}
	
	/**
	 * 게시판 삭제
	 * @param boardConfig
	 * @return
	 */
	public boolean delete(BoardConfigDto boardConfig) {
		SqlSession sqlSession = Connection.getSession();
		
		int affectedRows = sqlSession.delete("BoardConfigMap.delete", boardConfig);
		
		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}
	
	public BoardConfigDto get(BoardConfigDto boardConfig) {
		SqlSession session=Connection.getSession();
		BoardConfigDto dto= session.selectOne("BoardConfigMap.get",boardConfig);
		
		session.close();
		
		return dto;
	}

	public static BoardConfigDao getInstance() {
		if (instance == null) {
			instance = new BoardConfigDao();
		}
		return instance;
	}

}

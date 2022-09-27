package models.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class BoardDao {
	private static BoardDao instance = new BoardDao();

	private BoardDao() {
		// TODO Auto-generated constructor stub
	}

	public BoardDto insert(BoardDto board) {
		SqlSession session = Connection.getSession();

		session.insert("BoardMapper.insert", board);

		session.commit();
		session.close();

		return board;
	}

	/**
	 * 특정 게시판(boardId) 모든 게시글 갖고오기
	 * 
	 * @author 5563a
	 * @param board
	 * @return
	 */
	public List<BoardDto> gets(BoardDto board) {
		SqlSession session = Connection.getSession();

		List<BoardDto> boards = session.selectList("BoardMapper.gets", board);

		session.close();

		return boards;

	}

	/**
	 * 게시판 글 가져오기 gid or id 값 채워주기
	 * 
	 * @author 5563a
	 * @param boardDto
	 * @return
	 */
	public BoardDto get(BoardDto boardDto) {
		SqlSession session = Connection.getSession();

		BoardDto dto = session.selectOne("BoardMapper.get", boardDto);

		session.close();

		return dto;

	}

	/**
	 * 게시글 업데이트
	 * 
	 * @author 5563a
	 * @param board
	 */
	public void update(BoardDto board) {

		SqlSession session = Connection.getSession();

		session.insert("BoardMapper.update", board);

		session.commit();
		session.close();

	}

	public void delete(BoardDto board) {
		SqlSession session = Connection.getSession();

		session.delete("BoardMapper.delete", board);

		session.commit();
		session.close();

	}

	public int getsCount(BoardDto board) {
		SqlSession session = Connection.getSession();

		int result=session.selectOne("BoardMapper.getsCount",board);
		session.close();
		
		return result;

	}
	
	public List<BoardDto> getpage(BoardLimitDto board) {
		SqlSession session = Connection.getSession();

		List<BoardDto> result=session.selectList("BoardMapper.getpage",board);
		session.close();
		
		return result;
		
	}

	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
}

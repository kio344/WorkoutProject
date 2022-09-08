package models.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class CommentDao {

	private static CommentDao instance = new CommentDao();

	private CommentDao() {
	}

	/**
	 * 댓글 작성
	 * 
	 * @param dto
	 */
	public void register(CommentDto dto) {
		SqlSession sqlSession = Connection.getSession();

		sqlSession.insert("CommentMapper.register", dto);

		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 댓글 수정
	 * @param dto
	 * @return
	 */
	public boolean update(CommentDto dto) {
		SqlSession sqlSession = Connection.getSession();

		int affectedRows = sqlSession.update("CommentMapper.update", dto);

		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}
	
	/**
	 * 댓글 삭제
	 * @param dto
	 * @return
	 */
	public boolean delete(CommentDto dto) {
		SqlSession sqlSession = Connection.getSession();

		int affectedRows = sqlSession.delete("CommentMapper.delete", dto);

		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}
	
	/**
	 * 해당 게시글 댓글 목록 불로오기
	 * @param dto
	 * @return
	 */
	public List<CommentDto> gets(CommentDto dto) {
		SqlSession sqlSession = Connection.getSession();
		
		List<CommentDto> comments = sqlSession.selectList("CommentMapper.gets", dto);
		
		sqlSession.close();
		return comments;
	}

	public static CommentDao getInstance() {
		if (instance == null) {
			instance = new CommentDao();
		}
		return instance;
	}

}

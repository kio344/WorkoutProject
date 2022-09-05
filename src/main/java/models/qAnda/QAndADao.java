package models.qAnda;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class QAndADao {

	private static QAndADao instance = new QAndADao();

	private QAndADao() {
	}

	/**
	 * Q&A 등록
	 * 
	 * @param dto
	 * @return
	 */
	public boolean register(QAndADto dto) {
		SqlSession sqlSession = Connection.getSession();

		int affectedRows = sqlSession.insert("QAndAMapper.register", dto);

		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}
	
	public boolean registerAdmin(QAndADto dto) {
		SqlSession sqlSession = Connection.getSession();

		int affectedRows = sqlSession.insert("QAndAMapper.registerAdmin", dto);

		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}

	/**
	 * Q&A 답변 등록
	 * 
	 * @param dto
	 * @return
	 */
	public boolean update(QAndADto dto) {
		SqlSession sqlSession = Connection.getSession();

		int affectedRows = sqlSession.update("QAndAMapper.update", dto);

		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}

	/**
	 * Q&A 게시글 단일 조회
	 * 
	 * @param id
	 * @return
	 */
	public QAndADto get(int id) {
		SqlSession sqlSession = Connection.getSession();

		QAndADto dto = sqlSession.selectOne("QAndAMapper.get", id);

		sqlSession.close();
		return dto;
	}

	/**
	 * Q&A 게시글 목록 조회
	 * 
	 * @return
	 */
	public List<QAndADto> gets(int page, int limit) {
		SqlSession sqlSession = Connection.getSession();
		
		QAndAListDto param = new QAndAListDto();
		
		int offset = (page - 1) * limit;
		
		param.setOffset(offset);
		param.setLimit(limit);

		List<QAndADto> dtos = sqlSession.selectList("QAndAMapper.gets", param);

		sqlSession.close();
		return dtos;
	}

	public int total() {
		SqlSession sqlSession = Connection.getSession();

		int total = sqlSession.selectOne("QAndAMapper.count");

		sqlSession.close();
		return total;
	}
	
	public boolean delete(QAndADto dto) {
		SqlSession sqlSession = Connection.getSession();
		
		int affectedRows = sqlSession.delete("QAndAMapper.delete", dto);
		
		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}

	public static QAndADao getInstance() {
		if (instance == null) {
			instance = new QAndADao();
		}
		return instance;
	}

}

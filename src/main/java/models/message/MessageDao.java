package models.message;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.admin.MessageDto;
import mybatis.Connection;

public class MessageDao {
	private static MessageDao instance = new MessageDao();

	private MessageDao() {
		// TODO Auto-generated constructor stub
	}

	public MessageDto sendMessage(MessageDto message) {
		SqlSession session = Connection.getSession();

		int changerow = session.insert("MessageMapper.sendMessage", message);

		if (changerow == 0) {
			throw new RuntimeException("메세지전송에 실패했습니다.");

		}

		session.commit();
		session.close();

		return message;
	}

	/**
	 * 사용자별 안읽은 읽은 메세지 수 확인 recipient > 받는사람 read > true 읽음 false 안읽음
	 * 
	 * @param message
	 * @return
	 */
	public int getsUserMsgC(MessageDto message) {
		SqlSession session = Connection.getSession();

		int count = session.selectOne("MessageMapper.getsUserMsgC", message);

		session.close();

		return count;
	}

	/**
	 * 사용자 메세지 모두 가져옴 recipient(수신자),see(읽음 여부 ) 채워주기 see 값 null 시 모든 메세지 가져옴
	 * 
	 * @param message
	 * @return
	 */
	public List<MessageDto> getsUserMsg(MessageDto message) {
		SqlSession session = Connection.getSession();

		List<MessageDto> list = session.selectList("MessageMapper.getsUserMsg", message);

		session.close();

		return list;
		
	}
	
	/**
	 * 사용자 메세지 개수 가져옴 recipient(수신자),see(읽음 여부 ) 채워주기 see 값 null 시 모든 메세지 개수
	 * 
	 * @param message
	 * @return
	 */
	public int getsUserMsgCount(MessageDto message) {
		SqlSession session = Connection.getSession();

		int count = session.selectOne("MessageMapper.getsUserMsgCount", message);

		session.close();

		return count;
		
	}
	
	
	public List<MessageDto> getsUserMsg_limit(MessageLimitDto message) {
		SqlSession session = Connection.getSession();

		List<MessageDto> list = session.selectList("MessageMapper.getsUserMsg_limit", message);

		session.close();

		return list;
	}
	

	/**
	 * 메세지 읽음 안읽음 처리 메세지 바꿀 메세지 num 바꿀 상태 see ("true","false")
	 * 
	 * @author 5563a
	 * @param message
	 */
	public void update(MessageDto message) {
		SqlSession session = Connection.getSession();

		session.update("MessageMapper.update", message);

		session.commit();
		session.close();
	}

	public void delete(MessageDto message) {
		SqlSession session = Connection.getSession();
		
		session.update("MessageMapper.delete", message);

		session.commit();
		session.close();
	}

	public static void main(String[] args) {
		MessageDao dao = MessageDao.getInstance();
		MessageDto dto = new MessageDto();
		dto.setRecipient("llll5563");
		List<MessageDto> list = dao.getsUserMsg(dto);
		System.out.println(list);
	}

	public static MessageDao getInstance() {
		if (instance == null) {
			instance = new MessageDao();

		}

		return instance;
	}
}

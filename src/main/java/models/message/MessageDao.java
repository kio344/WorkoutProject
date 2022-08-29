package models.message;

import org.apache.ibatis.session.SqlSession;

import models.admin.MessageDto;
import mybatis.Connection;

public class MessageDao {
	private static MessageDao instance=new MessageDao();
	private MessageDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MessageDto sendMessage(MessageDto message) {
		SqlSession session=Connection.getSession();
		
		int changerow = session.insert("MessageMapper.sendMessage",message);
		
		if (changerow==0) {
			throw new RuntimeException("메세지전송에 실패했습니다.");
			
		}
		
		session.commit();
		session.close();
		
		return message;
	}
	
	/**
	 * 사용자별 안읽은 읽은 메세지 수 확인
	 * recipient > 받는사람
	 * read > true 읽음 false 안읽음
	 * @param message
	 * @return
	 */
	public int getsUserMsgC(MessageDto message) {
		SqlSession session=Connection.getSession();
		
		int count=session.selectOne("MessageMapper.getsUserMsgC",message);
		
		session.close();
		
		return count;
	}
	
	public static MessageDao getInstance() {
		if (instance==null) {
			instance=new MessageDao();
			
		}
		
		return instance;
	}
}

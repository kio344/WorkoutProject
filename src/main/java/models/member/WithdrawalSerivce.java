package models.member;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;
import exception.BadException;
import mybatis.Connection;

public class WithdrawalSerivce {

	/**
	 * 삭제
	 * @param dto
	 */
	public void delete(UserDto dto) {
		
		SqlSession sqlsession = Connection.getSession();
		
		int deleteUser = sqlsession.delete("userInfoMapper.delete", dto);
		
		if(deleteUser == 0) {
			throw new BadException("삭제 실패하였습니다.");
		}
	
		sqlsession.commit();
		sqlsession.close();
		
	}
	
}

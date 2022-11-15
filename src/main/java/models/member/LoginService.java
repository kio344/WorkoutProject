package models.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.bcrypt.BCrypt;

import dto.UserDto;
import exception.BadException;
import mybatis.Connection;

public class LoginService {

	Cookie limitCookie;
	Cookie[] cookies;

	/**
	 * 로그인 처리 아이디, 비밀번호 값 입력 받고 DB에 유저 정보 검색 후 아이디와 비밀번호 검증
	 * 
	 * @throws IOException
	 * 
	 */
	public UserDto search(HttpServletRequest req, HttpServletResponse resp) {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		SqlSession sqlsession = Connection.getSession();

		UserDto login_user = sqlsession.selectOne("userInfoMapper.user", id);
		if (login_user == null) {
			throw new BadException("없는 아이디입니다. 다시 시도해주세요");
		}

		if (!BCrypt.checkpw(pw, login_user.getPassword())) {
			throw new BadException("비밀번호가 일치하지 않습니다.");
		}

		return login_user;
	}

	/**
	 * 로그인 제한을 나타내는 쿠키 생성
	 * @param req
	 * @param resp
	 * @param tryCount 로그인 실패 횟수
	 */
	public void loginLimit(HttpServletRequest req, HttpServletResponse resp, int tryCount) {

		// 쿠키 지정 name, value
		limitCookie = new Cookie("loginLimit", "limit");
		// 쿠키의 유효시간 설정
		limitCookie.setMaxAge(60 * 5); // 5분
		// 쿠키 추가
		resp.addCookie(limitCookie);

	}

	/**
	 * 생성된 쿠키들 전부 읽어오기
	 * 로그인 제한 쿠키가 있다면 tryCount = 0 으로 리셋
	 * 로그인이 5번째 틀리면 loginLimit 메서드 실행
	 * @param req
	 * @param resp
	 * @param tryCount
	 */
	public void makeCookie(HttpServletRequest req, HttpServletResponse resp, int tryCount) {
		cookies = req.getCookies();

		if (cookies.length >= 1) {
			for (int i = 0; cookies.length > i; i++) {

				String cookie = cookies[i].getName();

				if (cookie.equals("loginLimit")) {
					tryCount = 0;
					return;
				}

				if (tryCount >= 4) {
					loginLimit(req, resp, tryCount);
				}
			}
		}
	}
	
	/**
	 * 로그인 제한 쿠키가 있는지 체크
	 * 있다면 true
	 * 없으면 false
	 */
	public boolean checkLimit(HttpServletRequest req) {
		cookies = req.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("loginLimit")) {
				return true;
			}
		}
		return false;
	}
}

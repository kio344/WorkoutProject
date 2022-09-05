package models.qAnda;

import javax.servlet.http.HttpServletRequest;

import dto.UserDto;
import exception.BadException;

public class QAndAAdminViewService {

	public void view(HttpServletRequest request) {
		UserDto user = (UserDto) request.getSession().getAttribute("member");

		QAndADao dao = QAndADao.getInstance();
		QAndADto dto = dao.get(Integer.parseInt(request.getParameter("id")));
		if (user == null) {
			if (dto.getFix() != 1) {
				throw new BadException("로그인 후 이용해주세요.");
			}
		} else {
			if (!user.getId().equals(dto.getMemId())) {
				if (dto.getFix() != 1) {
					if (!user.getUserType().equals("admin")) {
						throw new BadException("본인 글이 아닙니다.");
					}
				}
			}
		}
		request.setAttribute("question", dto);
	}

}

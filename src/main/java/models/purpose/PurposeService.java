package models.purpose;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.UserDto;
import exception.BadException;
import models.member.UserDao;

public class PurposeService {
	
	public void bmi(HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserDto user = (UserDto)session.getAttribute("member");
		String[] strs = { "저체중", "정상", "과체중", "비만", "고도비만" };
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		String age = req.getParameter("age");
		
		String sex = req.getParameter("sex");
		BmiDto bmiInfo = new BmiDto();
		
		if(height == null || height.trim().isEmpty()) {
			throw new BadException("키를 입력해주세요.");
		}
		if(weight == null || weight.trim().isEmpty()) {
			throw new BadException("몸무게를 입력해주세요.");
		}
		if(age == null || age.trim().isEmpty()) {
			throw new BadException("나이를 입력해주세요.");
		}
		if(sex == null || sex.trim().isEmpty()) {
			throw new BadException("성별을 골라주세요.");
		}
		
		double he = Double.parseDouble(height);
		double we = Double.parseDouble(weight);
		double ageRe = Double.parseDouble(age);
		double heRe = he / 100;
		
		double bmi = (we / (heRe * heRe));
		String bmiStr = String.format("%.2f", bmi);
		bmiInfo.setBmi(bmiStr);
		
		if(bmi >= 30) {
			bmiInfo.setBmiWe(strs[4]);
		} else if(bmi >= 25){
			bmiInfo.setBmiWe(strs[3]);
		} else if(bmi >= 23) {
			bmiInfo.setBmiWe(strs[2]);
		} else if(bmi >= 18.5) {
			bmiInfo.setBmiWe(strs[1]);
		} else {
			bmiInfo.setBmiWe(strs[0]);
		}
		if(sex.equals("man")) {
			
			double base = 66.47 + (13.75 * we) + (5 * he) - (6.76 * ageRe);
			String baseStr = String.format("%.1f", base);
			bmiInfo.setBase(baseStr);
			
		} else if(sex.equals("woman")) {
			double base = 665.1 + (9.56 * we) + (1.85 * he) - (4.68 * ageRe);
			String baseStr = String.format("%.1f", base);
			bmiInfo.setBase(baseStr);
		}
		
		user.setHeight(he);
		user.setAge(ageRe);
		user.setWeight(we);
		user.setSex(sex);
		
		UserDao dao = UserDao.getInstance();
		
		boolean result = dao.bmiUpdate(user);
		if(!result) {
			throw new BadException("오류가 발생하였습니다. 다시 시도해주세요.");
		}
		
		session.setAttribute("bmiInfo", bmiInfo);
		}

}

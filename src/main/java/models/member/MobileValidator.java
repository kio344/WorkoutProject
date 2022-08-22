package models.member;

public interface MobileValidator {

	
	default boolean checkMobile(String mobile) {
		mobile = mobile.replaceAll("[^0-9]", "");
		String pattern = "01[012]\\d{3,4}\\d{4}";
		
		boolean result = mobile.matches(pattern);
		return result;
		
	}
}

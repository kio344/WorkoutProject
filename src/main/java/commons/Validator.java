package commons;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;

public interface Validator {

	/**
	 *  
	 * @param request
	 * @param map
	 */
	
	default void check (HttpServletRequest request, Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String value = request.getParameter(entry.getKey());
			String msg = entry.getValue();
			if(value == null || value.isBlank()) {
				throw new BadException(msg);
			}
		}
	}
	
}

package css_js;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class AddCss_Js {
	
	public List<String> addCss() {
		List<String> list = new ArrayList<>();
		String a = "/Users/minho/Desktop/JSP_KMH/web/WorkOutProject/src/main/webapp/static/css/";
		File file = new File(a);
		String [] fileList = file.list();
		
		for(int i = 0; i < fileList.length; i ++) {
			list.add(fileList[i].substring(0, fileList[i].length()-4));
		}
		
		return list;
	}
	
	public List<String> addJs() {
		
		List<String> list = new ArrayList<>();
		String a = "/Users/minho/Desktop/JSP_KMH/web/WorkOutProject/src/main/webapp/static/js/";
		File file = new File(a);
		String [] fileList = file.list();
		
		for(int i = 0; i < fileList.length; i ++) {
			list.add(fileList[i].substring(0, fileList[i].length()-3));
		}
		
		return list;
		
	}
	


}

package models.seller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import dto.UserDto;

public class AddProductService {
	public void addProduct(HttpServletRequest req) throws Exception {
		FileUpload upload = new FileUpload(new DiskFileItemFactory());
		Map<String, String> paraMap = new HashMap<>();

		List<FileItem> list = upload.parseRequest(req);
		FileItem productImage = null;
		for (FileItem file : list) {
			if (file.isFormField()) { // 일반 값
//				System.out.println(new String(file.getFieldName().getBytes("8859_1"),"UTF-8") + ":" + new String(file.getString().getBytes("8859_1"),"UTF-8"));
				paraMap.put(new String(file.getFieldName().getBytes("8859_1"),"UTF-8"),new String(file.getString().getBytes("8859_1"),"UTF-8"));
				if (file.getString() == null || file.getString().isBlank()) {
					throw new RuntimeException("비어있는 값을 채워주세요");
				}
			} else { // 이미지 파일

				if (file.getContentType().indexOf("image") == -1) {
					throw new RuntimeException("이미지 파일이 아니거나 선택하지 않았습니다.");
				}

				productImage = file;

			}
		}

		/**
		 * 값받아오기
		 */
		HttpSession session = req.getSession();
		UserDto user = (UserDto) session.getAttribute("member");
		if (user == null) {
			
			throw new RuntimeException("로그인 후 사용해 주세요");
		}

		String serialnum = paraMap.get("serialnum");
		String name = paraMap.get("name");
		String price = paraMap.get("price");
		String kategorie = paraMap.get("kategorie");
		String company = paraMap.get("company");
		System.out.println(paraMap.get(productImage) == null);
		String img = productImage.getName();

		ProductDto product = new ProductDto();
		product.setSerialnum(serialnum);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setKategorie(kategorie);
		product.setCompany(company);
		product.setImg(img);
		product.setSeller(user.getId());
		SellerDao dao = SellerDao.getInstance();

		ProductDto end = dao.register(product);

		StringBuilder buildPath = new StringBuilder();
		buildPath.append(req.getServletContext().getRealPath("/productImage"));
		buildPath.append(File.separator);
		buildPath.append(end.getAbnum() % 10);
		buildPath.append(File.separator);

		System.out.println(buildPath.toString());

		File uploadpath = new File(buildPath.toString());
		if (uploadpath.exists()) {
			uploadpath.mkdirs();
		}
		
		buildPath.append(end.getAbnum());
		
		productImage.write(new File(buildPath.toString()));
		
	}
}

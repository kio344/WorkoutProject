package models.seller;

import javax.servlet.http.HttpServletRequest;
import static jmsUtil.Utils.*;

public class AddProductService {
	public void addProduct(HttpServletRequest req) {
		/**
		 * 값받아오기
		 */
		String serialnum =req.getParameter("serialnum");
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String kategorie=req.getParameter("kategorie");
		String company=req.getParameter("company");
		String img=req.getParameter("img");
		
		ProductDto product=new ProductDto();
		product.setSerialnum(serialnum);
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setKategorie(kategorie);
		product.setCompany(company);
		product.setImg(img);
		
		SellerDao dao=SellerDao.getInstance();
		
		dao.register(product);
		
		
	}
}

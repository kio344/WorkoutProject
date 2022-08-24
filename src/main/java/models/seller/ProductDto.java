package models.seller;

public class ProductDto {
	private int abnum;
	private String serialnum;
	private String name;
	private int price;
	private String kategorie;
	private String company;
	private String img;
	
	public ProductDto() {}

	public int getAbnum() {
		return abnum;
	}

	public void setAbnum(int abnum) {
		this.abnum = abnum;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ProductDto [abnum=" + abnum + ", serialnum=" + serialnum + ", name=" + name + ", price=" + price
				+ ", kategorie=" + kategorie + ", company=" + company + ", img=" + img + "]";
	}
	
	
	
	
}

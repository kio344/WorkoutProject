package models.seller;

import java.time.LocalDateTime;

public class ProductDto {
	private int abnum;
	private String seller;
	private String serialnum;
	private String name;
	private int price;
	private String kategorie;
	private String company;
	private String img;
	private String status;
	private LocalDateTime regDt;
	private LocalDateTime modDt;
	
	public ProductDto() {}

	public int getAbnum() {
		return abnum;
	}

	public void setAbnum(int abnum) {
		this.abnum = abnum;
	}
	
	

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
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
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public LocalDateTime getModDt() {
		return modDt;
	}

	public void setModDt(LocalDateTime modDt) {
		this.modDt = modDt;
	}

	@Override
	public String toString() {
		return "ProductDto [abnum=" + abnum + ", seller=" + seller + ", serialnum=" + serialnum + ", name=" + name
				+ ", price=" + price + ", kategorie=" + kategorie + ", company=" + company + ", img=" + img
				+ ", status=" + status + ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}
	
	
	
	
}

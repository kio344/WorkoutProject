package models.seller;

import java.time.LocalDateTime;

public class ProductDto {

	private int abnum;
	private String seller;
	private String serialnum;
	private String name; 
	private String writer;
	private int price;
	private String kategorie; 
	private String publisher; 
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
				+ ", writer=" + writer + ", price=" + price + ", kategorie=" + kategorie + ", publisher=" + publisher
				+ ", img=" + img + ", status=" + status + ", regDt=" + regDt + ", modDt=" + modDt + "]\n";
	}


	
	
	
}

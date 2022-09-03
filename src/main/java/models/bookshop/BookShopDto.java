package models.bookshop;

import java.time.LocalDateTime;

public class BookShopDto {
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

	public BookShopDto() {}

	public BookShopDto(int abnum, String seller, String serialnum, String name, String writer, int price, String kategorie,
			String publisher, String img, String status, LocalDateTime regDt, LocalDateTime modDt) {
		this.abnum = abnum;
		this.seller = seller;
		this.serialnum = serialnum;
		this.name = name;
		this.writer = writer;
		this.price = price;
		this.kategorie = kategorie;
		this.publisher = publisher;
		this.img = img;
		this.status = status;
		this.regDt = regDt;
		this.modDt = modDt;
	}

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

	public String isStatus() {
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
		return "ShoppingDto [abnum=" + abnum + ", seller=" + seller + ", serialnum=" + serialnum + ", name=" + name
				+ ", writer=" + writer + ", price=" + price + ", kategorie=" + kategorie + ", publisher=" + publisher
				+ ", img=" + img + ", status=" + status + ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}

}

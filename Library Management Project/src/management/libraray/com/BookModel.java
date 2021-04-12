package management.libraray.com;

public class BookModel {
	
	String name;
	String price;
	String author;
	String category;
	String image;
	String date;
	
	
	public BookModel(String name,  String author,String price, String category, String date,String image) {
	
		this.name = name;
		this.price = price;
		this.author = author;
		this.category = category;
		this.date = date;
		this.image=image;
	}
	public BookModel() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}

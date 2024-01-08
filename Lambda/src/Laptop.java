
public class Laptop {
	String brand;
	double price;
	int quality;
	public Laptop(){
		this.brand="Nokia";
		this.price = 10;
		this.quality=1000;
	}
	public Laptop(String brand, double price, int quality) {
		super();
		this.brand = brand;
		this.price = price;
		this.quality = quality;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public String toString() {
		return "This is a $"+this.price +" "+ this.brand + " laptop rated " + this.quality+"/10";
	}
}

package Shop;

public class Product {
	public enum productType{
		KG, PIECE
	}
	private productType type;
	private String name;
	private int price;
	private int quantity;
	
	public Product(productType type, String name, int price, int quantity) {
		this.type = type;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public productType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return '\n'+name + " - " + price + " lv. - nalichni - " + quantity + " "+type;
	}
	
	
	
	

}

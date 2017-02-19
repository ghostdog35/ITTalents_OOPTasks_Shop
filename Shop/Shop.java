package Shop;

import java.util.ArrayList;

import Shop.Product.productType;

public class Shop {
	
	private String name;
	private String address;
	private int money;
	private ArrayList<Product> products;
	public Shop(String name, String address, int money) {
		this.name = name;
		this.address = address;
		this.money = money;
		this.products= new ArrayList<>();
		this.addProduct(new Product(productType.KG, "Meso", 8, 50));
		this.addProduct(new Product(productType.KG, "Sirene", 6, 50));
		this.addProduct(new Product(productType.KG, "Kashkaval", 10, 50));
		this.addProduct(new Product(productType.KG, "Salam",15, 50));
		this.addProduct(new Product(productType.KG, "Lukanka",20, 50));
		this.addProduct(new Product(productType.KG, "Bahur", 4, 50));
		this.addProduct(new Product(productType.PIECE, "Bira", 1, 150));
		this.addProduct(new Product(productType.PIECE, "Vino", 10, 150));
		this.addProduct(new Product(productType.PIECE, "Rakiq", 8, 150));
		this.addProduct(new Product(productType.PIECE, "Vodka", 7, 150));
		this.addProduct(new Product(productType.PIECE, "Whiskey", 25, 150));
		this.addProduct(new Product(productType.PIECE, "Voda", 1, 150));
		this.addProduct(new Product(productType.PIECE, "Coca Cola", 1, 150));
	}
	
	public Product getProduct(String name, int qty) {
		for (Product product : products) {
			if(product.getName().equals(name)){
				if(product.getQuantity()>qty){
					product.setQuantity(product.getQuantity()-qty);
					return new Product(product.getType(), name, product.getPrice(), qty);
				}
				else{
					System.out.println("We have only "+product.getQuantity()+" "+product.getType()+",S from "+product.getName());
					Product temp = new Product(product.getType(), product.getName(), product.getPrice(), product.getQuantity());
					this.products.remove(product);
					return temp;
				}
			}
		}
		System.out.println("I'm sorry we don't have the product that you want.");
		return null;
	}
	public void recieveMoney(int price) {
		this.money+=price;
		
	}
	public void addProduct(Product product) {
		if(product!=null){
			this.products.add(product);
		}
		
	}
	@Override
	public String toString() {
		return  name + '\n'+"Address - " + address +'\n'+ "Money in cash - " + money;
	}

	public void showInfo(){
		System.out.println(this);
		System.out.println("-----Products------"+'\n'+this.products);
	}
	
	

}

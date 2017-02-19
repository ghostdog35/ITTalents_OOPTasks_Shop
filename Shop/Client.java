package Shop;

import java.util.ArrayList;

public class Client {
	
	private Shop shop;
	private int money;
	private int maxCountOfProducts;
	private ArrayList<Product> kolichka;
	public Client(Shop shop, int money, int maxCountOfProducts) {
		this.shop = shop;
		this.money = money;
		this.maxCountOfProducts = maxCountOfProducts;
		this.kolichka = new ArrayList<>();
	}
	
	public boolean addProduct(Product p){
		if(this.maxCountOfProducts>this.kolichka.size() && p!=null){
			this.kolichka.add(p);
			return true;
		}
		return false;
	}
	
	public boolean byeProduct(String name, int qty){
		Product temp = this.shop.getProduct(name, qty);
		if(temp!=null){
			this.addProduct(temp);
			return true;
		}
		else{
			return false;
		}
	}
	public boolean removeProduct(Product p){
		if(p!=null){
			return kolichka.remove(p);
		}
		return false;
	}
	
	public void payProducts(){
		for (Product product : kolichka) {
			int price = product.getPrice()*product.getQuantity();
			if(price<this.money){
				System.out.println("You just bough "+product.getQuantity()+" "+product.getType()+"'S "+product.getName()+"'s .");
				this.money-=price;
				this.shop.recieveMoney(price);
			}
			else{
				System.out.println("You don't have enough money to buy "+product.getQuantity()+" "+product.getType()+"'S "+product.getName()+"'s .");
				this.shop.addProduct(product);
				this.removeProduct(product);
			}
		}
	}
	
	

}

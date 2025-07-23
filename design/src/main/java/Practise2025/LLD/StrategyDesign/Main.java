package Practise2025.LLD.StrategyDesign;

public class Main {
	
	public static void main(String[] args) {
		PricingStrategy ps = new Strategy2();
		Product product = new Product("Shirt", 20, ps);
		System.out.println(product.getPrice());
	}
}

interface PricingStrategy{
	public int calPrice(int basePrice);
}

class Strategy1 implements PricingStrategy{
	@Override
	public int calPrice(int basePrice) {
		return basePrice + 10;
	}
	
}

class Strategy2 implements PricingStrategy{
	@Override
	public int calPrice(int basePrice) {
		return basePrice * 2;
	}
	
}

class Product{
	
	String productName;
	int basePrice;
	PricingStrategy ps;
	
	public Product(String productName, int basePrice, PricingStrategy ps) {
		this.productName = productName;
		this.basePrice = basePrice;
		this.ps = ps;
	}
	
	public int getPrice() {
		if(ps == null) {
			throw new IllegalStateException("Pricing strategy not set");
		}
		return ps.calPrice(basePrice);
	}
	
}
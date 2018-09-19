package hello;

import javax.persistence.Id;

public class Product {
	
    private final long id;
    private final String name;
    private final String compagny; // vendue par
    private final int price;
    private final int quantity;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCompagny() {
		return compagny;
	}
	public Product(long id, String name, String compagny, int price,int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.compagny = compagny;
		this.price = price;
		this.quantity=quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", compagny=" + compagny+" price="+price;
	}
	public int getPrice() {
		return price;
	}
}

package hello;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
    private final long id;
    private final String name;
    private final String compagny; // vendue par
    private final int price;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCompagny() {
		return compagny;
	}
	public Product(long id, String name, String compagny, int price) {
		super();
		this.id = id;
		this.name = name;
		this.compagny = compagny;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", compagny=" + compagny+" price="+price;
	}
	public int getPrice() {
		return price;
	}
}

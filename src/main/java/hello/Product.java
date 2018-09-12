package hello;



public class Product {

    private final long id;
    private final String name;
    private final String compagny; // vendue par
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
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", compagny=" + compagny;
	}
}

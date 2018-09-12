package Model;

import java.util.List;

import hello.Product;

public class ServiceProduct {
	
	List<Product> listeProducts; 
	
	
	public ServiceProduct(List<Product> listeProducts) {
		super();
		this.listeProducts = listeProducts;
	}
	public void add(Product p) {
		listeProducts.add(p);
	}
	public void del(int id) {
		Product p= null;
		for (Product product : listeProducts) {
			if(product.getId()==id) {
				p=product;
			}
		}
		listeProducts.remove(p);
	}
	
	public List<Product> getListeProducts() {
		return listeProducts;
	}
	public void setListeProducts(List<Product> listeProducts) {
		this.listeProducts = listeProducts;
	}

}
